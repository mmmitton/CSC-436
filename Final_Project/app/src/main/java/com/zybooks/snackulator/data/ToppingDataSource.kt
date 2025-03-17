package com.zybooks.snackulator.data

class ToppingDataSource {
    private val ToppingList = listOf(
        Topping(Toppings.Caramel_Crunch_Topping,
            calories = 40.0,
            carbs = 9.0,
            fat = 1.5,
            sodium = 10.0,
            protein = 0.2),
        Topping(Toppings.Cherry_Crunch_Sweet_Topping,
            calories = 35.0,
            carbs = 8.0,
            fat = 0.5,
            sodium = 5.0,
            protein = 0.1),
        Topping(Toppings.Cinnamon_Dolce_Sprinkles,
            calories = 30.0,
            carbs = 7.0,
            fat = 0.5,
            sodium = 15.0,
            protein = 0.1),
        Topping(Toppings.Cookie_Crumble_Topping,
            calories = 50.0,
            carbs = 8.5,
            fat = 2.0,
            sodium = 25.0,
            protein = 1.0),
        Topping(Toppings.Salted_Brown_Buttery_Topping,
            calories = 60.0,
            carbs = 7.0,
            fat = 3.0,
            sodium = 50.0,
            protein = 0.5)
    )

    fun getToppingList(): List<Topping> = ToppingList

    fun findTopping(name: Toppings): Topping? {
        return getToppingList().find { it.toppingType == name }
    }
}