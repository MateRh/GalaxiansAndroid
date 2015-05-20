package unicornprojectsstudio.galaxianandroidedition;

import java.util.ArrayList;

public class SortedArray<T> {

    private ArrayList<T> arrayList;

    public SortedArray( ) {
        arrayList = new ArrayList<T>();
    }

    public void add( T obj ) {
        arrayList.add( obj );
    }

    public T get( int i ) {
        return arrayList.get( i );
    }

    public int size( ) {
        return arrayList.size();
    }

    public void remove( int i ) {
        arrayList.remove( i );
            if( i < size()-1 ) {
                arrayList.add( i, arrayList.get( size()-1 ) );
                arrayList.remove( size()-1 );
            }
    }
}
