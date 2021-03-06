import com.badlogic.gdx.scenes.scene2d.Stage

class Whirlpool(x: Float, y: Float, s: Stage): BaseActor(x,y,s) {
    init {
        loadAnimationFromSheet("whirlpool.png", 2, 5, 0.1f, false)
    }

    override fun act(dt: Float){
        super.act(dt)

        if(isAnimationFinished())
            remove()
    }
}