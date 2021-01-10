import java.lang.IllegalArgumentException

class Kitchen : Room {
    var fridge: Fridge? = null
    var powerSocket: PowerSocket? = null

    private constructor(fridge: Fridge?, powerSocket: PowerSocket?, drawer: Drawer?, sink: Sink?, waterPipe: WaterPipe?) : super(drawer, sink, waterPipe) {
        this.fridge = fridge
        this.powerSocket = powerSocket
    }

    override fun use() {
        // this will never fail
        if (((fridge == null) xor (powerSocket == null)) or ((sink == null) xor (waterPipe == null))) {
            throw IllegalArgumentException("This kitchen is not functional")
        }
        println("This kitchen works fine.")
    }

    interface FridgeStep {
        fun setFridge(fridge: Fridge) : PowerSocketStep
        fun build() : Kitchen
    }

    interface PowerSocketStep {
        fun setPowerSocket(powerSocket: PowerSocket) : DrawerStep<Kitchen>
    }

    private class KitchenBuilder : RoomBuilder<Kitchen>(), FridgeStep, PowerSocketStep {
        var fridge: Fridge? = null
        var powerSocket: PowerSocket? = null

        override fun setFridge(fridge: Fridge): PowerSocketStep {
            this.fridge = fridge
            return this
        }

        override fun setPowerSocket(powerSocket: PowerSocket): DrawerStep<Kitchen> {
            this.powerSocket = powerSocket
            return this
        }

        override fun build(): Kitchen {
            return Kitchen(fridge, powerSocket, drawer, sink, waterPipe)
        }
    }
    companion object {
        fun Builder(): FridgeStep {
            return KitchenBuilder()
        }
    }
}