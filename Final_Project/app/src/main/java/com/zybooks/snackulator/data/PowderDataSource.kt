package com.zybooks.snackulator.data

class PowderDataSource {

    private val PowderList = listOf(
        Powder(Flavors.Powders, PowderTypes.Cherry,"Cherry Sweet Powder",
            calories = 30.0, carbs = 7.0, fat = 0.1, sodium = 45.0, protein = 0.3),
        Powder(Flavors.Powders, PowderTypes.Chocolate,"Chocolate Malt Powder",
            calories = 40.0, carbs = 9.0, fat = 0.5, sodium = 55.0, protein = 1.0),
        Powder(Flavors.Powders, PowderTypes.Lavender, "Lavender Powder",
            calories = 25.0, carbs = 6.0, fat = 0.1, sodium = 20.0, protein = 0.3),
        Powder(Flavors.Powders, PowderTypes.Vanilla,"Vanilla Bean Powder",
            calories = 50.0, carbs = 11.0, fat = 1.0, sodium = 15.0, protein = 1.0),
        Powder(Flavors.Powders, PowderTypes.Matcha,"Matcha Green Tea",
            calories = 25.0, carbs = 6.0, fat = 0.1, sodium = 0.0, protein = 1.0)
    )

    fun getPowderList(): List<Powder> = PowderList

    fun findPowder(type: PowderTypes): Powder? {
        return getPowderList().find { it.p_type == type }
    }

}