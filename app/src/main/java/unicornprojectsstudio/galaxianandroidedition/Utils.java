package unicornprojectsstudio.galaxianandroidedition;


import java.util.Random;

public class Utils {
    Random random;
    public Utils( ){
        random = new Random();

    }
    int randomInt( int a, int b) {
        random.setSeed( System.nanoTime() );
        return a + random.nextInt( ( b - a ) );
    }

    float randomFloat( float a, float b) {
        random.setSeed( System.nanoTime() );
        return a + (( b - a )*random.nextFloat()) ;
    }

    float[] getPointFromDistanceRotation( float x, float y, float dist, float angle ) {
        double a = angle/180*3.14159265358979;
        return new float[] {x - ( (float)( Math.sin(a) * dist ) ), y + ( (float)( Math.cos(a) * dist ) )};
    }

    float findRotation( float x1, float y1, float x2, float y2 ) {
        double t = -Math.toDegrees(Math.atan2(x2-x1,y2-y1));
        if ( t < 0 ) {
            t = t + 360;
        }
        return (float)t;

    }

    static float getDistanceBetween2DPoints( float x1, float y1, float x2, float y2 ) {

        float xd = x2-x1;
        float yd = y2-y1;

        return (float)Math.sqrt( xd*xd + yd*yd );
    }

}
