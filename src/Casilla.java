import acm.graphics.GImage;
import acm.util.SoundClip;

import java.io.File;

/**
 * Clase correspondiente a las casillas de la diana
 */

public class Casilla {
    private GImage imagen;
    private int x; //pos x de comienzo de la Casilla
    private int y; // pos y de comienzo de la Casilla
    private int valor;  //  valor correspondiente a la Casilla
    private SoundClip sonido; //sonido de la Casilla


    /**
     * Constructor de la casilla
     */
    public Casilla(GImage image, int valor, int coordenadax, int coordenaday, File f){
        this.imagen=image;
        this.x=coordenadax;
        this.y=coordenaday;
        this.valor=valor;
        this.sonido = new SoundClip(f);

    }


    /**
     * Getters i Setters
     */


    public GImage getImagen() {
        return imagen;
    }

    public void setImagen(GImage imagen) {
        this.imagen = imagen;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public SoundClip getSonido() {
        return sonido;
    }

    public void setSonido(SoundClip sonido) {
        this.sonido = sonido;
    }
}
