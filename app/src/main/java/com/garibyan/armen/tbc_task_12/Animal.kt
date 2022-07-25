package com.garibyan.armen.tbc_task_12

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Animal(val imageSrc: Int,
                  val title: String,
                  val description: String): Parcelable