import java.util.Scanner;

public class Murdoku {

    static final int TAM = 7;

    // Identificadores de las zonas
    static final int PICNIC = 1;
    static final int JARDIN = 2;
    static final int ESTANQUE = 3;
    static final int CENADOR = 4;

    // Identificadores de los elementos
    static final int VACIO = 0;
    static final int SILLA = 1;
    static final int ALFOMBRA = 2;
    static final int ARBOL = 3;
    static final int FLORES = 4;
    static final int PIEDRA = 5;
    static final int MESA = 6;

    static Scanner teclado = new Scanner(System.in);

    // Tablero donde se colocan los personajes
    static char[][] tablero = new char[TAM][TAM];

    // Elementos fijos del escenario
    static int[][] elementos = {
            { 0, 1, 1, 0, 4, 0, 4 },
            { 3, 2, 2, 0, 0, 0, 4 },
            { 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 5, 0, 0, 3 },
            { 1, 0, 0, 0, 0, 0, 1 },
            { 0, 0, 0, 0, 0, 0, 1 },
            { 2, 2, 1, 0, 1, 6, 0 }
    };

    // Zona a la que pertenece cada casilla
    static int[][] zonas = {
            { 1, 1, 1, 1, 2, 2, 2 },
            { 1, 1, 1, 1, 2, 2, 2 },
            { 1, 1, 3, 3, 2, 2, 2 },
            { 1, 1, 3, 3, 3, 2, 2 },
            { 1, 1, 3, 3, 4, 4, 4 },
            { 1, 1, 1, 3, 4, 4, 4 },
            { 1, 1, 1, 1, 4, 4, 4 }
    };

    // Datos de los personajes
    static String[] nombres = {
            "Avery", "Bruno", "Christian",
            "Daphne", "Ethan", "Fabian", "Vicky"
    };

    static char[] letras = {
            'A', 'B', 'C', 'D', 'E', 'F', 'V'
    };

    // Indica qué personajes ya están colocados
    static boolean[] colocados = new boolean[7];

    public static void main(String[] args) {

    }

    // Devuelve el símbolo correspondiente a un elemento
    public static char simboloElemento(int elemento) {

        switch (elemento) {

            case SILLA:
                return 'S';

            case ALFOMBRA:
                return '=';

            case ARBOL:
                return 'T';

            case FLORES:
                return '*';

            case PIEDRA:
                return 'P';

            case MESA:
                return 'M';

            default:
                return '.';

        }

    }

    // Comprueba si una casilla puede ser ocupada
    public static boolean esTransitable(int fila, int columna) {

        int elemento = elementos[fila][columna];

        return elemento == VACIO
                || elemento == SILLA
                || elemento == ALFOMBRA;

    }

    // Devuelve el simbolo que se debe mostrar en una casilla
    static char simboloCasilla(int fila, int columna) {

        if (tablero[fila][columna] != '.') {
            return tablero[fila][columna];
        }

        return simboloElemento(elementos[fila][columna]);
    }

    // Muestra el tablero completo por pantalla
    static void mostrarTablero() {

        System.out.println("--- TABLERO MURDOKU ---");

        for (int fila = 0; fila < TAM; fila++) {

            for (int columna = 0; columna < TAM; columna++) {

                System.out.print(simboloCasilla(fila, columna) + " ");

            }

            System.out.println();
        }

        System.out.println();
    }

    // Muestra los personajes que todavia no se han colocado
    static void mostrarPersonajesDisponibles() {

        System.out.println("Personajes disponibles:");

        for (int i = 0; i < nombres.length; i++) {

            if (!colocados[i]) {
                System.out.println(letras[i] + " - " + nombres[i]);
            }

        }
    }

    // Comprueba que las coordenadas estan dentro del tablero
    static boolean validarCoordenadas(int fila, int columna) {

        return fila >= 0 && fila < TAM &&
                columna >= 0 && columna < TAM;
    }

    // Busca un personaje por su letra y devuelve su posicion en el array
    static int buscarPersonaje(char letra) {

        for (int i = 0; i < letras.length; i++) {

            if (letras[i] == letra) {
                return i;
            }

        }

        return -1;
    }

    // Comprueba si hay algun personaje en una fila
    static boolean filaOcupada(int fila) {

        for (int columna = 0; columna < TAM; columna++) {

            if (tablero[fila][columna] != '.') {
                return true;
            }

        }

        return false;
    }

    // Comprueba si hay algun personaje en una columna
    static boolean columnaOcupada(int columna) {

        for (int fila = 0; fila < TAM; fila++) {

            if (tablero[fila][columna] != '.') {
                return true;
            }

        }

        return false;
    }

    // Comprueba si una fila esta libre
    static boolean filaLibre(int fila) {

        return !filaOcupada(fila);
    }

    // Comprueba si una columna esta libre
    static boolean columnaLibre(int columna) {

        return !columnaOcupada(columna);
    }
}
