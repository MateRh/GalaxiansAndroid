package unicornprojectsstudio.galaxianandroidedition;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class UserInterfaceHandler {

    private Activity activity;

    public UserInterfaceHandler( Activity a, int menu ) {

        activity = a;

        switch ( menu ) {
            case 1:
                handleMainMenu( );
                break;
            case 2:
                handleSettingsMenu( );
                break;
        }

    }

    private void handleMainMenu( ) {


        String rPatch = "unicornprojectsstudio.galaxianandroidedition";

       // for ( int i=1; i < 4; i++ ) {
           // Button button = ( Button ) activity.findViewById( Variables.resource.getIdentifier( "button"+i, "id", rPatch ) );
            Button button = ( Button ) activity.findViewById( R.id.button1 );
            button.setOnClickListener (
                new OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        activity.setContentView( new Game( activity ).getRenderer() );
                    }
                } );
            button = ( Button ) activity.findViewById( R.id.button2 );
            button.setOnClickListener (
                new OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        activity.setContentView( R.layout.options );
                        new UserInterfaceHandler( activity, 2 );
                    }
                } );
            button = ( Button ) activity.findViewById( R.id.button5 );
            button.setOnClickListener (
                    new OnClickListener() {
                        @Override
                        public void onClick(View arg0) {
                            System.exit( 0 );
                        }
                    } );
          //  }

    }

    private void handleSettingsMenu( ) {
        Button button = ( Button ) activity.findViewById( R.id.button7 );
        button.setOnClickListener (
                new OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        activity.setContentView( R.layout.mainmenu );
                        new UserInterfaceHandler( activity, 1 );
                    }
                } );

    }


}
