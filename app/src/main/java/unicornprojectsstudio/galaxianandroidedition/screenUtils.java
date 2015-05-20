package unicornprojectsstudio.galaxianandroidedition;

import android.content.Context;
import android.util.DisplayMetrics;

public class screenUtils {
    int width, height;
    public screenUtils( Context context ){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        width = metrics.widthPixels;
        height = metrics.heightPixels;

    }

    public int getWidth( ){
        return width;
    }

    public int getHeight( ){
        return height;
    }

}
