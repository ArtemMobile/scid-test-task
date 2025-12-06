package com.example.scid_test_task.ui.feature.products

import androidx.lifecycle.viewModelScope
import com.example.scid_test_task.domain.model.Product
import com.example.scid_test_task.domain.usecase.GetCategoriesUseCase
import com.example.scid_test_task.domain.usecase.GetProductsUseCase
import com.example.scid_test_task.domain.util.Result
import com.example.scid_test_task.core.mvi.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val getCategoriesUseCase: GetCategoriesUseCase
) : MVIViewModel<ProductsEvents>() {
    private val _selectedCategory = MutableStateFlow<String?>(null)
    val selectedCategory: StateFlow<String?> = _selectedCategory.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>> = _categories.asStateFlow()

    private val _productsState = MutableStateFlow<Result<List<Product>>>(Result.Loading)
    val productsState: StateFlow<Result<List<Product>>> = _productsState.asStateFlow()

    private val _categoriesState = MutableStateFlow<Result<List<String>>>(Result.Loading)
    val categoriesState: StateFlow<Result<List<String>>> = _categoriesState.asStateFlow()

    private val productsCache = mutableMapOf<String?, List<Product>>()

    init {
        doEvent(ProductsEvents.Init)
    }

    override fun doEvent(event: ProductsEvents) {
        when (event) {
            is ProductsEvents.Init -> {
                loadCategories()
                loadProducts()
            }
            is ProductsEvents.LoadCategories -> loadCategories()
            is ProductsEvents.SelectCategory -> selectCategory(event.category)
            is ProductsEvents.UpdateSearchQuery -> updateSearchQuery(event.query)
            is ProductsEvents.LoadProducts -> loadProducts()
            is ProductsEvents.RefreshProducts -> refreshProducts()
        }
    }

    private fun loadCategories() {
        viewModelScope.launch {
            _categoriesState.value = Result.Loading
            _categoriesState.value = getCategoriesUseCase()
            when (val result = _categoriesState.value) {
                is Result.Success -> {
                    _categories.value = result.data
                }
                is Result.Error -> {
                    _categories.value = emptyList()
                }
                is Result.Loading -> {}
            }
        }
    }

    private fun selectCategory(category: String?) {
        if (_selectedCategory.value != category) {
            _selectedCategory.value = category
            loadProducts()
        }
    }

    private fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    private fun loadProducts() {
        val category = _selectedCategory.value
        if (productsCache.containsKey(category)) {
            _productsState.value = Result.Success(productsCache[category] ?: emptyList())
            return
        }

        viewModelScope.launch {
            _productsState.value = Result.Loading
            when (val result = getProductsUseCase(category)) {
                is Result.Success -> {
                    productsCache[category] = result.data
                    _productsState.value = result
                }
                is Result.Error -> {
                    val cached = productsCache[category]
                    if (cached != null) {
                        _productsState.value = Result.Success(cached)
                    } else {
                        _productsState.value = result
                    }
                }
                is Result.Loading -> {
                    _productsState.value = result
                }
            }
        }
    }

    private fun refreshProducts() {
        val category = _selectedCategory.value
        productsCache.remove(category)
        loadCategories()
        loadProducts()
    }
}

