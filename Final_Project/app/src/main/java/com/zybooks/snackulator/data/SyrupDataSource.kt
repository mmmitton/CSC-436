package com.zybooks.snackulator.data

class SyrupDataSource {
    private val SyrupList = listOf(
        Syrup(Flavors.Syrups,SyrupTypes.Vanilla,"Vanilla Syrup",
            20.0,5.0,0.0,0.0,0.0),
        Syrup(Flavors.Syrups, SyrupTypes.Brown_Sugar,"Brown Sugar Syrup",
            20.0,5.0,0.0,0.0,0.0),
        Syrup(Flavors.Syrups,SyrupTypes.Cinnamon_Dolce,"Cinnamon Dolce Syrup",
            20.0,5.0,0.0,0.0,0.0),
        Syrup(Flavors.Syrups, SyrupTypes.Hazelnut,"Hazelnut Syrup",
            20.0,5.0,0.0,0.0,0.0),
        Syrup(Flavors.Syrups,SyrupTypes.Peppermint,"Peppermint Syrup",
            20.0,5.0,0.0,0.0,0.0),
        Syrup(Flavors.Syrups,SyrupTypes.SF_Vanilla,"Sugar Free Vanilla Syrup",
            0.0,0.0,0.0,5.0,0.0)

    )

    fun getSyrupList(): List<Syrup> = SyrupList

    fun findSyrup(st: SyrupTypes): Syrup? {
        return getSyrupList().find { it.s_type == st }
    }
}