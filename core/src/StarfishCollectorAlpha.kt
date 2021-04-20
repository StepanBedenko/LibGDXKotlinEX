import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Rectangle
import org.w3c.dom.Text

class StarfishCollectorAlpha:Game() {
    private lateinit var batch: SpriteBatch
    private lateinit var turtleTexture: Texture

    private var turtleX: Float = 0f
    private var turtleY: Float = 0f
    private lateinit var turtleRectangle: Rectangle

    private lateinit var starfishTexture: Texture
    private var starfishX: Float = 0f
    private var starfishY: Float = 0f
    private lateinit var starfishRectangle: Rectangle
    private lateinit var oceanTexture: Texture

    private lateinit var winMessageTexture: Texture

    private var win: Boolean = false

    override fun create() {
        batch = SpriteBatch()
        turtleTexture = Texture(Gdx.files.internal("turtle-1.png"))

        turtleX = 20f
        turtleY = 20f
        turtleRectangle = Rectangle(turtleX, turtleY,
            turtleTexture.width.toFloat(),turtleTexture.height.toFloat())

        starfishTexture = Texture(Gdx.files.internal("starfish.png"))
        starfishX = 380f
        starfishY = 300f
        starfishRectangle = Rectangle(starfishX, starfishY, starfishTexture.width.toFloat(), starfishTexture.height.toFloat())

        oceanTexture = Texture(Gdx.files.internal("water.jpg"))

        winMessageTexture = Texture(Gdx.files.internal("you-win.png"))

        win = false
    }

    override fun render() {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            turtleX--
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            turtleX++
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            turtleY++
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            turtleY--

        turtleRectangle.setPosition(turtleX,turtleY)

        if(turtleRectangle.overlaps(starfishRectangle))
            win = true


        Gdx.gl.glClearColor(0f,0f,0f,1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.begin()
        batch.draw(oceanTexture,0f,0f)
        if(!win)
            batch.draw(starfishTexture, starfishX,starfishY)
        batch.draw(turtleTexture,turtleX,turtleY)
        if(win)
            batch.draw(winMessageTexture,180f,180f)
        batch.end()
    }



}