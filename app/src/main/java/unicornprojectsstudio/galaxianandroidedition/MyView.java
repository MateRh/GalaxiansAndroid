package unicornprojectsstudio.galaxianandroidedition;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;


public class MyView extends View {
    private TexturesManager textures;


    public MyView(Context cxt, AttributeSet attrs) {
        super(cxt, attrs);
        textures = new TexturesManager();

    }

    @Override
    protected void onDraw(Canvas c) {
        c.drawBitmap( textures.getTexture( 0 ), 0, 0, null );

        invalidate();
    }
}