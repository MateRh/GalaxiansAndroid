package unicornprojectsstudio.galaxianandroidedition;



import android.content.res.Resources;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Level {

    private SortedArray<Ship> aiShips;


    public Level( Container container )  {
        Resources resource = Variables.resource;
        this.aiShips = container.getAiShips();
        InputStream in = resource.openRawResource( resource.getIdentifier("level" + container.getCurrentLevel(), "raw", "unicornprojectsstudio.galaxianandroidedition"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        int oneGrid = Variables.width / 12;
        int x = 0;
        int y = oneGrid*2;
        try {
        int data;
                while ((data = reader.read()) != -1) {
                    if ( data == 13 ){
                       x = 0;
                       y = y + oneGrid;
                    } else if ( data == 10 ){

                    } else if ( data == 32 ){
                        x = x + oneGrid;

                    } else {
                        int type = 0;
                            switch ( data ){
                                case 65: type = 0;break;
                                case 66: type = 3;break;
                                case 67: type = 6;break;
                                case 68: type = 7;break;
                            }

                        aiShips.add( new Ship(  x, y, Variables.shipSize, Variables.shipSize, 18 + type ) );
                        x = x + oneGrid;
                    }


            }

        } catch (IOException ex) {
            System.out.println( ex );
        } finally {
            try {
                reader.close();
            } catch (IOException ignored) {}
        }
    }


}

