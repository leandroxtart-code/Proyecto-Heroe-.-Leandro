import java.util.Scanner;
public class Juego
{
public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

    
        
            System.out.println("");
            System.out.println("==================================");
            System.out.println("  Bienvenido/a a El Despertar del Héroe");
            System.out.println("==================================");

            System.out.println("");
            System.out.println("================HISTORIA==================");
            System.out.println("Eres Tom, el vengador de planetas.");
            System.out.println("Viajas a Sevin para liberarlo de Vesperos, el secuestrador de almas");
            System.out.println("Tu misión es derrotar a todos los enemigos que se interpongan en tu camino. ¡Y no fracases, o será el fin!");
            System.out.println("==========================================");
            System.out.println("");
        
            System.out.println("");
            System.out.println("================QUE COMIENCE EL JUEGO==================");
            System.out.println("");

            System.out.println();
            System.out.println("Pulsa la tecla -Enter- para comenzar el juego");
            teclado.nextLine();

            System.out.println("Que comience la Aventura...");

            System.out.println();
            System.out.println("--------------MENU PRINCIPAL--------------");
            System.out.println("1. Nueva Partida");
            System.out.println("2. Consultar Ranking");
            System.out.println("3. Ayuda");
            System.out.println("4. Salir del Juego");
            System.out.println( "Elije una Opcion para Continuar:");

            int menu;
            menu = teclado.nextInt();
            switch (menu)
            {
                case 1:
                    System.out.println("Nueva Partida");
                    break;
                case 2:
                    System.out.println(" Consultar Rankin");
                    break;
                case 3:
                    System.out.println(" Ayuda ");
                    System.out.println("");
                    System.out.println("---------AYUDA---------");
                    System.out.println("· El Jugador Empezará con 100 Puntos de Vida");
                    System.out.println("· Tendra 3 pociones y cada una curara 25 de vida");
                    System.out.println("· Podras atacar, defenderte, curarte o abandonar el combate");
                    System.out.println("· Tu daño de ataque varia entre 10 y 20 puntos");
                    System.out.println("· Los enemigos te haran entre 5 y 15 puntos de daño");
                    System.out.println("· Debes derrotar a todos los enemigos para liberar las almas");
                    System.out.println("· Consigues 100 puntos por cada enemigo derrotado");
                    System.out.println("· Al derrotar a tu enemigo recibiras una maximo de 3 pociones y de nuevo 100 de vida");
                    System.out.println("");
                break;
                case 4:
                    System.out.println(" Salir del Juego ");
                    System.out.println("");
                    System.out.println("Saliendo del Juego. ¡Hasta Pronto!!");
                    System.out.println("");
                break;
                default:
                    System.out.println(" No es posible seguir");
            }

    }
}
