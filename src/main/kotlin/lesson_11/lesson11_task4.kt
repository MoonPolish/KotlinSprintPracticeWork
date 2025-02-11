package org.example.lesson_11

fun main() {

    // Сущность категории рецепта
    class RecipeCategory(
        val id: Int, // Идентификатор категории
        val name: String, // Название категории
    ) {
    }

    // Сущность ингридиента
    class Ingridient(
        val name: String, // Название ингридиента
        val quantity: Int, // Количество ингридиента
        val units: String // Единицы измерения
    ) {
    }

    // Сущность рецепта
    class Recipe(
        val id: Int, // Идентификатор рецепта
        val name: String, // Название рецепта
        val category: String, // Категория рецепта
        val quantityOfServings: Int, // Количество порций
        val ingridients: List<Ingridient>, // Список ингридиентов
        val quantityPortions: Int, // Количество порций
        val instructions: String, // Способ приготовления
    ) {
    }
}



