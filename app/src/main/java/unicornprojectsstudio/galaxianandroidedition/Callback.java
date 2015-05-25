package unicornprojectsstudio.galaxianandroidedition;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Mate on 2015-05-06.
 *
 * Simple pseudo callback system :D
 *
 */
public class Callback {

    private SortedArray<Ship> aiShips;
    private SortedArray<Effect> effects;
    private Context context;
    private Container container;


        public Callback( Container container ) {
            this.aiShips = container.getAiShips();
            this.effects = container.getEffects();
            this.context = container.getContext();
            this.container = container;
        }

        public void onShipDestroy( Ship ship ) {
            SoundsManager soundsManager = container.getSoundsManager();
            soundsManager.play( 1 );
            aiShips.get( 0 ).setScore( 500 );

            SortedArray<AnimatedLabelText> labels = container.getLabels();
            labels.add( new AnimatedLabelText( (int)ship.getX(), (int)ship.getY(), "+500", 1000 ) );

            Log.v( "aiShips.size() ", " " + aiShips.size() );
                if ( aiShips.size() == 2 ) {
                    container.setCurrentLevel( container.getCurrentLevel()+1 );
                    container.setLevel( null );
                    final Timer timer = new Timer(  );
                    timer.schedule( new TimerTask() {
                        @Override
                        public void run() {
                            container.setLevel( new Level( container ) );
                            timer.cancel();

                        }
                    }, 0, 1000 );
                }
        }

        public void onPlayerDestroy( final Player player ) {
            SoundsManager soundsManager = container.getSoundsManager();
            soundsManager.play( 1 );
            player.setVelocity( 0 );
            player.setLives( player.getLives() - 1 );
            container.setFrozen( true );
            Activity a = ( Activity ) context;
            if ( player.getLives() == 0 ) {
                a.runOnUiThread( new Runnable() {
                    public void run() {
                        new GameOverDialogBox( container.getContext(), player.getScore(), "06:66" );
                    }
                } );
            } else {
                a.runOnUiThread( new Runnable() {
                    public void run() {

                        new DeadDialogBox( container, player.getScore(), player.getLives() );
                    }
                } );
            }
            player.x = Variables.width*2;

        }

        public void onEffectFinished( Effect effect ) {

            for ( int i = 0; i < effects.size() ; i++ ) {
                if ( effects.get( i ) == effect ) {

                    effects.remove( i );
                    break;
                }
            }

        }

        public void onLevelFinished( ) {

        }
}
