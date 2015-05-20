package unicornprojectsstudio.galaxianandroidedition;

import android.graphics.Paint;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;


public class Effect {

    private FadeInAnimation animation;
    private int firstTextureID, lastTextureID;
    private float x, y, frameTime;
    private Callback callback;
    Timer timer;


    public Effect( Callback callback, float x, float y, int firstTextureID, int lastTextureID, long durration ) {
        this.x = x;
        this.y = y;
        this.firstTextureID = firstTextureID;
        this.lastTextureID = lastTextureID;
        frameTime = durration / ( lastTextureID - firstTextureID  );
        this.animation = new FadeInAnimation( (int)frameTime ) ;
        this.callback = callback;
        timer = new Timer();
        timer.schedule( new DellayReminder( this ), durration );
    }

    public float getX( ) {
        return x;
    }

    public float getY( ) {
        return y;
    }

    public int getFirstTextureID( ) {
        return firstTextureID;
    }

    public int getLastTextureID( ) {
        return lastTextureID;
    }
    public Paint getPaint( ) {

        if ( animation.calcAlpha() == false ) {
            firstTextureID++;
            if ( firstTextureID > lastTextureID ) {
                firstTextureID = lastTextureID;
            }

        }
        return animation.getPaint();
    }


    class DellayReminder extends TimerTask {
    private Effect effect;

        public DellayReminder( Effect effect ) {
            this.effect = effect;
        }

        public void run() {
           // Engine.effects.remove( 0 );
            callback.onEffectFinished( effect );
            timer.cancel(); // Terminate the timer thread
        }
    }

}
