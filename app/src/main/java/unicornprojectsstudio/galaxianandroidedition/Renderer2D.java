package unicornprojectsstudio.galaxianandroidedition;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;



public class Renderer2D extends View {
    private TexturesManager texturesPool;
    private Container container;
    private SortedArray<Ship> aiShips;
    private SortedArray<Projectile> projectiles = new SortedArray<>();
    private SortedArray<Effect> effects = new SortedArray<>();
    private GradientText score;
    private GradientText level;
    private int points = 0;


    public Renderer2D( Container container ) {
        super( container.getContext() );
        this.container = container;
        texturesPool = new TexturesManager( );
        this.aiShips = container.getAiShips();
        this.projectiles = container.getProjectiles();
        this.effects = container.getEffects();

        score = new GradientText( 32, Paint.Align.CENTER );
        level = new GradientText( 20, Paint.Align.LEFT );


    }

    @Override
    protected void onDraw( Canvas c ) {
            if ( Variables.lastFrameTime == 0 ) {
                Variables.wait = System.nanoTime() - Variables.lastFrameTime;
            }
        Variables.lastFrameTime = System.nanoTime();
        c.drawBitmap( texturesPool.getTexture( 0 ), 0, 0, null );

        Ship rShip;
            for ( int i = 0; i < aiShips.size() ; i++ ) {
                rShip = aiShips.get( i );
                c.drawBitmap( texturesPool.getTexture( rShip.bitmap ), rShip.x, rShip.y, null );
            }
        Projectile rProjectile;
            for ( int i = 0; i < projectiles.size() ; i++ ) {
                rProjectile = projectiles.get( i );
                c.drawBitmap( texturesPool.getTexture( 3 ), rProjectile.getX(), rProjectile.getY(), null );
            }
        Effect rEffect;
        Bitmap textureA, textureB;

        for ( int i = 0; i < effects.size() ; i++ ) {
                rEffect = effects.get( i );
                textureA = texturesPool.getTexture( rEffect.getFirstTextureID() );
                textureB = texturesPool.getTexture( rEffect.getFirstTextureID()+1 );

            c.drawBitmap( textureA, rEffect.getX(), rEffect.getY(), null );
            c.drawBitmap( textureB, rEffect.getX(), rEffect.getY(), rEffect.getPaint() );
        }

        //
        for( int i =0; i < aiShips.get( 0 ).getLives( ); i++ ) {
            c.drawBitmap( texturesPool.getTexture( 29 ), Variables.myshipSize + ( int ) ( Variables.myshipSize / 1.75 ) * i, 19, null );
        }

        c.drawText( ""+aiShips.get( 0 ).getScore(), Variables.width/2, 40, score.getPaint() );
        c.drawText( "1-"+container.getCurrentLevel(), Variables.width - Variables.width/4, 37, level.getPaint() );

        invalidate();

    }
}
