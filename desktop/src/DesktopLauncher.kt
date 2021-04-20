import com.badlogic.gdx.Game
import com.badlogic.gdx.backends.lwjgl.LwjglApplication

object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val myGame: Game = GameBeta()
        val launcher = LwjglApplication(myGame, "Starfish Collector", 640, 480)
    }
}