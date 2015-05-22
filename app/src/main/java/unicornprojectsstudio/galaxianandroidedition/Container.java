package unicornprojectsstudio.galaxianandroidedition;


import android.content.Context;

public class Container {
    /* Declarations */
        private Context context;
        private Level level;
        private SortedArray<Ship> aiShips;
        private SortedArray<Projectile> projectiles;
        private SortedArray<Effect> effects;
        private SortedArray<AnimatedLabelText> labels;
        private Renderer2D renderer;
        private SoundsManager audio;
        private Callback callback;
        private int currentLevel = 0;
        private Artificial_Intelligence ai;
        private boolean frozen = false;
    /* end of declarations */

    public Container ( ) { }

    /* Labels */

        public SortedArray getLabels( )  {

            return labels;

        }

        public void setLabes( SortedArray labels ) {

            this.labels = labels;

        }

    /* Context */

        public void setContext( Context context ) {
            this.context = context;
        }

        public Context getContext( ) {
            return context;
        }

    /* Level */

        public void setLevel( Level level ) {

            this.level = level;

        }

        public Level getLevel( ) {

            return level;

        }

    /* Projectiles */

        public void setProjectiles( SortedArray projectiles ) {

            this.projectiles = projectiles;

        }

        public SortedArray getProjectiles( ) {

            return projectiles;

        }

    /* aiShips */

        public void setAiShips( SortedArray aiShips ) {

            this.aiShips = aiShips;

        }

        public SortedArray getAiShips( ) {

            return aiShips;

        }

    /* Effects */

        public void setEffects( SortedArray effects ) {

            this.effects = effects;

        }

        public SortedArray getEffects( ) {

            return effects;

        }

    /* Renderer */

        public void setRenderer( Renderer2D renderer ) {

            this.renderer = renderer;

        }

        public Renderer2D getRenderer( ) {
            return renderer;
        }

    /* Sound Manager */

        public void setSoundManager( SoundsManager audio ) {

            this.audio = audio;

        }

        public SoundsManager getSoundsManager(  ) {

            return audio;

        }

    /* Callback */

        public void setCallback( Callback callback ) {

            this.callback = callback;

        }

        public Callback getCallback( ) {

            return callback;

        }

    /* AI */

        public void setAi( Artificial_Intelligence ai ) {

            this.ai = ai;

        }

        public Artificial_Intelligence getAi( ) {

            return ai;

        }

    /* Current Level */

        public void setCurrentLevel( int currentLevel ) {

            this.currentLevel = currentLevel;

        }

        public int getCurrentLevel( ) {

            return currentLevel;

        }

    /* Frozen - freeze game locic */

        public void setFrozen( boolean frozen ) {

            this.frozen = frozen;

        }

        public boolean getFrozen( ) {

            return frozen;

        }


}
