import java.util.Scanner;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
public class Juego
{

static final int VIDA_MAXIMA = 100;
static final int POCIONES_INICIALES = 3;
static final int CURACION_POCION = 25;
public static void main(String[] args)

    {
        Scanner teclado = new Scanner(System.in);

    
        
            System.out.println("");
            System.out.println("==================================");
            System.out.println("  Bienvenido/a a El Despertar del Héroe");
            System.out.println("==================================");

            System.out.println("");
            System.out.println("================HISTORIA==================");
            System.out.println("Eres El Vengador De Planetas.");
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
            
            int menu;
            
            String[] nombresRanking = new String[10];
            int[] puntosRanking = new int[10];
            int[] contadorRanking = {0};
        
            cargarRanking(nombresRanking, puntosRanking, contadorRanking);

            do
        {
            mostrarMenu();
            

            menu = teclado.nextInt();
            switch (menu)
            {
                case 1:
                    nuevaPartida(teclado);
                    break;
                case 2:
                    mostrarRanking(nombresRanking, puntosRanking, contadorRanking[0]);
                    break;
                case 3:
                    mostrarAyuda();
                break;
                case 4:
                    System.out.println(" Salir del Juego ");
                    System.out.println("");
                    System.out.println("Saliendo del Juego. ¡Hasta Pronto!");
                    System.out.println("");
                break;
                default:
                    System.out.println(" No es posible seguir");
            }

        } while (menu !=4);
    }
            public static void mostrarMenu()
            {
                    System.out.println();
                    System.out.println("--------------MENU PRINCIPAL--------------");
                    System.out.println("1. Nueva Partida");
                    System.out.println("2. Consultar Ranking");
                    System.out.println("3. Ayuda");
                    System.out.println("4. Salir del Juego");
                    System.out.println( "Elije una Opcion para Continuar:");
            }
            public static void mostrarRanking(String[] nombres, int[] puntos, int contador)
            {
                System.out.println("---RANKING JUGADORES Y HEROES---");
                if (contador == 0)
                {
                    System.out.println("Todavía no hay registros disponibles");
                }
                else
                {
                    for (int i = 0; i < contador; i++)
                    {
                        System.out.println((i + 1) + ". " + nombres[i] + " - " + puntos[i] + " puntos");
                    }
                }
                System.out.println("-------------------");
            }
            public static void mostrarAyuda()
            {
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
            }
            
            public static void cargarRanking(String[] nombres, int[] puntos, int[] contador)
            {
                try
                {
                    File archivo = new File("ranking.xml");
                    if (!archivo.exists()) 
                {  
                    System.out.println("El archivo ranking.xml no existe aún");
                    return;
                }
                            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
                    fabrica.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
                    DocumentBuilder constructor = fabrica.newDocumentBuilder();
                    Document documento = constructor.parse(archivo);

                    NodeList lista = documento.getElementsByTagName("partida");
                    
                    // Reiniciamos el contador
                    contador[0] = 0;

                    for (int i = 0; i < lista.getLength() && i < 10; i++) 
                    {
                        org.w3c.dom.Element partida = (org.w3c.dom.Element) lista.item(i);

                        String nom = partida.getElementsByTagName("nombre").item(0).getTextContent();
                        int pts = Integer.parseInt(partida.getElementsByTagName("puntos").item(0).getTextContent());

                        nombres[contador[0]] = nom;
                        puntos[contador[0]] = pts;
                        contador[0]++;
                    }
                    System.out.println("¡Ranking cargado con éxito desde el XML!");

                } catch (Exception e) 
                {
                    System.out.println("Error al cargar el ranking XML: " + e.getMessage());
                }
            }
            public static void nuevaPartida(Scanner teclado)
            {
                    System.out.println("Nueva Partida");
                        System.out.println("Dime tu nombre Jugador");
                        teclado.nextLine();
                        String jugador = teclado.nextLine();
                        while (jugador.isBlank())
                        {
                            System.out.println("Es necesario un nombre");
                            System.out.println("Dime tu nombre Jugador");
                            jugador = teclado.nextLine();
                        }
                        System.out.println("Introduce el nombre de tu Héroe:"); 
                        String nombre = teclado.nextLine();

                        while (nombre.isBlank())
                        {
                            System.out.println("El nombre no puede estar vacio");
                            System.out.println("Introduce el nombre de tu Héroe");
                            nombre = teclado.nextLine();
                        }
                        System.out.println("¡Bienvenido, " + jugador + "!");
                        System.out.println("Tu héroe " + nombre + " está listo para defender las Almas");
                        System.out.println("");
                        int vida = VIDA_MAXIMA;
                        int pociones = POCIONES_INICIALES;
                        int puntos = 0;
                        String[] nombresEnemigos = {"Goblin", "Orco", "Vesperos"};
                        int[] vidaEnemigos = {40, 60, 80};
                        boolean abandonar = false; 

                        for (int i = 0; i < nombresEnemigos.length; i++)
                            {
                                String enemigo = nombresEnemigos[i];
                                int vidaEnemigo = vidaEnemigos[i];
                                System.out.println("Ha aparecido " + enemigo + " con " + vidaEnemigo + " puntos de vida.");

                                while (vida > 0 && vidaEnemigo > 0 && !abandonar)
                                    
                                {
                                    boolean turnoConsumido = false;
                                    System.out.println("Tu vida: " + vida);
                                    System.out.println("La vida del enemigo es de " + vidaEnemigo);
                                    System.out.println("");
                                    System.out.println("1. atacar");
                                    System.out.println("2. Curarse");
                                    System.out.println("3. Inventario");
                                    System.out.println("4. Abandonar");
                                    int accion = teclado.nextInt();
                                    
                                    switch (accion)
                                    {
                                         case 1:
                                        int danio = (int) (Math.random() * 11) + 10;
                                        vidaEnemigo = vidaEnemigo - danio;
                                        System.out.println("Has atacado al enemigo y le has hecho " + danio + " puntos de daño.");
                                        System.out.println("");
                                        turnoConsumido = true;
                                        break;
                                         case 4: 
                                        System.out.println("Has abandonado, pero no te preocupes que lo venceras en otra ocasion");
                                        abandonar = true;
                                        break;
                                        default:
                                            System.out.println("Esa opción no es válida.");
                                    }
                                
                                    if (turnoConsumido && vidaEnemigo > 0)
                                    {
                                        int danioEnemigo = (int) (Math.random() * 11) + 5;
                                        vida = vida - danioEnemigo;
                                        System.out.println("El " + enemigo + " te ha atacado y te ha hecho " + danioEnemigo + " puntos de daño.");
                                        System.out.println("");
                                    }   
                                }   
                                    if (abandonar)
                                    {
                                        System.out.println("Preparate mejor para otra oportunidad!!");
                                        break;
                                    }
                                    else if (vida <= 0)
                                    {
                                        System.out.println("Has sido derrotado por " + enemigo + ". ¡Buen Intento!");
                                        System.out.println("");
                                        break;
                                    }
                                    else
                                    {
                                        System.out.println("Has derrotado a " + enemigo + " y has ganado 100 puntos.");
                                        System.out.println("");
                                        puntos = puntos + 100;
                                        System.out.println("Has conseguido " + 100 + " puntos");
                                    }
                            }

            }
}