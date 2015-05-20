package unicornprojectsstudio.galaxianandroidedition;


import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;

public class GradientText {
    private Paint paint;

    public GradientText( int size, Paint.Align align ) {
        paint = new Paint(  );
        paint.setTextSize( size );
        paint.setAntiAlias( true );
        paint.setTextAlign( align );

        Shader myShader = new LinearGradient(
                0, 0, 0, 100,
                Color.WHITE, Color.BLACK,
                Shader.TileMode.CLAMP );

        paint.setShader( myShader );
        paint.setShadowLayer( 20, 2, 2, Color.WHITE );
    }

    public Paint getPaint( ) {
        return paint;
    }
}
