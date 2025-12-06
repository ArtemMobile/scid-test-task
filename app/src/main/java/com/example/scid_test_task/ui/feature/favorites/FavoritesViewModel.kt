package com.example.scid_test_task.ui.feature.favorites

import androidx.lifecycle.viewModelScope
import com.example.scid_test_task.domain.model.Product
import com.example.scid_test_task.domain.usecase.GetFavoritesUseCase
import com.example.scid_test_task.domain.usecase.RemoveFromFavoritesUseCase
import com.example.scid_test_task.core.mvi.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val removeFromFavoritesUseCase: RemoveFromFavoritesUseCase
) : MVIViewModel<FavoritesEvents>() {

    private val _favorites = MutableStateFlow<List<Product>>(emptyList())
    val favorites: StateFlow<List<Product>> = _favorites.asStateFlow()

    init {
        loadFavorites()
    }

    override fun doEvent(event: FavoritesEvents) {
        when (event) {
            is FavoritesEvents.RemoveFavorite -> removeFavorite(event.productId)
        }
    }

    private fun loadFavorites() {
        viewModelScope.launch {
            getFavoritesUseCase().collect { products ->
                _favorites.value = products
            }
        }
    }

    private fun removeFavorite(productId: Int) {
        viewModelScope.launch {
            removeFromFavoritesUseCase(productId)
        }
    }
}

