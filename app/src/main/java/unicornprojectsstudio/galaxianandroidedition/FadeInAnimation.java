package unicornprojectsstudio.galaxianandroidedition;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;


public class FadeInAnimation {

    private long StartTime, EndTime;
    private Paint paint;
    private int time;
    private float oneFrame;


    public FadeInAnimation( int time )
    {
        StartTime = System.currentTimeMillis();
        EndTime = System.currentTimeMillis()+time;
        paint = new Paint();
        oneFrame = 255.0f / time;
        this.time = time;

    }
    public boolean calcAlpha( ) {
        boolean tReturn = true;
        if ( System.currentTimeMillis() > EndTime ) {
            tReturn = false;
            StartTime = System.currentTimeMillis();
            EndTime = System.currentTimeMillis()+time;
        }
        int newAlpha = (int) ((System.currentTimeMillis() - StartTime) * oneFrame);
        paint.setAlpha( newAlpha );
        return tReturn;
    }

    protected Paint getPaint(  ){

        return paint;
    }

}