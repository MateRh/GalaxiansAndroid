package unicornprojectsstudio.galaxianandroidedition;


public class Ship {
    int sizeX, sizeY, myindex, cTarget = -1;
    float x, y, vectX, vectY, startX, startY, rotation, speed, c;
    int bitmap;
    float[][] target;
    public static int shipsCount = 0;
    long lastShootTime = 0;



    public Ship ( int x, int y, int sizeX, int sizeY, int bitmap ) {
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.bitmap = bitmap;
        this.myindex = shipsCount;
        startX = x;
        startY = y;
        speed = 0;
        c = 0;
    }
    
    public int getMoveStatus( ) {
          return cTarget;
    }

    public float getX ( ) {
        return x;
    }

    public float getY ( ) {
        return y;
    }
    
    public int getType( ) {
    		return 0;
    }

    public void setVelocity( float vX ) {

    }

    public float getCentredX ( ) {
        return x + sizeX/2;
    }

    public float getCentredY ( ) {
        return y + sizeY/2;
    }

    public int getLives( ) {
        return 0;
    }

    public void setLives( int lives ) {

    }

    public void setScore( long s ){



    }

    public long getScore( ) {

        return 0;

    }

    public void setTargets( float[][] targets  ) {
        target = targets;
        cTarget = 0;
        Utils util = new Utils();
        rotation = util.findRotation( x, y, target[ cTarget ][0],  target[ cTarget ][1] );
        rotation = 0.0f;
        float distance = util.getDistanceBetween2DPoints( x, y, target[ cTarget ][0],  target[ cTarget ][1]);
        vectX = ( ( target[ cTarget ][0] - x ) / distance ) * 4;
        vectY = ( ( target[ cTarget ][1] - y ) / distance ) * 4;
        c = (float)Math.sqrt(  Math.pow( vectX, 2 ) + Math.pow( vectY,2 ) );

    }
    public void checkMoveStatus(   ) {

        Utils util = new Utils();
        float distance = util.getDistanceBetween2DPoints( x, y, target[ cTarget ][0],  target[ cTarget ][1]);

            if ( distance < c && distance > c*-1 ) {
                cTarget++;
                if ( cTarget >= target.length ) {
                    cTarget = -1;
                    vectX = 0;
                    vectY = 0;
                } else {
                    distance = util.getDistanceBetween2DPoints(target[cTarget - 1][0], target[cTarget - 1][1], target[cTarget][0], target[cTarget][1]);
                    vectX = ( ( target[cTarget][0] - target[cTarget - 1][0]) / distance ) * 4;
                    vectY = ( ( target[cTarget][1] - target[cTarget - 1][1]) / distance ) * 4;
                    c = (float)Math.sqrt(  Math.pow( vectX, 2 ) + Math.pow( vectY,2 ) );
                }
            }
    }
    public void move( ) {
        if ( cTarget > -1 ) {
            x = x + vectX;
            y = y + vectY;
               if ( y > Variables.height ) {
                    y = 0;
                    cTarget++;
                    if ( cTarget >= target.length ) {
                        cTarget--;
                    }
                    float distance = new Utils().getDistanceBetween2DPoints(x, y, target[cTarget][0], target[cTarget][1]);
                    vectX = ( (target[cTarget][0] - x) / distance ) * 4;
                    vectY = ( (target[cTarget][1] - y) / distance ) * 4;
                    c = (float)Math.sqrt(  Math.pow( vectX, 2 ) + Math.pow( vectY,2 ) );
                }
            checkMoveStatus();
        }
    }

    public void shoot( float speed ) {
        if ( System.currentTimeMillis() - lastShootTime > 1000 ) {
            lastShootTime = System.currentTimeMillis();
            new Projectile( 1,  (int)x + Variables.shipSize/2 , (int)y + Variables.shipSize , 2, 16, speed );
        }

    }
	


    public void explode( ){
        /*
        int tmpSize = shipSize/2 - 48;

        effects.add( new Effect( cX + tmpSize, cY + tmpSize, explosion, 750 ));
		if ( type > 0 ) {
      	 	ships[ this.myindex ].cTarget = -1;
     	   	ships[ this.myindex ] = null;
        	shipsCount--;
			player.setScore( player.getScore() + 500*type );
		} else {

            fadeBitmap = null;
            Paint a = new Paint();
            a.setARGB( 128, 128, 128, 128 );
            int wX = (int) ( width*0.75 );
            int wY = (int) ( wX/2.5 );
            infoBox = new FullScreenMessage( ( width - wX )/2, ( height - wY )/2, wX, wY, a );
            Paint c = new Paint();
            c.setTextSize( 46 );
            c.setARGB( 255, 255, 225, 225 );
            Paint d = new Paint();
            d.setTextSize( 23 );
            d.setColor( Color.WHITE );

			lives--;
			if ( lives < 1 ) {
                infoBox.addText( "Game Over!", "center", "center", c );
				infoBox.addText( "Tap to exit", "center", "bottom", d );
                unFreezeAction = 2;
			} else {
                infoBox.addText( "You died!", "center", "center", c );
                infoBox.addText( "Tap to retry!", "center", "bottom", d );
                unFreezeAction = 3;
            }

            freeze = true;
		}*/

      /*  if ( shipsCount < 1 ) {
            if (currentLevel > 5) {
                currentLevel = 1;
            }
            new Battlefield( );
        }*/
    }


    public boolean calculateCollision( int c_sX, int c_sY, int c_eX, int c_eY ){
        /*
        float dx =(( this.cX + (this.cX + this.sizeX) )/2 ) - c_sX;
        float dy =(( this.cY + (this.cY + this.sizeY) )/2 ) - c_sY;
        double dis = Math.sqrt(dx*dx + dy*dy);

            if ( dis < sizeY*0.45 ) {
               this.explode();
               return true;
            }*/
        return false;
    }


}