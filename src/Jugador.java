import java.util.Random;

/**
 * Clase correspondiente al Jugador
 */
public class Jugador {
    private Dardo [] dardos;
    private int puntuacion;
    private int lanzamientos;


    /**
     * Constructor de jugador
     */
    public Jugador(){
        puntuacion=0;
        lanzamientos=0;
        dardos = new Dardo[3]; //Cada jugador dispondrá de 3 dardos
        for (int i = 0; i <dardos.length ; i++) {
            dardos[i]= new Dardo();
        }
    }

    /**
     * Método para lanzar un dardo
     * @param dardo a lanzar
     */
    public void lanzarDardo(Dardo dardo){
        Random aleatorio = new Random();
        dardo.setX(aleatorio.nextInt(432));
        dardo.setY(aleatorio.nextInt(432));
    }


    /**
     * Getters y setters
     */
    public Dardo[] getDardos() {
        return dardos;
    }


    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getLanzamientos() {
        return lanzamientos;
    }

    public void setLanzamientos(int lanzamientos) {
        this.lanzamientos = lanzamientos;
    }
}
