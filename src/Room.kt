abstract class Room {
    var drawer: Drawer? = null
    var sink: Sink? = null
    var waterPipe: WaterPipe? = null

    internal constructor(drawer: Drawer?, sink: Sink?, waterPipe: WaterPipe?) {
        this.drawer = drawer
        this.sink = sink
        this.waterPipe = waterPipe
    }

    abstract fun use()
}