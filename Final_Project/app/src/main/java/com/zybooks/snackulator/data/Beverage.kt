package com.zybooks.snackulator.data

data class Beverage(
    val category: Category,
    val type: Type,
    val name: String,
    val size: Size,
    var milk: Milk? = null,           // Nullable to allow for beverages without milk
    var syrups: MutableMap<Syrup, Int> = mutableMapOf(), // List for multiple syrups
    var sauces: MutableMap<Sauce, Int> = mutableMapOf(), // Sauce -> Pump count
    var powders: MutableMap<Powder, Int> = mutableMapOf(), // Powder -> Scoop count
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