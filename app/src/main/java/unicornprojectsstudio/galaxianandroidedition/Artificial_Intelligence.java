package unicornprojectsstudio.galaxianandroidedition;

import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Mate on 2015-05-07.
 */
public class Artificial_Intelligence extends Thread {
      private SortedArray<Ship> aiShips;
      private SortedArray<Projectile> projectiles;
      private Timer timer;
      private Utils utils = new Utils();
      private float[][] range = {
              { Variables.shipSize/2, Variables.width - Variables.shipSize },
              { Variables.height*0.4f, Variables.height * 0.6f, Variables.height * 0.8f, Variables.height * 1f, Variables.height * 1.2f }
            };
      private boolean frozen = false;
    private Container container;
      
      public Artificial_Intelligence( Container container ) {
            this.aiShips = container.getAiShips();
            this.projectiles = container.getProjectiles();
            frozen = container.getFrozen();
            this.container = container;
       }

        @Override
        public void run() {
            while ( true ) {

                if ( container.getFrozen() == true ) {
                    try {
                        timer.cancel();
                        this.sleep( 2000 );

                    } catch ( Exception e ) {
                    }
                } else {


                    Ship[] aiShipsAfterFiltration = new Ship[ aiShips.size() + 1 ];
                    int aiArraySize = -1;
                    Ship cShip;
                    for ( int i = 0; i < aiShips.size(); i++ ) {
                        cShip = aiShips.get( i );
                        if ( cShip.getMoveStatus() == -1 ) {
                            aiArraySize++;
                            aiShipsAfterFiltration[ aiArraySize ] = cShip;
                        }
                    }
                    if ( aiArraySize > 0 ) {
                        Ship ship = aiShipsAfterFiltration[ utils.randomInt( 0, aiArraySize ) ];
                        ship.setTargets( new float[][]{
                                { utils.randomFloat( range[ 0 ][ 0 ], range[ 0 ][ 1 ] ), utils.randomFloat( range[ 1 ][ 0 ], range[ 1 ][ 1 ] ) },
                                { utils.randomFloat( range[ 0 ][ 0 ], range[ 0 ][ 1 ] ), utils.randomFloat( range[ 1 ][ 1 ], range[ 1 ][ 2 ] ) },
                                { utils.randomFloat( range[ 0 ][ 0 ], range[ 0 ][ 1 ] ), utils.randomFloat( range[ 1 ][ 2 ], range[ 1 ][ 3 ] ) },
                                { utils.randomFloat( range[ 0 ][ 0 ], range[ 0 ][ 1 ] ), utils.randomFloat( range[ 1 ][ 3 ] + 2, range[ 1 ][ 4 ] ) },
                                { ship.getX(), ship.getY() }
                        } );
                        timer = new Timer();
                        timer.schedule( new ShootDelay( ship ), utils.randomInt( 500, 2000 ) );
                        //    projectiles.add( new Projectile( 0, Variables.width / 1.92f, Variables.height-50, 5, 20, -0.2f ) );
                        //   audio.play( 0 );
                    }
                    try {
                        this.sleep( utils.randomInt( 1000, 3000 ) );
                    } catch ( Exception e ) {
                    }
                }
            }
        }
        //
            class ShootDelay extends TimerTask {
                private Ship ship;
                private boolean toCancel = false;

                public ShootDelay( Ship ship ) {
                    this.ship = ship;
                }

                public void run() {
                    if ( tempCheck( ship ) == false  ) {
                        timer.cancel();
                    } else {
                        projectiles.add( new Projectile( ship.getType(), ship.getCentredX(), ship.getCentredY(), 1, 10, 5 ) );
                        SoundsManager soundsManager = container.getSoundsManager();
                        soundsManager.play( 0 );
                        if ( toCancel ) {
                            timer.cancel();
                        }
                        toCancel = utils.random.nextBoolean();
                    }
                }
            }

        public boolean tempCheck( Ship ship ) {
           SortedArray<Ship> aiShips = container.getAiShips();
            for ( int i = 1; i < aiShips.size() ; i++ ) {
                if ( ship == aiShips.get( i ) ) {
                    return true;
                }
            }
            return  false;
        }
}