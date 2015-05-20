package unicornprojectsstudio.galaxianandroidedition;


import android.content.DialogInterface;


public class DeadDialogBox extends DialogBox{

    public DeadDialogBox( final Container container, long score, int lives ) {
        super( container.getContext() );
        box.setMessage( "\n Your score: " + score + "\n\n Left lifes: " + lives + "\n" );
        box.setIcon( R.drawable.icon1 );
        box.setPositiveButton( "Try again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick( DialogInterface dialog, int which ) {

                container.setFrozen( false );
                SortedArray<Ship> aiShips = container.getAiShips();
                aiShips.get( 0 ).x = ( Variables.width - Variables.myshipSize * 4 ) / 2;
                dialog.cancel();

            }
        } );
        alert = box.create();
        alert.setTitle("Your ship was destroyed!");
        alert.show();

    }

}

