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
}
