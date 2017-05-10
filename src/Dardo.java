import acm.graphics.GImage;
import java.util.Random;

/**
 * Clase correspondiente al dardo
 */
public class Dardo {
    private int x=-3;
    private int y=-4;
    private GImage imagen = new GImage("images/dardo.png");;


    /**
     * Getters i Setters
     */

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public GImage getImagen() {
        return imagen;
    }

    public void setImagen(GImage imagen) {
        this.imagen = imagen;
    }
}