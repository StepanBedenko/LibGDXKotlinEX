import javax.swing.plaf.metal.OceanTheme

class StarfishCollector(): GameBeta() {
    private lateinit var turtle: Turtle
    private lateinit var starfish: Starfish
    private lateinit var ocean: BaseActor

    override fun initialize(){
        ocean = BaseActor(0f,0f,mainStage)
        ocean.loadTexture("water.jpg")
        ocean.setSize(800f, 600f)

        starfish = Starfish(380f,380f, mainStage)

        turtle = Turtle(20f,20f, mainStage)
    }

    override fun update(dt: Float){

    }
}