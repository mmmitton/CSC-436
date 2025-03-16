package com.zybooks.snackulator.data

data class Beverage(
    val category: Category,
    val type: Type,
    val name: String,
    val size: Size,
    var milk: Milk? = null,           // Nullable to allow for beverages without milk
    var syrups: List<Syrup> = emptyList(), // List for multiple syrups
    var sauces: List<Sauce> = emptyList(), // List for multiple sauces
    var powders: List<Powder> = emptyList(), // List for multiple powders
    var espresso: Espresso? = null,   // Nullable for beverages without espresso
    var whippedCream: WhippedCream? = null, // Nullable for beverages with or without whipped cream
    var toppings: List<Topping> = emptyList() // List for multiple toppings
){
    fun calculateCalories(){}

    fun calculateCarbs(){}

    fun calculateFat(){}

    fun calculateSodium(){}

    fun calculateProtein(){}
}