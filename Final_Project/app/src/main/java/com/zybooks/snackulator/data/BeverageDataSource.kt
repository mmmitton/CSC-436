package com.zybooks.snackulator.data
import com.zybooks.snackulator.R
import androidx.compose.runtime.mutableStateMapOf

class BeverageDataSource {
    val Caffe_Latte = Beverage(
        pic = R.drawable.caffe_latte_logo,
        name = "Caffe Latte",
        size = Size.Grande,
        milk = MilkDataSource().findMilk(Milks.Two_Percent),
        espresso = EspressoDataSource().findEspresso(EspressoType.Signature),
        syrups = mutableStateMapOf(),   // Observable, stateful map for syrups
        sauces = mutableStateMapOf(),   // If you plan to update sauces similarly
        powders = mutableStateMapOf()   // If you plan to update powders similarly
    )

    val Lavender_Oatmilk_Latte = Beverage(
        pic = R.drawable.lavender_oatmilk_latte,
        name = "Lavender Oatmilk Latte",
        size = Size.Grande,
        milk = MilkDataSource().findMilk(Milks.Oatmilk),
        espresso = EspressoDataSource().findEspresso(EspressoType.Signature),
        syrups = mutableStateMapOf(),   // Observable, stateful map for syrups
        sauces = mutableStateMapOf(),   // If you plan to update sauces similarly
        powders = mutableStateMapOf(PowderDataSource().findPowder(PowderTypes.Lavender)!! to 3)   // If you plan to update powders similarly
    )

    val Mocha_Cookie_Frap = Beverage(
        pic = R.drawable.mocha_cookie_frap_logo,
        name = "Mocha Cookie Crumble Frappuccino",
        size = Size.Grande,
        milk = MilkDataSource().findMilk(Milks.Whole_Milk),
        toppings = listOf(ToppingDataSource().findTopping(Toppings.Cookie_Crumble_Topping)!!),
        espresso = EspressoDataSource().findEspresso(EspressoType.Signature),
        syrups = mutableStateMapOf(),   // Observable, stateful map for syrups
        sauces = mutableStateMapOf(SauceDataSource().findSauce(SauceTypes.Mocha)!! to 3),   // If you plan to update sauces similarly
        powders = mutableStateMapOf()   // If you plan to update powders similarly
    )
}
