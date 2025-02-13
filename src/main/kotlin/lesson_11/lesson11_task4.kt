package org.example.lesson_11

fun main() {

    class RecipeCategory(
        val id: Int,
        val name: String,
        val recipeName: String,
    ) {
    }

    class Ingridient(
        val name: String,
        val quantity: Int,
        val units: String
    ) {
    }

    class Recipe(
        val id: Int,
        val name: String,
        val category: String,
        val quantityOfServings: Int,
        val ingridients: List<Ingridient>,
        val quantityPortions: Int,
        val instructions: String,
    ) {
    }
}



