package unicornprojectsstudio.galaxianandroidedition;


import android.app.AlertDialog;
import android.content.Context;

public class DialogBox {

    AlertDialog.Builder box;
    AlertDialog alert;

    public DialogBox( Context context ) {
        box = new AlertDialog.Builder( context );
        box.setCancelable( false );

    }

}
