import java.lang.IllegalArgumentException

class KitchenWithBuilder {
    var fridge: Fridge? = null
    var powerSocket: PowerSocket? = null
    var sink: Sink? = null
    var waterPipe: WaterPipe? = null

    private constructor(fridge: Fridge?, powerSocket: PowerSocket?, sink: Sink?, waterPipe: WaterPipe?) {
        this.fridge = fridge
        this.powerSocket = powerSocket
        this.sink = sink
        this.waterPipe = waterPipe
    }

    class KitchenBuilder {
        private var fridge: Fridge? = null
        private var powerSocket: PowerSocket? = null
        private var sink: Sink? = null
        private var waterPipe: WaterPipe? = null

        fun setFridge(fridge: Fridge) : KitchenBuilder {
            this.fridge = fridge
            return this
        }

        fun setPowerSocket(powerSocket: PowerSocket) : KitchenBuilder {
            this.powerSocket = powerSocket
            return this
        }

        fun setSink(sink: Sink) : KitchenBuilder {
            this.sink = sink
            return this
        }

        fun setWaterPipe(waterPipe: WaterPipe) : KitchenBuilder {
            this.waterPipe = waterPipe
            return this
        }

        fun build(): KitchenWithBuilder {
            return KitchenWithBuilder(fridge, powerSocket, sink, waterPipe)
        }
    }
    fun use() {
        if (((fridge == null) xor (powerSocket == null)) or ((sink == null) xor (waterPipe == null))) {
            throw IllegalArgumentException("This kitchen is not functional")
        }
        println("This kitchen works fine.")
    }
}