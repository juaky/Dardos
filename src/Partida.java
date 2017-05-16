import acm.program.GraphicsProgram;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.Scanner;

//prueba de github

/**
 * Clase principal de inicio del juego
 */
public class Partida extends GraphicsProgram implements MouseListener{
    private Jugador jugador =null;  //Jugador actual
    private Diana mitablero = null;  //Diana
    private int puntuacion;  //Puntuación obtenida en un lanzamiento
    private File record = null; //Fichero donde se almacena el récord

    /**
     * Constructor
     * Inicializa datos para comenzar la partida
     * @param jugador jugador que está jugando acutalmente
     */
    public Partida(Jugador jugador){
        this.jugador = jugador;
        jugador.setLanzamientos(0);
        mitablero = new Diana(this);
        puntuacion=0;
        record = new File("./record.txt");
        if (!record.exists()) try {
            System.out.println(record.createNewFile());
            PrintStream davalor = new PrintStream("./record.txt");
            davalor.print(0);
            davalor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ejecución del programa
     */
    public void run (){
        this.setSize(450,800);
        mitablero.rellenaDiana();
        try {
            mitablero.pintaDiana();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Puntuación total: " + jugador.getPuntuacion());
    }

    /**
     * Método que implementa las acciones a realizar al lanzar dardo
     * @param e Evento click
     */
    public void mouseClicked(MouseEvent e) {
        jugador.lanzarDardo(jugador.getDardos()[jugador.getLanzamientos()]);
        mitablero.añadeDardo(jugador.getDardos()[jugador.getLanzamientos()]);
        puntuacion = mitablero.calculaPosicionDardo(jugador.getDardos()[jugador.getLanzamientos()]);
        jugador.setPuntuacion(jugador.getPuntuacion()+puntuacion);
        mitablero.modificaEtiqueta(jugador.getPuntuacion());
        jugador.setLanzamientos(jugador.getLanzamientos()+1);
        if (jugador.getLanzamientos()==3) {
           mitablero.finalizaTiradas();
           try {
               Scanner leerrecord = new Scanner(record);
               int nuevorecord = jugador.getPuntuacion();
               PrintStream escribirrecord = null;
               if (leerrecord.nextInt()<nuevorecord){
                   try {
                       escribirrecord = new PrintStream(new File("./record.txt"));
                       escribirrecord.print(nuevorecord);
                       mitablero.añadeRecord();
                   } catch (IOException e1) {
                       e1.printStackTrace();
                   }
                   leerrecord.close();
               }
           } catch (FileNotFoundException e1) {
               e1.printStackTrace();
           }
       }
    }


    public static void main(String[] args) {
            new Partida(new Jugador()).start(args);
    }
}
