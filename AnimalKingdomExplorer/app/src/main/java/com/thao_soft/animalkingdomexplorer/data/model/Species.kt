package com.thao_soft.animalkingdomexplorer.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Species(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val description: String,
)