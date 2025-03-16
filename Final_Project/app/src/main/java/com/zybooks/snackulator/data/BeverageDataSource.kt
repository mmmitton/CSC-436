package com.zybooks.snackulator.data

class BeverageDataSource {

    private val defaultBeverages = mapOf(
        "Caffe Latte" to Beverage(
            category = Category.Hot_Coffee,
            type = Type.Latte,
            name = "Caffe Latte",
            size = Size.Grande,
            milk = MilkDataSource().findMilk(Milks.Two_Percent),
            espresso = EspressoDataSource().getEspressoList().find { it.espressoType == EspressoType.Signature }
        ),
        "Cappuccino" to Beverage(
            category = Category.Hot_Coffee,
            type = Type.Cappuccino,
            name = "Cappuccino",
            size = Size.Grande,
            milk = MilkDataSource().findMilk(Milks.Nonfat),
            espresso = EspressoDataSource().getEspressoList().find { it.espressoType == EspressoType.Signature }
        ),
        "Caramel Macchiato" to Beverage(
            category = Category.Hot_Coffee,
            type = Type.Macchiato,
            name = "Caramel Macchiato",
            size = Size.Grande,
            milk = MilkDataSource().findMilk(Milks.Two_Percent),
            espresso = EspressoDataSource().getEspressoList().find { it.espressoType == EspressoType.Signature },
            syrups = mutableMapOf(
                SyrupDataSource().getSyrupList().find { it.name == "Vanilla Syrup" }!! to 3 // Default 3 pumps
            ),
            sauces = mutableMapOf(
                SauceDataSource().getSauceList().find { it.name == "Dark Caramel Sauce" }!! to 2 // Default 2 pumps
            )
        ),
        "Mocha" to Beverage(
            category = Category.Hot_Coffee,
            type = Type.Mocha,
            name = "Mocha",
            size = Size.Grande,
            milk = MilkDataSource().findMilk(Milks.Two_Percent),
            espresso = EspressoDataSource().getEspressoList().find { it.espressoType == EspressoType.Signature },
            sauces = mutableMapOf(
                SauceDataSource().getSauceList().find { it.name == "Mocha Sauce" }!! to 3 // Default 3 pumps
            ),
            whippedCream = WhippedCream()
        )
    )

    fun getDefaultBeverage(name: String): Beverage? {
        return defaultBeverages[name]?.copy()
    }

    fun modifyBeverage(
        beverage: Beverage,
        newMilk: Milks? = null,
        newEspresso: EspressoType? = null,
        newSyrups: Map<String, Int> = emptyMap(), // Map of Syrup Name -> Pump Count
        newSauces: Map<String, Int> = emptyMap(), // Map of Sauce Name -> Pump Count
        newToppings: List<Toppings> = emptyList(),
        addWhippedCream: Boolean? = null
    ) {
        // Update milk if provided
        newMilk?.let { beverage.milk = MilkDataSource().findMilk(it) }

        // Update espresso if provided
        newEspresso?.let { beverage.espresso = EspressoDataSource().getEspressoList().find { e -> e.espressoType == it } }

        // Update syrups: clear existing and add new ones with specified pump counts
        beverage.syrups.clear()
        newSyrups.forEach { (name, count) ->
            SyrupDataSource().getSyrupList().find { it.name == name }?.let { syrup ->
                beverage.syrups[syrup] = count
            }
        }

        // Update sauces: clear existing and add new ones with specified pump counts
        beverage.sauces.clear()
        newSauces.forEach { (name, count) ->
            SauceDataSource().getSauceList().find { it.name == name }?.let { sauce ->
                beverage.sauces[sauce] = count
            }
        }

        // Update toppings
        beverage.toppings = newToppings.mapNotNull { type ->
            ToppingDataSource().getToppingList().find { it.toppingType == type }
        }

        // Handle whipped cream update
        if (addWhippedCream == true) {
            beverage.whippedCream = WhippedCream()
        } else if (addWhippedCream == false) {
            beverage.whippedCream = null
        }
    }

}
