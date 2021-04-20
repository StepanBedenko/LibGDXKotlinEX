import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage

open class GameBeta:Game() {
    protected lateinit var mainStage: Stage

    override fun create(){
        mainStage = Stage()
        initialize()
    }

    fun initialize(){
    }

    override fun render(){
        var dt = Gdx.graphics.deltaTime

        mainStage.act(dt)

        update(dt)

        Gdx.gl.glClearColor(0f,0f,0f,1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        mainStage.draw()
    }

    fun update(dt: Float){}


}