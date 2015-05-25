package unicornprojectsstudio.galaxianandroidedition;

import android.graphics.Paint;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Mate on 2015-05-22.
 */
public class AnimatedLabelText {
    private int x, y, durration;
    private Paint paint;
    private GradientText gradientText;
    String text;

    public AnimatedLabelText( int x, int y, String text, int durration  ) {
        this.x = x;
        this.y = y;
        this.text = text;
        gradientText = new GradientText( 20, Paint.Align.LEFT );
        paint = gradientText.getPaint();
        TimerTask task = new TimerTask( ) {

            public void run() {
                paint.setAlpha( 254 );
            }

        };
        Timer timer = new Timer();
        timer.schedule( task, durration );

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Paint getPaint() {

        if ( paint.getAlpha() < 255 ) {
            paint.setAlpha( paint.getAlpha()-1 );
        }

        return paint;
    }

    public String getText() {
        return text;
    }


}
