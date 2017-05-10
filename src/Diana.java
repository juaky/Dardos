import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GPoint;
import java.awt.*;
import java.io.File;

/**
 * Clase correspondiente a la diana
 */
public class Diana  {
    private static final int ANCHO = 9; //Número de casillas de la diana a lo ancho
    private static final int ALTO = 9;  //Número de casillas de la diana a lo alto
    private Partida pantalla = null;
    private Casilla[][] tablero =new Casilla[ANCHO][ALTO];
    private GLabel etiqueta = new GLabel("Puntuación: ",150,550); //Etiqueta para la puntuación actual
    private GLabel record = new GLabel("", 75, 600); //Etiqueta para mostrar si se produce récord
    private GImage lanzar = new GImage("images/lanzar.png"); //Botón para lanzar dardo

    public GLabel getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(GLabel etiqueta) {
        this.etiqueta = etiqueta;
    }

    /**
     * Rellena Diana con valores i sonidos para cada casilla
     */
    public void rellenaDiana(){
        int x=0;
        for (int i = 0; i <tablero.length ; i++) {
            int y=0;
            for (int j = 0; j <tablero[i].length ; j++) {
                Casilla nuevacasilla = new Casilla(asignaImagenCasilla(i,j),asignaValorCasilla(i,j),x,y,asignaSonidoCasilla(i,j));
                tablero[i][j]=nuevacasilla;
                y+=48; //Las imágenes utilizadas son de 48x48 pixels
            }
            x+=48;  //Las imágenes utilizadas son de 48x48 pixels
        }
        this.etiqueta.setFont("Arial-BOLD-18");
        pantalla.add(etiqueta);
        pantalla.add(lanzar,120,450);
        lanzar.addMouseListener(pantalla); //El botón de lanzar estará a la escucha del ratón
    }


    /**
     * Asignar imagen a una casilla
     * @param i posición x de la casilla
     * @param j posición y de la casilla
     * @return imagen asignada a casilla en cuestión
     */
    public GImage asignaImagenCasilla(int i,int j){
        GImage imagen= null;
                switch (i){
                    case 0:
                    case 8:
                        imagen = new GImage("images/boton0.png");
                        break;
                    case 1:
                    case 7:
                        if (j>0 && j<ANCHO-1)
                            imagen = new GImage("images/boton1.png");
                        else
                            imagen = new GImage("images/boton0.png");
                        break;
                    case 2:
                    case 6:
                        if (j>1 && j<ANCHO-2)
                         imagen = new GImage("images/boton2.png");
                        else if (j==0 || j==8) imagen = new GImage("images/boton0.png");
                        else
                            imagen = new GImage("images/boton1.png");
                        break;
                    case 3:
                    case 5:
                        if (j>2 && j<ANCHO-3)
                            imagen = new GImage("images/boton5.png");
                        else if (j==0 || j==8) imagen = new GImage("images/boton0.png");
                        else if (j==1 || j==7) imagen = new GImage("images/boton1.png");
                        else imagen = new GImage("images/boton2.png");
                        break;
                    case 4:
                        if (j>3 && j<ANCHO-4)
                         imagen = new GImage("images/boton10.png");
                        else if (j==0 || j==8) imagen = new GImage("images/boton0.png");
                        else if (j==1 || j==7) imagen = new GImage("images/boton1.png");
                        else if (j==2 || j==6) imagen = new GImage("images/boton2.png");
                        else  imagen = new GImage("images/boton5.png");
                        break;
                    default:
                        imagen = new GImage("images/boton0.png");
                }
                return imagen;
    }

    /**
     * Asignar valor a una casilla
     * @param i posición x de la casilla
     * @param j posición y de la casilla
     * @return valor asignado a casilla en cuestión
     */
    public int asignaValorCasilla(int i,int j){
        int valor= 0;
        switch (i){
            case 0:
            case 8:
                valor=0;
                break;
            case 1:
            case 7:
                if (j>0 && j<ANCHO-1)
                    valor=1;
                else valor=0;
                break;
            case 2:
            case 6:
                if (j>1 && j<ANCHO-2)
                    valor=2;
                else if (j==0 || j==8) valor=0;
                else
                    valor=1;
                break;
            case 3:
            case 5:
                if (j>2 && j<ANCHO-3)
                    valor=5;
                else if (j==0 || j==8) valor=0;
                else if (j==1 || j==7) valor=1;
                else valor=2;
                break;
            case 4:
                if (j>3 && j<ANCHO-4)
                    valor=10;
                else if (j==0 || j==8) valor=0;
                else if (j==1 || j==7) valor=1;
                else if (j==2 || j==6) valor=2;
                else  valor=5;
                break;
        }
        return valor;
    }

