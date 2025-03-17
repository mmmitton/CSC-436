package com.zybooks.snackulator.data

class SauceDataSource {
    private val SauceList = listOf(
        Sauce(Flavors.Sauces, SauceTypes.Mocha,"Mocha Sauce",
            calories = 20.0, carbs = 5.0, fat = 0.5, sodium = 5.0, protein = 0.3),
        Sauce(Flavors.Sauces, SauceTypes.Caramel,"Dark Caramel Sauce",
            calories = 25.0, carbs = 6.0, fat = 1.0, sodium = 10.0, protein = 0.2),
        Sauce(Flavors.Sauces,SauceTypes.Pistachio, "Pistachio Sauce",
            calories = 25.0, carbs = 5.0, fat = 1.5, sodium = 10.0, protein = 0.3),
        Sauce(Flavors.Sauces, SauceTypes.WC_Mocha, "White Chocolate Mocha Sauce",
            calories = 25.0, carbs = 6.0, fat = 1.0, sodium = 5.0, protein = 0.3)
    )

    fun getSauceList(): List<Sauce> = SauceList

    fun findSauce(type: SauceTypes): Sauce? {
        return getSauceList().find { it.sauce_type == type }
    }
}