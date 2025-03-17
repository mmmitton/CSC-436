package com.zybooks.snackulator.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Beverage(
    pic: Int,
    name: String,
    size: Size,
    milk: Milk? = null,
    syrups: MutableMap<Syrup, Int>? = null,
    sauces: MutableMap<Sauce, Int>? = null,
    powders: MutableMap<Powder, Int>? = null,
    espresso: Espresso? = null,
    whippedCream: WhippedCream? = null,
    toppings: List<Topping>? = null
) {
    var pic by mutableStateOf(pic)
    var name by mutableStateOf(name)
    var size by mutableStateOf(size)
    var milk by mutableStateOf(milk)
    var syrups by mutableStateOf(syrups)
    var sauces by mutableStateOf(sauces)
    var powders by mutableStateOf(powders)
    var espresso by mutableStateOf(espresso)
    var whippedCream by mutableStateOf(whippedCream)
    var toppings by mutableStateOf(toppings)

    fun getOunces(): Int {
        return when (size) {
            Size.Tall -> 10
            Size.Grande -> 16
            Size.Venti -> 20
            else -> 30
        }
    }

    fun calculateCalories(): Double {
        var totalCalories = 0.0

        milk?.let { totalCalories += (it.calories * getOunces()) }
        syrups?.forEach { (syrup, quantity) ->
            totalCalories += syrup.calories * quantity
        }
        sauces?.forEach { (sauce, quantity) ->
            totalCalories += sauce.calories * quantity
        }
        powders?.forEach { (powder, quantity) ->
            totalCalories += powder.calories * quantity
        }
        espresso?.let { totalCalories += it.calories }
        whippedCream?.let { totalCalories += it.calories }
        toppings?.forEach { topping ->
            totalCalories += topping.calories
        }
        return totalCalories
    }

    fun calculateCarbs(): Double {
        var totalCarbs = 0.0

        milk?.let { totalCarbs += (it.carbs * getOunces()) }
        syrups?.forEach { (syrup, quantity) ->
            totalCarbs += syrup.carbs * quantity
        }
        sauces?.forEach { (sauce, quantity) ->
            totalCarbs += sauce.carbs * quantity
        }
        powders?.forEach { (powder, quantity) ->
            totalCarbs += powder.carbs * quantity
        }
        espresso?.let { totalCarbs += it.carbs }
        whippedCream?.let { totalCarbs += it.carbs }
        toppings?.forEach { topping ->
            totalCarbs += topping.carbs
        }
        return totalCarbs
    }

    fun calculateFat(): Double {
        var totalFat = 0.0

        milk?.let { totalFat += (it.fat * getOunces()) }
        syrups?.forEach { (syrup, quantity) ->
            totalFat += syrup.fat * quantity
        }
        sauces?.forEach { (sauce, quantity) ->
            totalFat += sauce.fat * quantity
        }
        powders?.forEach { (powder, quantity) ->
            totalFat += powder.fat * quantity
        }
        espresso?.let { totalFat += it.fat }
        whippedCream?.let { totalFat += it.fat }
        toppings?.forEach { topping ->
            totalFat += topping.fat
        }
        return totalFat
    }

    fun calculateSodium(): Double {
        var totalSodium = 0.0

        milk?.let { totalSodium += (it.sodium * getOunces()) }
        syrups?.forEach { (syrup, quantity) ->
            totalSodium += syrup.sodium * quantity
        }
        sauces?.forEach { (sauce, quantity) ->
            totalSodium += sauce.sodium * quantity
        }
        powders?.forEach { (powder, quantity) ->
            totalSodium += powder.sodium * quantity
        }
        espresso?.let { totalSodium += it.sodium }
        whippedCream?.let { totalSodium += it.sodium }
        toppings?.forEach { topping ->
            totalSodium += topping.sodium
        }
        return totalSodium
    }

    fun calculateProtein(): Double {
        var totalProtein = 0.0

        milk?.let { totalProtein += (it.protein * getOunces()) }
        syrups?.forEach { (syrup, quantity) ->
            totalProtein += syrup.protein * quantity
        }
        sauces?.forEach { (sauce, quantity) ->
            totalProtein += sauce.protein * quantity
        }
        powders?.forEach { (powder, quantity) ->
            totalProtein += powder.protein * quantity
        }
        espresso?.let { totalProtein += it.protein }
        whippedCream?.let { totalProtein += it.protein }
        toppings?.forEach { topping ->
            totalProtein += topping.protein
        }
        return totalProtein
    }
}
