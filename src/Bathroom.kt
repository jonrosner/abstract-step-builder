import java.lang.IllegalArgumentException

class Bathroom : Room {

    private constructor(drawer: Drawer?, sink: Sink?, waterPipe: WaterPipe?) : super(drawer, sink, waterPipe)

    override fun use() {
        // this will never fail
        if (((sink == null) xor (waterPipe == null))) {
            throw IllegalArgumentException("This bathroom is not functional")
        }
        println("This bathroom works fine.")
    }

    private class KitchenBuilder : RoomBuilder<Bathroom>() {

        override fun build(): Bathroom {
            return Bathroom(drawer, sink, waterPipe)
        }
    }
    companion object {
        fun Builder(): SinkStep<Bathroom> {
            return KitchenBuilder()
        }
    }
}