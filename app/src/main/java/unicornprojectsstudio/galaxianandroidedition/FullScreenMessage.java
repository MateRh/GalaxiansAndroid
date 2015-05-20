package unicornprojectsstudio.galaxianandroidedition;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;


import java.util.ArrayList;

public class FullScreenMessage {

    Paint rPaint = new Paint();
    static Paint black = new Paint();
	int bX, bY, beX, beY;
    ArrayList<Texts> texts = new ArrayList<Texts>();

    public FullScreenMessage( int bX, int bY, int beX, int beY, Paint a){
        this.bX = bX;
        this.bY = bY;
        this.beX = bX+beX;
        this.beY = bY+beY;
        rPaint = new Paint( a );
    }
    static {

        black.setColor( Color.argb( 100, 0, 0, 0 ) );
    }

    public void renderFrame( Canvas canvas ) {
        canvas.drawRect( bX, bY, beX, beY, rPaint );
        canvas.drawRect( bX + 5, beY-7, beX-5, beY-5, black );
        canvas.drawRect( bX + 5, bY+5, beX-5, bY+7, black );
        canvas.drawRect( bX + 5, bY+5, bX+7, beY-5, black );
        canvas.drawRect( beX- 7, bY+5, beX-5, beY-5, black );
        for (int i = 0; i < texts.size(); i++) {
            Texts a = texts.get(i);
            a.render( canvas );

        }
   
    }

    public void addText( String txt, String alginX, String alginY, Paint p ) {
        texts.add( new Texts( txt, alginX, alginY, p ) );
    }
	
	private class Texts {
		float x, y, s0x, s0y, add;
		String txt;
        Paint fPaint;
        Paint fPaintBg;
		
		
		public Texts (  String txt, String alginX, String alginY, Paint p ) {
			this.txt = txt;
			s0x = -3;
			s0y = -3;
            add = 0.25f;

            fPaint = new Paint( p );
            fPaintBg = new Paint( p );
            fPaintBg.setColor( Color.BLACK );

            Rect result = new Rect();
            fPaint.getTextBounds(txt, 0, txt.length(), result);
                if ( alginX == "center" ) {
                    x = bX + (( beX-bX ) - result.width() )/2;
                }
                if ( alginY == "center" ) {
                    y = bY + (( beY-bY ) - result.height() )/2;
                    y = y + result.height()/2;
                } else if ( alginY == "bottom" ) {
                    y = beY   - result.height()*2;
                }
		}
		
		public void render( Canvas c ) {

			c.drawText( txt, x + s0x*2, y + s0y*2, fPaintBg);
			c.drawText( txt, x +s0x, y +s0y, fPaint);
            s0x+=add;
            s0y+=add;
                if ( s0x > 3 ) {
                    add = -0.25f;
                } else if ( s0x < -3 ) {
                    add = 0.25f;
                }
		}
		
		
	}
}
