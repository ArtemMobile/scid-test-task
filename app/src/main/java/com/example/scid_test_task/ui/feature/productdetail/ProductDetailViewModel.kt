package com.example.scid_test_task.ui.feature.productdetail

import androidx.lifecycle.viewModelScope
import com.example.scid_test_task.domain.model.Product
import com.example.scid_test_task.domain.usecase.AddToFavoritesUseCase
import com.example.scid_test_task.domain.usecase.GetProductByIdUseCase
import com.example.scid_test_task.domain.usecase.IsFavoriteUseCase
import com.example.scid_test_task.domain.usecase.RemoveFromFavoritesUseCase
import com.example.scid_test_task.domain.util.Result
import com.example.scid_test_task.core.mvi.MVIViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = ProductDetailViewModel.Factory::class)
class ProductDetailViewModel @AssistedInject constructor(
    private val getProductByIdUseCase: GetProductByIdUseCase,
    private val addToFavoritesUseCase: AddToFavoritesUseCase,
    private val removeFromFavoritesUseCase: RemoveFromFavoritesUseCase,
    private val isFavoriteUseCase: IsFavoriteUseCase,
    @Assisted private val productId: Int
) : MVIViewModel<ProductDetailEvents>() {

    @AssistedFactory
    interface Factory {
        fun create(productId: Int): ProductDetailViewModel
    }

    private val _productState = MutableStateFlow<Result<Product>>(Result.Loading)
    val productState: StateFlow<Result<Product>> = _productState.asStateFlow()

    private val _isFavorite = MutableStateFlow(false)
    val isFavorite: StateFlow<Boolean> = _isFavorite.asStateFlow()

    init {
        loadProduct()
    }

    override fun doEvent(event: ProductDetailEvents) {
        when (event) {
            is ProductDetailEvents.Refresh -> refresh()
            is ProductDetailEvents.ToggleFavorite -> toggleFavorite()
        }
    }

    private fun loadProduct() {
        viewModelScope.launch {
            _productState.value = Result.Loading
            _productState.value = getProductByIdUseCase(productId)
            when (val result = _productState.value) {
                is Result.Success -> {
                    _isFavorite.value = isFavoriteUseCase(productId)
                }
                is Result.Error -> {}
                is Result.Loading -> {}
            }
        }
    }

    private fun refresh() {
        loadProduct()
    }

    private fun toggleFavorite() {
        val product = (_productState.value as? Result.Success)?.data ?: return
        viewModelScope.launch {
            try {
                if (_isFavorite.value) {
                    removeFromFavoritesUseCase(product.id)
                    _isFavorite.value = false
                } else {
                    addToFavoritesUseCase(product)
                    _isFavorite.value = true
                }
            } catch (e: Exception) {

            }
        }
    }
}

