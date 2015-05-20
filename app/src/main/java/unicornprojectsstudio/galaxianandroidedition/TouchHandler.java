package unicornprojectsstudio.galaxianandroidedition;


import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class TouchHandler implements View.OnTouchListener {

    private Ship player;
    private SortedArray<Projectile> projectiles = new SortedArray<>();
    private long lastShootTime = System.currentTimeMillis();
    private Container container;

    public TouchHandler( Container container )
    {
        SortedArray<Ship> aiShips = container.getAiShips();
        player = aiShips.get( 0 );
        this.projectiles = container.getProjectiles();
        this.container = container;
    }

    @Override
    public boolean onTouch( View v, MotionEvent event){
        int pointerCount = event.getPointerCount();

                for(int i = 0; i < pointerCount; ++i) {
                    if ( event.getActionMasked() == MotionEvent.ACTION_UP ) {
                        player.setVelocity( 0 );
                    } else {
                        if ( event.getY() > Variables.height*0.75 ) {
                            if ( event.getX( i ) > Variables.width * 0.5 ) {
                                player.setVelocity( 3.4f );
                            } else {
                                player.setVelocity( -3.4f );
                            }
                        } else {
                            if ( System.currentTimeMillis() > lastShootTime ) {
                                projectiles.add( new Projectile( player.getType(), player.getCentredX(), player.getCentredY(), 1, 10, -5 ) );
                                SoundsManager soundsManager = container.getSoundsManager();
                                soundsManager.play( 0 );
                                lastShootTime = System.currentTimeMillis() + 500;
                            }
                        }

                    }
                }

        return true;
    }
}
