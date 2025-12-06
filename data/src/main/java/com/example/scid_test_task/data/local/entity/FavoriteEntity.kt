package com.example.scid_test_task.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.scid_test_task.domain.model.Product
import com.example.scid_test_task.domain.model.Rating

@Entity(tableName = "favorites")
data class FavoriteEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val ratingRate: Double,
    val ratingCount: Int,
    val timestamp: Long = System.currentTimeMillis()
) {
    fun toDomain(): Product {
        return Product(
            id = id,
            title = title,
            price = price,
            description = description,
            category = category,
            image = image,
            rating = Rating(rate = ratingRate, count = ratingCount)
        )
    }

    companion object {
        fun fromDomain(product: Product): FavoriteEntity {
            return FavoriteEntity(
                id = product.id,
                title = product.title,
                price = product.price,
                description = product.description,
                category = product.category,
                image = product.image,
                ratingRate = product.rating.rate,
                ratingCount = product.rating.count
            )
        }
    }
}

