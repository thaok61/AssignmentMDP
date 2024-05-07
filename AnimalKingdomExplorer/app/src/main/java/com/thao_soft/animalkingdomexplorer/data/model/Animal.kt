package com.thao_soft.animalkingdomexplorer.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Animal(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val habitat: String,
    val diet: String,
)