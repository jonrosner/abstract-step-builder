fun main() {
    val kitchen = KitchenWithConstructors()
    val kitchen2 = KitchenWithBuilder.KitchenBuilder().setFridge(Fridge())
    val kitchen3 = KitchenWithStepBuilder.Builder().setFridge(Fridge()).setPowerSocket(PowerSocket()).build()
    val kitchen4 = Kitchen.Builder().setFridge(Fridge()).setPowerSocket(PowerSocket()).setDrawer(Drawer()).build()

    println(kitchen4.use())
}