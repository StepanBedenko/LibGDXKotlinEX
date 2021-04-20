import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage

class BaseActor(x: Float, y: Float, s: Stage):Actor() {
    init {
        setPosition(x,y)
        s.addActor(this)
    }

    private lateinit var animation: Animation<TextureRegion>

    private var elapsedTime = 0f
    private var animationPaused = false


    fun setAnimation(anim: Animation<TextureRegion>){
        animation = anim
        var tr = animation.getKeyFrame(0f)
        var w = tr.regionWidth.toFloat()
        var h = tr.regionHeight.toFloat()
        setSize(w,h)
        setOrigin(w/2,h/2)
    }

    fun setAnimationPaused(pause: Boolean){
        animationPaused = pause
    }

    fun act(dt:Float){
        super.act(dt)
        if(!animationPaused)
            elapsedTime += dt
    }
}