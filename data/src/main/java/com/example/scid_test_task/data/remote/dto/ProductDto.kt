package com.example.scid_test_task.data.remote.dto

import com.example.scid_test_task.domain.model.Product
import com.example.scid_test_task.domain.model.Rating
import com.google.gson.annotations.SerializedName

data class ProductDto(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: RatingDto
) {
    fun toDomain(): Product {
        return Product(
            id = id,
            title = title,
            price = price,
            description = description,
            category = category,
            image = image,
            rating = rating.toDomain()
        )
    }
}

data class RatingDto(
    val rate: Double,
    val count: Int
) {
    fun toDomain(): Rating {
        return Rating(
            rate = rate,
            count = count
        )
    }
}

