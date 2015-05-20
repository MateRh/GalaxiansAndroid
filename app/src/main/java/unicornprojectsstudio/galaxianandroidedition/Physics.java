package unicornprojectsstudio.galaxianandroidedition;


import android.util.Log;

public class Physics {
    private SortedArray<Ship> aiShips;
    private SortedArray<Projectile> projectiles;
    private SortedArray<Effect> effects;
    private Callback callback;
    private PhysicsThread thread;
    private Container container;
    private boolean frozen = false;

    public Physics( Container container ) {
        this.aiShips = container.getAiShips();
        this.projectiles = container.getProjectiles();
        this.effects = container.getEffects();
        this.callback = container.getCallback();
        PhysicsThread thread = new PhysicsThread( );
        frozen = container.getFrozen();
        this.container = container;
    }

    static float getDistanceBetween2DPoints( float x1, float y1, float x2, float y2 ) {

        float xd = x2-x1;
        float yd = y2-y1;

        return (float)Math.sqrt( xd*xd + yd*yd );
    }

    public PhysicsThread getThread( ) {
        return thread;
    }


    private class PhysicsThread extends Thread {

            public PhysicsThread( ) {
                this.start();
            }

            @Override
            public void run() {
                while ( true ) {

                    if ( container.getFrozen() == true ) {
                        try {
                            this.sleep( 2000 );


                        } catch ( Exception e ) {
                        }
                    } else {


                        for ( int i = 0; i < aiShips.size(); i++ ) {
                            Ship ship = aiShips.get( i );
                            Projectile projectile;
                            ship.move();

                            for ( int j = 0; j < projectiles.size(); j++ ) {
                                projectile = projectiles.get( j );

                                if ( projectile.getType() != ship.getType() ) {
                                    if ( getDistanceBetween2DPoints( ship.getCentredX(), ship.getCentredY(), projectile.getX(), projectile.getY() ) < Variables.shipSize / 2 ) {
                                        effects.add( new Explosion( callback, projectile.getX() - 48, projectile.getY() - 48 ) );
                                        projectiles.remove( j );
                                        switch ( ship.getType() ) {
                                            case 0:
                                                callback.onShipDestroy( ship );
                                                aiShips.remove( i );
                                                break;
                                            case 1:
                                                callback.onPlayerDestroy( ( Player ) ship );
                                                break;
                                        }


                                    }
                                }

                            }


                            for ( int k = 0; k < aiShips.size(); k++ ) {
                                Ship ship_ = aiShips.get( k );
                                if ( ship_.getType() != ship.getType() ) {
                                    if ( getDistanceBetween2DPoints( ship_.getCentredX(), ship_.getCentredY(), ship.getCentredX(), ship.getCentredY() ) < Variables.shipSize / 2 ) {
                                        effects.add( new Explosion( callback, ship.getX(), ship.getY() ) );


                                        if ( ship_.getType() == 1 ) {
                                            callback.onPlayerDestroy( ( Player ) ship_ );
                                            break;
                                        } else {
                                            callback.onShipDestroy( ship_ );
                                            aiShips.remove( k );

                                        }


                                        if ( ship.getType() == 1 ) {
                                            callback.onPlayerDestroy( ( Player ) ship );
                                            break;
                                        } else {
                                            callback.onShipDestroy( ship );
                                            aiShips.remove( i );
                                            break;
                                        }

                                    }
                                }
                            }

                        }
                        Projectile projectile;
                        for ( int j = 0; j < projectiles.size(); j++ ) {
                            projectile = projectiles.get( j );
                            projectile.move();
                            if ( projectile.getY() > Variables.height || projectile.getY() < 0 ) {
                                projectiles.remove( j );
                            }
                        }

                        try {
                            this.sleep( Variables.wait );
                        } catch ( Exception e ) {
                        }

                    }
                }
            }

        }

}