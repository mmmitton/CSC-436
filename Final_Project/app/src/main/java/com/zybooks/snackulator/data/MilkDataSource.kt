package com.zybooks.snackulator.data
// milk is per oz

class MilkDataSource {
    private val MilkList = listOf(
        Milk(Milks.Two_Percent,
            calories = 6.0, carbs = 0.75, fat = 0.3, sodium = 5.0, protein = 0.4),
        Milk(Milks.Almond,
            calories = 2.5, carbs = 0.08, fat = 0.21, sodium = 12.5, protein = 0.04),
        Milk(Milks.Breve,
            calories = 10.0, carbs = 1.0, fat = 1.0, sodium = 10.0, protein = 0.5),
        Milk(Milks.Coconut,
            calories = 4.5, carbs = 0.29, fat = 0.21, sodium = 1.67, protein = 0.02),
        Milk(Milks.Nonfat,
            calories = 5.0, carbs = 1.0, fat = 0.01, sodium = 4.2, protein = 0.3),
        Milk(Milks.Oatmilk,
            calories = 10.0, carbs = 1.33, fat = 0.42, sodium = 4.2, protein = 0.13),
        Milk(Milks.Soy,
            calories = 5.5, carbs = 0.75, fat = 0.19, sodium = 3.75, protein = 0.29),
        Milk(Milks.Whole_Milk,
            calories = 9.0, carbs = 1.0, fat = 0.5, sodium = 4.0, protein = 0.3),
        Milk(Milks.Vanilla_Sweet_Cream,
            calories = 20.0, carbs = 2.0, fat = 1.0, sodium = 10.0, protein = 0.3),
        Milk(Milks.Heavy_Cream,
            calories = 52.0, carbs = 0.4, fat = 5.0, sodium = 5.0, protein = 0.3),
        Milk(Milks.NonDairy_Vanilla_Sweet_Cream,
            calories = 25.0, carbs = 3.0, fat = 1.5, sodium = 10.0, protein = 0.1)
    )

    fun getMilkList(): List<Milk> = MilkList

    fun findMilk(milkType: Milks): Milk? {
        return getMilkList().find { it.milk_type == milkType }
    }
}