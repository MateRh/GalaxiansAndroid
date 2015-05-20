package unicornprojectsstudio.galaxianandroidedition;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class TexturesManager {

    ArrayList<Texture> textures = new ArrayList<Texture>();

    public TexturesManager ( ) {

        textures.add( new Texture( R.drawable.background3, (int)( Variables.height / 1.28571429 ), Variables.height, true ) );
        textures.add( new Texture( R.drawable.scanlines ) );
        textures.add( new Texture( R.drawable.scanlines2 ) );
        textures.add( new Texture( R.drawable.piu ) );

        int[] _p_Counts = { 15, 9, 4 };
        int[] _p_Sizes = { 96, Variables.shipSize, Variables.myshipSize };
        String[] _p_Patchs = { "explosion", "enemy", "myship" };
        String rPatch = "unicornprojectsstudio.galaxianandroidedition";

            for( int j=0; j < 3; j++) {
                for( int i=1; i < _p_Counts[ j ]; i++) {
                    textures.add( new Texture( Variables.resource.getIdentifier( _p_Patchs[j]+i, "drawable", rPatch ), _p_Sizes[j], _p_Sizes[j], true ) );
                }
            }
        textures.add( new Texture( R.drawable.myship1,  (int)(Variables.myshipSize/1.75) , (int)(Variables.myshipSize/1.75), true ) );
    }

    public Bitmap getTexture( int id ) {

        return textures.get( id ).get();

    }


    public class Texture {
        Bitmap texture;

        public Texture( int id, int h, int w, boolean filter ) {

                Bitmap bitmap = BitmapFactory.decodeResource( Variables.resource, id );
                    texture = Bitmap.createScaledBitmap( bitmap, h, w, filter );

        }

        public Texture( int id ) {

            texture = BitmapFactory.decodeResource( Variables.resource, id );

        }

        public Bitmap get( ) {

            return texture;

        }
    }
}
