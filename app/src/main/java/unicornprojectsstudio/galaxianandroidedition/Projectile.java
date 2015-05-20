package unicornprojectsstudio.galaxianandroidedition;


public class Projectile  {

    private int type;
    private float speed, x, y, sizeX, sizeY;


    public Projectile( int type, float x, float y, float sizeX, float sizeY, float speed ) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.speed = speed;

    }

    public float getX( ) {
        return x;
    }

    public float getY( ) {
        return y;
    }
    
    public int getType( ) {
        return type;
    }
    
    public void move( ) {
        y+=speed;
    }

}