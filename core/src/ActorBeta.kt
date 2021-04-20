import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.scenes.scene2d.Actor

open class ActorBeta: Actor() {
    private var textureRegion: TextureRegion = TextureRegion()
    private var rectangle: com.badlogic.gdx.math.Rectangle = com.badlogic.gdx.math.Rectangle()

    fun setTexture(t: Texture){
        textureRegion.setRegion(t)
        setSize(t.width.toFloat(),t.height.toFloat())
        rectangle.setSize(t.width.toFloat(),t.height.toFloat())
    }

    fun getRectangle(): Rectangle {
        rectangle.setPosition(x.toFloat(), y.toFloat())
        return rectangle
    }

    fun overlaps(other: ActorBeta): Boolean{
        return this.getRectangle().overlaps(other.getRectangle())
    }

    override fun draw(batch: Batch, parentAlpha: Float){
        super.draw(batch, parentAlpha)
        var c: Color = color

        batch.setColor(c.r, c.g, c.b,c.a)

        if(isVisible)
            batch.draw(textureRegion, x,y,originX,originY,width,
                height, scaleX, scaleY, rotation)
    }
}