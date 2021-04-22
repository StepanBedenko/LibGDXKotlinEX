import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage

abstract class GmaeBetaTest : Game() {
    protected var mainStage: Stage? = null

    override fun create() {
        mainStage = Stage()
        initialize()
    }

    abstract fun initialize()
    override fun render() {
        val dt = Gdx.graphics.deltaTime
        mainStage!!.act(dt)

        update(dt)
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        mainStage!!.draw()

    }

    abstract fun update(dt: Float)
}