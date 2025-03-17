package com.zybooks.snackulator.data

class EspressoDataSource {
    private val EspressoList = listOf(
        Espresso(EspressoType.Signature, calories = 2.0, carbs = 0.0, fat = 0.0, sodium = 5.0, protein = 0.1),
        Espresso(EspressoType.Blonde, calories = 2.0, carbs = 0.0, fat = 0.0, sodium = 5.0, protein = 0.1),
        Espresso(EspressoType.Decaf, calories = 2.0, carbs = 0.0, fat = 0.0, sodium = 5.0, protein = 0.1),
        Espresso(EspressoType.None, calories = 0.0, carbs = 0.0, fat = 0.0, sodium = 0.0, protein = 0.0),
        Espresso(EspressoType.Half_Decaf, calories = 2.0, carbs = 0.0, fat = 0.0, sodium = 5.0, protein = 0.1)
    )

    fun getEspressoList(): List<Espresso> = EspressoList

    fun findEspresso(e : EspressoType): Espresso?{
        return getEspressoList().find { it.espressoType == e }
    }
}