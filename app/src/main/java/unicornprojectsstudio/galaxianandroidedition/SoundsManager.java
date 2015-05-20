package unicornprojectsstudio.galaxianandroidedition;


import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import java.util.ArrayList;

public class SoundsManager {

    private ArrayList<Integer> sounds = new ArrayList<Integer>();
    private AudioManager manager;
    private float volume;
    private SoundPool pool;


    public SoundsManager(  Context context ) {
        manager = (AudioManager) context.getSystemService( Context.AUDIO_SERVICE );
        volume = manager.getStreamVolume( AudioManager.STREAM_MUSIC ) / manager.getStreamMaxVolume( AudioManager.STREAM_MUSIC );
        pool = new SoundPool( 8, AudioManager.STREAM_MUSIC, 0 );

        sounds.add( pool.load( context, R.raw.laser, 1 ) );
        sounds.add( pool.load( context, R.raw.explosion, 1 ) );
    }

    public void play( int id ) {
        volume = manager.getStreamVolume( AudioManager.STREAM_MUSIC );
        pool.play( sounds.get( id ), volume, volume, 1, 0, 1f );
    }


}
