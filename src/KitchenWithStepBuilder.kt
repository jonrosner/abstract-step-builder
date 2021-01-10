import java.lang.IllegalArgumentException

class KitchenWithStepBuilder {
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

    interface FridgeStep {
        fun setFridge(fridge: Fridge) : PowerSocketStep
        fun build() : KitchenWithStepBuilder
    }

    interface PowerSocketStep {
        fun setPowerSocket(powerSocket: PowerSocket) : SinkStep
    }

    interface SinkStep {
        fun setSink(sink: Sink) : WaterPipeStep
        fun build() : KitchenWithStepBuilder
    }

    interface WaterPipeStep {
        fun setWaterPipe(waterPipe: WaterPipe) : BuildStep
    }

    interface BuildStep {
        fun build() : KitchenWithStepBuilder
    }

    private class KitchenBuilder : FridgeStep, PowerSocketStep, SinkStep, WaterPipeStep, BuildStep {
        var fridge: Fridge? = null
        var powerSocket: PowerSocket? = null
        var sink: Sink? = null
        var waterPipe: WaterPipe? = null

        override fun setFridge(fridge: Fridge) : PowerSocketStep {
            this.fridge = fridge
            return this
        }

        override fun setPowerSocket(powerSocket: PowerSocket) : SinkStep {
            this.powerSocket = powerSocket
            return this
        }

        override fun setSink(sink: Sink) : WaterPipeStep {
            this.sink = sink
            return this
        }

        override fun setWaterPipe(waterPipe: WaterPipe) : BuildStep {
            this.waterPipe = waterPipe
            return this
        }

        override fun build(): KitchenWithStepBuilder {
            return KitchenWithStepBuilder(fridge, powerSocket, sink, waterPipe)
        }
    }

    fun use() {
        if (((fridge == null) xor (powerSocket == null)) or ((sink == null) xor (waterPipe == null))) {
            throw IllegalArgumentException("This kitchen is not functional")
        }
        println("This kitchen works fine.")
    }

    companion object {
        fun Builder(): FridgeStep {
            return KitchenBuilder()
        }
    }
}