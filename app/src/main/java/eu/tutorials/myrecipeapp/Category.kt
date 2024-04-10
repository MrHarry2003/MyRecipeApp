package eu.tutorials.myrecipeapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
//using parcelize objects can be serialized into formats suitable for storage or transmission
//and then deserialized into original form
//category is to be passed into other screen when clicked thats why it is made parcelable
@Parcelize
data class Category(val idCategory:String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String):Parcelable


data class CategoriesResponse(val categories: List<Category>)