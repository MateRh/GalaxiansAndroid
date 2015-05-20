package unicornprojectsstudio.galaxianandroidedition;

import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Mate on 2015-04-17.
 */
public class Player extends Ship{

    private long score = 0;
    private int lives = 3;
    private float vX = 0.0f;

    public Player( int x, int y, int sizeX, int sizeY, int bitmap ) {
        super( x, y, sizeX, sizeY, bitmap );
    }
    @Override
    public void setScore( long s ){


        final long addToScore = s / 50;
        final long finalScore = score +s;


        final Timer timer = new Timer(  );
        timer.schedule( new TimerTask() {
            @Override
            public void run() {
                if( score >= finalScore ) {
                    timer.cancel();
                } else {
                    score = score + addToScore;
                }
            }
        }, 0, 20 );

    }
    @Override
    public long getScore( ) {

        return score;

    }

    @Override
    public int getLives( ) {
        return lives;
    }
    @Override
    public void setLives( int lives ) {
        this.lives = lives;
    }

    @Override
    public void setVelocity( float vX ) {
        this.vX = vX;
    }

    @Override
    public void move( ) {
        x = x + vX;
            if ( x > Variables.width - sizeX ) {
                x = Variables.width - sizeX;
            } else if ( x < 0 ) {
                x = 0;
            }
    }
    
    @Override
    public int getType( ) {
    		return 1;
    }

}