package com.zybooks.snackulator.data

class SyrupDataSource {
    private val SyrupList = listOf(
        Syrup(Flavors.Syrups,"Vanilla Syrup",
            20.0,5.0,0.0,0.0,0.0),
        Syrup(Flavors.Syrups,"Brown Sugar Syrup",
            20.0,5.0,0.0,0.0,0.0),
        Syrup(Flavors.Syrups,"Cinnamon Dolce Syrup",
            20.0,5.0,0.0,0.0,0.0),
        Syrup(Flavors.Syrups,"Hazelnut Syrup",
            20.0,5.0,0.0,0.0,0.0),
        Syrup(Flavors.Syrups,"Peppermint Syrup",
            20.0,5.0,0.0,0.0,0.0),
        Syrup(Flavors.Syrups,"Vanilla Syrup",
            20.0,5.0,0.0,0.0,0.0),
        Syrup(Flavors.Syrups,"Sugar Free Vanilla Syrup",
            0.0,0.0,0.0,5.0,0.0)

    )

    fun getSyrupList(): List<Syrup> = SyrupList
}