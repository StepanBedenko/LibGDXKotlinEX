import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.Stage

class StarfishCollectorBeta():GameBeta() {
    private lateinit var mainStage: Stage

    private var ocean = ActorBeta()
    private var starfish = ActorBeta()
    private var turtle = Turtle()
    private var winMessage = ActorBeta()

    private var win = false

    override fun create() {
        mainStage = Stage()

        ocean.setTexture(Texture(Gdx.files.internal("water.jpg")))
        mainStage.addActor(ocean)

        starfish.setTexture(Texture(Gdx.files.internal("starfish.png")))
        starfish.setPosition(380f,380f)
        mainStage.addActor(starfish)

        turtle.setTexture(Texture(Gdx.files.internal("turtle-1.png")))
        turtle.setPosition(20f,20f)
        mainStage.addActor(turtle)

        winMessage.setTexture(Texture(Gdx.files.internal("you-win.png")))
        winMessage.setPosition(180f,180f)
        winMessage.setVisible(false)
        mainStage.addActor(winMessage)
    }

    override fun render(){
        mainStage.act(1/60f)

        if(turtle.overlaps(starfish)) {
            starfish.remove()
            winMessage.isVisible = true
        }

        Gdx.gl.glClearColor(0f,0f,0f,1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        mainStage.draw()
    }
}