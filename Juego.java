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
            String[] heroesRanking = new String[10];
            int[] puntosRanking = new int[10];
            int[] contadorRanking = {0};
        
            cargarRanking(nombresRanking, heroesRanking, puntosRanking, contadorRanking);

            do
        {
            mostrarMenu();

            menu = teclado.nextInt();
            switch (menu)
            {
                case 1:
                    nuevaPartida(teclado);
                    cargarRanking(nombresRanking, heroesRanking, puntosRanking, contadorRanking);
                    break;
                case 2:
                    mostrarRanking(nombresRanking, heroesRanking, puntosRanking, contadorRanking[0]);
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
            public static void mostrarRanking(String[] nombres, String[] heroe, int[] puntos, int contador)
            {
                System.out.println("---RANKING JUGADORES, HEROES y PUNTOS---");
                if (contador == 0)
                {
                    System.out.println("Todavía no hay registros disponibles");
                }
                else
                {
                    int limite = Math.min(contador, puntos.length);

                    for (int i = 0; i < limite; i++)
                    {
                        System.out.println((i + 1) + ". " + nombres[i] + " - " + heroe[i] + " - " + puntos[i] + " puntos");
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
            
            public static void cargarRanking(String[] nombres, String[] heroe, int[] puntos, int[] contador)
            {
                try
                {
                    File archivo = new File("ranking.xml");
                    if (!archivo.exists()) 
                {  
                    contador[0] = 0;
                    return;
                }
                    DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
                    fabrica.setFeature("http://apache.org/xml/features/disallow-doctype-decl", false);
                    DocumentBuilder constructor = fabrica.newDocumentBuilder();
                    Document documento = constructor.parse(archivo);

                    NodeList lista = documento.getElementsByTagName("partida");
                    int totalPartidas = lista.getLength();
                    
                    if(totalPartidas == 0)
                {
                    contador[0] = 0;
                    return; 
                }
                    String[] tempNombres = new String[totalPartidas];
                    String[] tempHeroes = new String[totalPartidas];
                    int[] tempPuntos = new int[totalPartidas];
                    int validas = 0;

                    for (int i = 0; i < totalPartidas; i++) 
                    {
                        try
                        {
                            org.w3c.dom.Element partida = (org.w3c.dom.Element) lista.item(i);
                            
                            NodeList nList = partida.getElementsByTagName("nombre");
                            NodeList hList = partida.getElementsByTagName("heroe");
                            NodeList pList = partida.getElementsByTagName("puntos");  

                            if(nList.getLength() > 0 && hList.getLength() > 0 && pList.getLength() > 0)
                            {
                                tempNombres[validas] = nList.item(0).getTextContent();
                                tempHeroes[validas] = hList.item(0).getTextContent();
                                tempPuntos[validas] = Integer.parseInt(pList.item(0).getTextContent());
                                validas++;
                            }
                        } catch (Exception ex){}
                        
                    }
                    if (validas == 0) 
                    {
                        contador[0] = 0;
                        return;
                    }

                    for (int i = 0; i < validas - 1; i++)
                    {
                        for (int j = 0; j < validas - 1 - i; j++)
                        {
                            if (tempPuntos[j] < tempPuntos[j + 1])
                            {
                                int auxPuntos = tempPuntos[j];
                                tempPuntos[j] = tempPuntos[j + 1];
                                tempPuntos[j + 1] = auxPuntos;

                                String auxNombre = tempNombres[j];
                                tempNombres[j] = tempNombres[j + 1];
                                tempNombres[j + 1] = auxNombre;

                                String auxHeroe = tempHeroes[j];
                                tempHeroes[j] = tempHeroes[j + 1];
                                tempHeroes[j + 1] = auxHeroe;
                            }
                        }
                    }
                    
                    int cuantosCopia = Math.min(10, validas);
                    for (int i = 0; i < cuantosCopia; i++)
                    {
                        nombres[i] = tempNombres[i];
                        heroe[i] = tempHeroes[i];
                        puntos[i] = tempPuntos[i];
                    }   
                    contador[0] = cuantosCopia;
                    
                    System.out.println("¡Ranking cargado con éxito desde el XML!");
                }
                catch (Exception e) 
                {
                    System.out.println("Aviso: El ranking se inicializara limpio.");
                    contador[0] = 0;
                }    
            }
            
            public static void guardarRanking(String jugador, String heroe, int puntos) 
            {
                try
                {
                    File archivo = new File("ranking.xml");
                    DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
                    fabrica.setFeature("http://apache.org/xml/features/disallow-doctype-decl", false);
                    DocumentBuilder constructor = fabrica.newDocumentBuilder();
                    Document documento;

                    if(archivo.exists())
                    {
                        documento = constructor.parse(archivo);
                    }
                    else
                    {
                        documento = constructor.newDocument();
                        Element raiz = documento.createElement("ranking");
                        documento.appendChild(raiz);
                    }
                    Element raiz = documento.getDocumentElement();

                    Element nuevaPartida = documento.createElement("partida");

                    Element nodoJugador = documento.createElement("nombre");
                    nodoJugador.setTextContent(jugador);
                    nuevaPartida.appendChild(nodoJugador);
                    
                    Element nodoHeroe = documento.createElement("heroe");
                    nodoHeroe.setTextContent(heroe);
                    nuevaPartida.appendChild(nodoHeroe);

                    Element nodoPuntos = documento.createElement("puntos");
                    nodoPuntos.setTextContent(String.valueOf(puntos));
                    nuevaPartida.appendChild(nodoPuntos);

                    raiz.appendChild(nuevaPartida);

                    javax.xml.transform.TransformerFactory transformerFactory = javax.xml.transform.TransformerFactory.newInstance();
                    javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
                    transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
                    javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(documento);
                    javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(archivo);
                    transformer.transform(source, result);

                    System.out.println("¡Partida Guardada en el ranking correctamente!");
                }
                    catch (Exception e)
                    {
                        System.out.println("Error al guardar el ranking" + e.getMessage());
                    }
            }

            public static int usarPocion(int vida, int[] inventario, int pocionesDisponibles)
            {
                if(pocionesDisponibles == 0)
                {
                    System.out.println("No te quedan más pociones");
                    return vida;
                }
                else if (vida == VIDA_MAXIMA)
                {
                    System.out.println("Tu vida ya está completa");
                    return vida;
                }
                else
                {
                    inventario[pocionesDisponibles - 1] = 0;
                    int vidaNueva = vida + CURACION_POCION;
                    if (vidaNueva > VIDA_MAXIMA) 
                    {
                        vidaNueva = VIDA_MAXIMA;
                    }
                    System.out.println("Tu vida ahora es de " + vidaNueva);          
                    return vidaNueva;
                }
            }
                public static void mostrarInventario(int[] inventario, int pocionesDisponibles)
            {
                System.out.println("Tienes " + pocionesDisponibles + " pociones");
                for (int i = 0; i < pocionesDisponibles; i++)
                {
                    System.out.println("Poción " + (i + 1) + ": cura " + inventario[i]);
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
                        int[] inventario = new int [POCIONES_INICIALES];

                        for (int i = 0; i < inventario.length; i++)
                        {
                            inventario[i] = CURACION_POCION;
                        }
                        int pocionesDisponibles = inventario.length;
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
                                         case 2:
                                            System.out.println("");
                                            int vidaJugador = vida;
                                            vida = usarPocion(vida, inventario, pocionesDisponibles);
                                            
                                            if (vida > vidaJugador) 
                                            {
                                                System.out.println("Has recuperado " + (vida - vidaJugador) + " de vida");
                                                pocionesDisponibles--;
                                                turnoConsumido = true;
                                            }
                                            break;
                                         case 3: 
                                        mostrarInventario(inventario, pocionesDisponibles);
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
                            
                        if (!abandonar && vida > 0)
                        {
                            puntos = puntos + vida;
                            System.out.println("¡Has completado el juego! Bonificación de vida restante: " + vida + " puntos");
                        }

                        System.out.println("Puntuación total conseguida: " + puntos + " puntos");
                        guardarRanking(jugador, nombre, puntos);
                            
            }
}
            