    /**
     * Asignar sonido a una casilla
     * @param i posición x de la casilla
     * @param j posición y de la casilla
     * @return fichero de sonido asignado a casilla en cuestión
     */
    public File asignaSonidoCasilla(int i, int j){
        File f=null;
        switch (i){
            case 0:
            case 8:
                f= new File("sounds/0.wav");
                break;
            case 1:
            case 7:
                if (j>0 && j<ANCHO-1)
                    f= new File("sounds/1.wav");
                else f= new File("sounds/0.wav");
                break;
            case 2:
            case 6:
                if (j>1 && j<ANCHO-2)
                    f= new File("sounds/2.wav");
                else if (j==0 || j==8) f= new File("sounds/0.wav");
                else
                    f= new File("sounds/1.wav");
                break;
            case 3:
            case 5:
                if (j>2 && j<ANCHO-3)
                    f= new File("sounds/3.wav");
                else if (j==0 || j==8) f= new File("sounds/0.wav");
                else if (j==1 || j==7) f= new File("sounds/1.wav");
                else f= new File("sounds/2.wav");
                break;
            case 4:
                if (j>3 && j<ANCHO-4)
                    f= new File("sounds/4.wav");
                else if (j==0 || j==8) f= new File("sounds/0.wav");
                else if (j==1 || j==7) f= new File("sounds/1.wav");
                else if (j==2 || j==6) f= new File("sounds/2.wav");
                else  f= new File("sounds/3.wav");
                break;
        }
        return f;
    }

    /**
     * Dibuja la diana en pantalla
     */
    public void pintaDiana() throws InterruptedException {
        for (int i = 0; i <tablero.length ; i++)
            for (int j = 0; j <tablero[i].length ; j++) {
                pantalla.add(tablero[i][j].getImagen(), tablero[i][j].getX(), tablero[i][j].getY());
                Thread.sleep(5);
            }
    }

    /**
     * Dibujar dardo en pantalla
     * @param dardo a dibujar
     */
    public void añadeDardo(Dardo dardo){
        pantalla.add(dardo.getImagen(),dardo.getX(),dardo.getY());
    }

    /**
     * Modifica puntuación actual
     * @param puntos puntuación actual
     */
    public void modificaEtiqueta(int puntos){
        pantalla.remove(etiqueta);
        this.etiqueta= new GLabel("Puntuación: " + puntos);
        pantalla.add(this.etiqueta,150,550);
        this.etiqueta.setFont("Arial-BOLD-18");

    }

    /**
     * Añade etiqueta de récord en pantalla
     */
    public void añadeRecord() {
        record.setLabel("Nuevo Récord");
        record.setColor(Color.orange);
        pantalla.add(record);
        this.record.setFont("Arial-BOLD-35");

    }

    /**
     * Comprueba en qué casilla de la diana ha caído el dardo
     * @param dardo dardo lanzado
     * @return valor de la casilla donde cayó el dardo
     */
    public int calculaPosicionDardo(Dardo dardo){
        for (int i = 0; i <tablero.length ; i++) {
            for (int j = 0; j <tablero[i].length ; j++) {
                if (tablero[i][j].getImagen().getBounds().contains(new GPoint(dardo.getX(),dardo.getY()))){
                    tablero[i][j].getSonido().setVolume(1);//Necesario para que Java lo admita
                    tablero[i][j].getSonido().play();
                    return tablero[i][j].getValor();
                }
            }
        }
        return 0;
    }

    /**
     * Bloquea escucha del mouse
     */
    public void finalizaTiradas(){
        lanzar.removeMouseListener(pantalla);
    }

    /**
     * Añade Canvas
     * @param c Canvas a utilizar
     */
    public Diana(final Partida c){
        pantalla = c;
    }

}

