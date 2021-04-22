import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage

open class BaseActor(x: Float, y: Float, s: Stage):Actor() {
    init {
        setPosition(x,y)
        s.addActor(this)
    }

    private var animation: Animation<TextureRegion> = Animation(0f,TextureRegion())

    private var elapsedTime = 0f
    private var animationPaused = false

    fun isAnimationFinished(): Boolean{
        return animation.isAnimationFinished(elapsedTime)
    }

    fun loadTexture(fileName: String): Animation<TextureRegion>{
        val fileNames = arrayOf(fileName)
        return loadAnimationFromFiles(fileNames, 1f , true)
    }

    fun loadAnimationFromSheet(fileName: String, rows: Int, cols: Int,
    frameDuration: Float, loop: Boolean): Animation<TextureRegion>{
        val texture = Texture(Gdx.files.internal(fileName), true)
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
        val frameWidth = texture.width / cols
        val frameHeight = texture.height / rows

        val temp = TextureRegion.split(texture, frameWidth, frameHeight)

        val textureArray = com.badlogic.gdx.utils.Array<TextureRegion>()

        for(r in 0 until rows){
            for(c in 0 until cols)
                textureArray.add(temp[r][c])
        }

        val anim = Animation<TextureRegion>(frameDuration, textureArray)

        if(loop)
            anim.playMode = Animation.PlayMode.LOOP
        else
            anim.playMode = Animation.PlayMode.NORMAL

        animation = anim

        return anim
    }


    fun loadAnimationFromFiles(fileNames: Array<String>,
                               frameDuration: Float,
                               loop: Boolean): Animation<TextureRegion>{
        var fileCount = fileNames.size
        var textureArray = com.badlogic.gdx.utils.Array<TextureRegion>()

        for(n in 0 until fileCount) {
            var fileName = fileNames[n]
            var texture = Texture(Gdx.files.internal(fileName))

            texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
            textureArray.add(TextureRegion(texture))
        }

            var anim = Animation<TextureRegion>(frameDuration, textureArray)

            if(loop)
                anim.playMode = Animation.PlayMode.LOOP
            else
                anim.playMode = Animation.PlayMode.NORMAL

            return anim
    }

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

    override fun act(dt:Float){
        super.act(dt)
        if(!animationPaused)
            elapsedTime += dt
    }

    override fun draw(batch: Batch, parentAlpha: Float) {
        super.draw(batch, parentAlpha)

        var c = color
        batch.setColor(c.r, c.g, c.b, c.a)

        if(isVisible)
            batch.draw(animation.getKeyFrame(elapsedTime),
            x,y,originX,originY,width,height, scaleX, scaleY, rotation)
    }
}