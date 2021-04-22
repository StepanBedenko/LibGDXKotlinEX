import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions

class Starfish(x: Float, y: Float, s: Stage): BaseActor(x,y,s) {
    init {
        loadTexture("starfish.png")

        val spin = Actions.rotateBy(30f,1f)
        this.addAction(spin)
    }
}