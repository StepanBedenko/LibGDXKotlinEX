import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.scenes.scene2d.Stage

class Turtle(x: Float, y: Float, s: Stage): BaseActor(x, y, s) {
    init{
        var fileNames = arrayOf("turtle-1.png","turtle-2.png", "turtle-3.png",
        "turtle-4.png", "turtle-5.png", "turtle-6.png")
        loadAnimationFromFiles(fileNames, 0.1f, true)
    }
}