package com.zybooks.snackulator.data

enum class Category{
    Hot_Coffee, Cold_Coffee, Hot_Tea, Cold_Tea,
    Refreshers, Frappuccino, Iced_Energy, Hot_Chocolate,
    Lemonade, Milk, Steamers
}

enum class Type{
    Brewed_Coffee, Americano, Latte, Cappuccino, Mocha,
    Macchiato, Flat_White, Cortado, Espresso_Shot, Coffee_Travler,
    Cold_Brew, Nitro_Cold_Brew, Iced_Coffee, Iced_Shaken_Espresso,
    Iced_Americano, Tea_Latte, Brewed_Tea, Iced_Tea_Latte, Iced_Tea,
    Tea_Frappuccino, Lemonade_Refreshers, Coconutmilk_Refreshers,
    Refreshers, Coffee_Frappuccino, Creme_Frappuccino, Iced_Energy, Hot_Chocolate,
    Lemonade, Cold_Milk, Steamers

}

enum class Size{
    Tall, Grande, Venti, Trenta
}

enum class EspressoType{
    Signature, Blonde, Decaf, None, Half_Decaf
}

enum class Flavors{
    Powders, Sauces, Syrups
}

enum class Milks{
    Two_Percent, Almond, Breve, Coconut, Nonfat, Oatmilk, Soy, Whole_Milk,
    Vanilla_Sweet_Cream, Heavy_Cream, NonDairy_Vanilla_Sweet_Cream
}

enum class Toppings{
    Caramel_Crunch_Topping, Cherry_Crunch_Sweet_Topping, Cinnamon_Dolce_Sprinkles,
    Cookie_Crumble_Topping, Salted_Brown_Buttery_Topping
}

enum class RefresherBases{
    Blackberry_Sage, Mango_Dragonfruit, Strawberry_acai
}


data class Milk(
    val milk_type: Milks,
    val calories: Double,
    val carbs: Double,
    val fat: Double,
    val sodium: Double,
    val protein: Double
)

data class Syrup(
    val f_type: Flavors,
    val name: String,
    val calories: Double,
    val carbs: Double,
    val fat: Double,
    val sodium: Double,
    val protein: Double
)

data class Sauce(
    val f_type: Flavors,
    val name: String,
    val calories: Double,
    val carbs: Double,
    val fat: Double,
    val sodium: Double,
    val protein: Double
)

data class Powder(
    val f_type: Flavors,
    val name: String,
    val calories: Double,
    val carbs: Double,
    val fat: Double,
    val sodium: Double,
    val protein: Double
)




data class Espresso(
    val espressoType: EspressoType,
    val calories: Double,
    val carbs: Double,
    val fat: Double,
    val sodium: Double,
    val protein: Double
)

data class Topping(
    val toppingType: Toppings,
    val calories: Double,
    val carbs: Double,
    val fat: Double,
    val sodium: Double,
    val protein: Double
)

class WhippedCream(
    val calories: Double = 50.0,
    val carbs: Double = 3.0,
    val fat: Double = 4.0,
    val sodium: Double = 5.0,
    val protein: Double = 0.3
)




