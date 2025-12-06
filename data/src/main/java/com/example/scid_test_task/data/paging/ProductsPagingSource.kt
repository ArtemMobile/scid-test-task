package com.example.scid_test_task.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.scid_test_task.data.remote.api.FakeStoreApi
import com.example.scid_test_task.data.remote.dto.ProductDto
import com.example.scid_test_task.domain.model.Product

class ProductsPagingSource(
    private val api: FakeStoreApi,
    private val category: String?
) : PagingSource<Int, Product>() {

    private var cachedProducts: List<Product>? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        return try {
            if (cachedProducts == null) {
                val products: List<ProductDto> = if (category != null) {
                    api.getProductsByCategory(
                        category = category,
                        limit = 10000
                    )
                } else {
                    api.getProducts(limit = 10000)
                }
                cachedProducts = products
                    .map { it.toDomain() }
                    .distinctBy { it.id }
            }

            val allProducts = cachedProducts ?: emptyList()
            
            val startIndex = params.key ?: 0
            val pageSize = params.loadSize
            
            if (startIndex >= allProducts.size) {
                return LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
            
            val endIndex = (startIndex + pageSize).coerceAtMost(allProducts.size)
            val pageProducts = allProducts.subList(startIndex, endIndex)

            LoadResult.Page(
                data = pageProducts,
                prevKey = if (startIndex == 0) null else (startIndex - pageSize).coerceAtLeast(0),
                nextKey = if (endIndex >= allProducts.size) null else endIndex
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        cachedProducts = null
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}

