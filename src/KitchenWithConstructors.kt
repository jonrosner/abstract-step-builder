import java.lang.IllegalArgumentException

class KitchenWithConstructors() {
    var fridge: Fridge? = null
    var powerSocket: PowerSocket? = null
    var sink: Sink? = null
    var waterPipe: WaterPipe? = null

    constructor(fridge: Fridge, powerSocket: PowerSocket) : this() {
        this.fridge = fridge
        this.powerSocket = powerSocket
    }

    constructor(sink: Sink, waterPipe: WaterPipe) : this() {
        this.sink = sink
        this.waterPipe = waterPipe
    }

    constructor(fridge: Fridge, powerSocket: PowerSocket, sink: Sink, waterPipe: WaterPipe) : this() {
        this.fridge = fridge
        this.powerSocket = powerSocket
        this.sink = sink
        this.waterPipe = waterPipe
    }

    fun use() {
        if (((fridge == null) xor (powerSocket == null)) or ((sink == null) xor (waterPipe == null))) {
            throw IllegalArgumentException("This kitchen is not functional")
        }
        println("This kitchen works fine.")
    }
}