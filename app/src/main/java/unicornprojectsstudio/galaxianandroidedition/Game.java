package unicornprojectsstudio.galaxianandroidedition;


import android.content.Context;
import android.util.DisplayMetrics;


public class Game {

    private Level level;

    private Renderer2D renderer;
    private SoundsManager audio;
    private Callback callback;
    private int currentLevel = 0;
    private Container container;

    public Game ( Context context ) {
        /* Some static stuff, need to load once */
            Variables.resource = context.getResources();
            DisplayMetrics metrics = Variables.resource.getDisplayMetrics();
            Variables.width = metrics.widthPixels;
            Variables.height = metrics.heightPixels;
            Variables.shipSize = (int)( Variables.width * 0.07 );
            Variables.myshipSize = (int)( Variables.width * 0.1 );
        /* End */
        container = new Container( );

            container.setAiShips( new SortedArray<>() );
            container.setProjectiles( new SortedArray<>() );
            container.setEffects( new SortedArray<>() );
            container.setContext( context );

        container.getAiShips().add( new Player( ( Variables.width - Variables.myshipSize * 4 ) / 2, Variables.height - 100, Variables.myshipSize, Variables.myshipSize, 27 ) );
        this.loadGameLevel();
        Variables.lastFrameTime = System.nanoTime()+16;
        renderer = new Renderer2D( container );
        renderer.setOnTouchListener( new TouchHandler( container ) );
        callback = new Callback( container );
        container.setCallback( callback );
        Physics physics = new Physics( container );
        audio = new SoundsManager( context );
        container.setSoundManager( audio );
        new Artificial_Intelligence( container ).start();

    }




    private void loadGameLevel( ) {
        container.setCurrentLevel( container.getCurrentLevel()+1 );
        level = new Level( container );

    }

    public Renderer2D getRenderer( ) {
        return renderer;
    }



}
