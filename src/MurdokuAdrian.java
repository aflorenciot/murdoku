import java.util.Scanner;

public class MurdokuAdrian {

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
        {0, 1, 1, 0, 4, 0, 4},
        {3, 2, 2, 0, 0, 0, 4},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 5, 0, 0, 3},
        {1, 0, 0, 0, 0, 0, 1},
        {0, 0, 0, 0, 0, 0, 1},
        {2, 2, 1, 0, 1, 6, 0}
    };

    // Zona a la que pertenece cada casilla
    static int[][] zonas = {
        {1, 1, 1, 1, 2, 2, 2},
        {1, 1, 1, 1, 2, 2, 2},
        {1, 1, 3, 3, 2, 2, 2},
        {1, 1, 3, 3, 3, 2, 2},
        {1, 1, 3, 3, 4, 4, 4},
        {1, 1, 1, 3, 4, 4, 4},
        {1, 1, 1, 1, 4, 4, 4}
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

    // =========================================================
    // PERSONA 2: MENU PRINCIPAL Y CONTROL DE LA PARTIDA
    // =========================================================

    // Muestra el menu, llama a las acciones y controla cuando termina el juego.
    /*public static void main(String[] args) {

        inicializarTablero();

        int opcion;
        boolean casoResuelto = false;

        do {
            System.out.println("\n========== MURDOKU: EL CASO DEL PICNIC ==========");
            mostrarTablero();
            mostrarPersonajesDisponibles();

            System.out.println("\n1. Colocar personaje");
            System.out.println("2. Retirar personaje");
            System.out.println("3. Intentar resolver el caso");
            System.out.println("4. Salir");

            opcion = leerEntero("Elige una opcion: ");

            switch (opcion) {
                case 1:
                    menuColocarPersonaje();
                    break;
                case 2:
                    menuEliminarPersonaje();
                    break;
                case 3:
                    casoResuelto = finalizarPartida();
                    break;
                case 4:
                    System.out.println("Hasta pronto.");
                    break;
                default:
                    System.out.println("Opcion no valida. Elige entre 1 y 4.");
            }

        } while (opcion != 4 && !casoResuelto);

        teclado.close();
    }*/

    // Lee un numero entero y vuelve a pedirlo si la entrada no es correcta
    public static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);

            if (teclado.hasNextInt()) {
                int numero = teclado.nextInt();
                teclado.nextLine();
                return numero;
            }

            System.out.println("Debes introducir un numero entero.");
            teclado.nextLine();
        }
    }

    // Solicita los datos necesarios para colocar un personaje
    public static void menuColocarPersonaje() {
        char personaje = ' ';
        boolean letraValida = false;

        while (!letraValida) {
            System.out.print("Introduce la letra del personaje: ");
            String texto = teclado.nextLine();

            if (texto.length() == 1) {
                char letra = Character.toUpperCase(texto.charAt(0));
                if (letra >= 'A' && letra <= 'Z') {
                    personaje = letra;
                    letraValida = true;
                } else {
                    System.out.println("Debes introducir una unica letra.");
                }
            } else {
                System.out.println("Debes introducir una unica letra.");
            }
        }

        int fila = leerEntero("Introduce la fila (1-7): ") - 1;
        int columna = leerEntero("Introduce la columna (1-7): ") - 1;
    }

}