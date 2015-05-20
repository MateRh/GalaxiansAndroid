package unicornprojectsstudio.galaxianandroidedition;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.content.pm.ActivityInfo;


public class MainActivity extends ActionBarActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);


        //setContentView( R.layout.mainmenu_activity );
        Variables.resource = this.getResources();
        DisplayMetrics metrics = Variables.resource.getDisplayMetrics();
        Variables.width = metrics.widthPixels;
        Variables.height = metrics.heightPixels;
        Variables.shipSize = (int)( Variables.width * 0.07 );
        Variables.myshipSize = (int)( Variables.width * 0.1 );

       setContentView( R.layout.mainmenu );
         // setContentView( R.layout.options );
        //setContentView( new Game( this ).getRenderer() );
        new UserInterfaceHandler( this, 1 );

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
