package unicornprojectsstudio.galaxianandroidedition;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class GameOverDialogBox  {

    public GameOverDialogBox( Context context, long score, String time ) {
        final Dialog d = new Dialog( context );
        d.setContentView( R.layout.test );
        d.setTitle( "Game Over!" );
        TextView text = ( TextView )d.findViewById( R.id.textView17 );
        text.setText( "Score:  " + score );
        text = ( TextView )d.findViewById( R.id.textView18 );
        text.setText( "Sesion time:  " + time );
        Button button = ( Button ) d.findViewById( R.id.button );
        button.setOnClickListener( new View.OnClickListener() {
            public void onClick( View v ) {
                System.exit( 0 );

            }
        } );
        d.show();


    }

}

