# El Despertar del Héroe
Juego por turnos, tu tarea es liberar las almas secuestradas por Vesperos para conseguir la victoria
Derrota a todos los enemigos, consigue la mayor cantidad de puntos posible y alcanza el primer puesto del ranking. 

# Versión
Version 1.0 del Juego. 

## Requisitos
- JDK: 26.0.2.1
- IDE: Visual Studio Code

## Cómo compilar y ejecutar
1. Abre una terminal en la carpeta del proyecto
2. Compila los archivos Java:
    `´
    javac *.java
    `´
3. Ejecuta el Juego:
    `´
    java Juego
    `´
    
## Reglas del juego
El jugador comienza por 100 puntos de vida.
Dispone de 3 pociones que te curarán 25 de vida cada una.
Puedes atacar, curarte, mirar tu inventario o abandonar el combate.
El héroe hara entre 10 y 20 de daño
El daño de los enemigos varia entre 5 y 15
Debes derrotar a todos los enemigos para liberar las almas.
Consigues 100 puntos por cada enemigo derrotado.
Las puntuaciones se guardan en un archivo XML y se muestran en el ranking.
El ranking almacena las 10 mejores puntuaciones.

## Archivos del Proyecto
Juego.java: Contiene la lógica principal del juego
ranking.xml: almacena las puntuaciones de los jugadores.
ranking.dtd: define la estructura que debe cumplir el archivo XML.