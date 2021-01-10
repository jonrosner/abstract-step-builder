abstract class RoomBuilder<T>: DrawerStep<T>, SinkStep<T>, WaterPipeStep<T>, BuildStep<T> where T : Room {
    var drawer: Drawer? = null
    var sink: Sink? = null
    var waterPipe: WaterPipe? = null

    override fun setDrawer(drawer: Drawer): SinkStep<T> {
        this.drawer = drawer
        return this
    }

    override fun setSink(sink: Sink): WaterPipeStep<T> {
        this.sink = sink
        return this
    }

    override fun setWaterPipe(waterPipe: WaterPipe): BuildStep<T> {
        this.waterPipe = waterPipe
        return this
    }
}

interface DrawerStep<T> {
    fun setDrawer(drawer: Drawer) : SinkStep<T>
    fun build() : T
}

interface SinkStep<T> {
    fun setSink(sink: Sink) : WaterPipeStep<T>
    fun build() : T
}

interface WaterPipeStep<T> {
    fun setWaterPipe(waterPipe: WaterPipe) : BuildStep<T>
}

interface BuildStep<T> {
    fun build() : T
}