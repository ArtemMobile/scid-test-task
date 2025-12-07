package com.example.scid_test_task.ui.feature.products

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.scid_test_task.domain.model.Product
import com.example.scid_test_task.domain.repository.ProductRepository
import com.example.scid_test_task.domain.usecase.GetCategoriesUseCase
import com.example.scid_test_task.domain.util.Result
import com.example.scid_test_task.core.mvi.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    private val getCategoriesUseCase: GetCategoriesUseCase
) : MVIViewModel<ProductsEvents>() {
    private val _selectedCategory = MutableStateFlow<String?>(null)
    val selectedCategory: StateFlow<String?> = _selectedCategory.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>> = _categories.asStateFlow()

    private val _categoriesState = MutableStateFlow<Result<List<String>>>(Result.Loading)
    val categoriesState: StateFlow<Result<List<String>>> = _categoriesState.asStateFlow()

    @OptIn(ExperimentalCoroutinesApi::class)
    val productsPaged: Flow<PagingData<Product>> = _selectedCategory
        .flatMapLatest { category ->
            productRepository.getProductsPaged(category)
        }
        .cachedIn(viewModelScope)

    init {
        doEvent(ProductsEvents.Init)
    }

    override fun doEvent(event: ProductsEvents) {
        when (event) {
            is ProductsEvents.Init -> {
                loadCategories()
            }
            is ProductsEvents.SelectCategory -> selectCategory(event.category)
            is ProductsEvents.UpdateSearchQuery -> updateSearchQuery(event.query)
            ProductsEvents.RefreshScreen -> {
                _searchQuery.update { "" }
                _categories.update { emptyList() }
                loadCategories()
            }
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
        }
    }

    private fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }
}

