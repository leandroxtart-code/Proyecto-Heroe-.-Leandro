# El Despertar del Héroe
 
Aventura de texto por turnos hecha en Java. El jugador crea un héroe y se enfrenta a tres enemigos (Goblin, Orco y Vesperos) para liberar las almas secuestradas. Las mejores puntuaciones se guardan en un ranking en XML, que se valida con una DTD, se consulta con XPath y se publica como tabla HTML con XSLT y CSS.
 
## Versión
 
Versión 1.0 del juego.
 
## Requisitos
- JDK 26.0.2.1 (solo se usa la API estándar del JDK; no hay que descargar librerías).
- IDE: Visual Studio Code, con las extensiones de Java y de XML (XML Tools).
- Sistema: Windows.

## Estructura de carpetas 
Todo está en la carpeta del proyecto y se usan rutas relativas.
 
| Archivo / carpeta | Contenido |
|---|---|
| `Juego.java` | Menú, combate, pociones, ranking y carga/guardado del XML |
| `Villano.java`, `Goblin.java`, `Orco.java`, `Vesperos.java` | Enemigos: clase padre y tres hijas (herencia) |
| `ranking.xml` | Ranking del juego (de 0 a 10 registros) |
| `ranking.dtd` | Reglas de estructura del XML |
| `ranking_prueba.xml` | Copia fija con 10 partidas para probar XPath y XSLT |
| `consultas_xpath.md` | Las cinco consultas XPath con resultado esperado y obtenido |
| `ranking.xsl` | Transformación XSLT del XML a HTML |
| `ranking.css` | Estilos de la tabla (enlazado desde el HTML con ruta relativa) |
| `ranking.html` | HTML generado a partir de `ranking.xml` |
| `Transformar.java` | Utilidad de apoyo para ejecutar el XSLT (ver el último apartado) |
| `evidencias/` | Capturas de pruebas y depuración y copias de XML con errores |
| `.gitignore` | Excluye `.class`, carpetas de salida y configuración local del editor |
 
## Cómo compilar y ejecutar el juego 
1. Abre una terminal en la carpeta del proyecto.
2. Compila: `javac *.java`
3. Ejecuta: `java Juego`

## Reglas del juego 
- El héroe empieza con 100 puntos de vida y 3 pociones que curan 25 cada una (la vida nunca pasa de 100).
- En cada turno puede atacar, curarse, mirar el inventario o abandonar.
- Su ataque hace entre 10 y 20 de daño. Los enemigos hacen entre 5 y 15.
- Los enemigos tienen 40, 60 y 80 puntos de vida. Hay que derrotar a los tres.
- Cada enemigo derrotado da 100 puntos. Si se gana la aventura se suma la vida restante como bonificación.
- Elegir una opción no válida, mirar el inventario o curarse sin pociones o con la vida completa no gasta turno.

## Ranking y persistencia
- El ranking se guarda en `ranking.xml`, en la misma carpeta que el juego.
- Se carga al iniciar el juego y se guarda al terminar cada partida. Guarda como máximo 10 registros ordenados de mayor a menor puntuación; en los empates va primero el más antiguo.
- Si `ranking.xml` no se puede leer, el juego avisa y no lo sobrescribe.
- Para restablecer una copia de prueba (esto sustituye el ranking actual): `copy ranking_prueba.xml ranking.xml`

## Validar el XML con la DTD 
`ranking.xml` incluye la línea `<!DOCTYPE ranking SYSTEM "ranking.dtd">`.
 
1. Abre `ranking.xml` en Visual Studio Code.
2. Abre el panel Problems: si no aparece ningún error, el XML es válido.
Las copias con errores intencionados están en `evidencias/` y se explican en la memoria.
 
## Consultas XPath
1. Abre `ranking_prueba.xml` en Visual Studio Code.
2. Pulsa Ctrl+Shift+P y elige `XML Tools: Evaluate XPath`.
3. Escribe la expresión de `consultas_xpath.md` y pulsa Enter.

## Generar el HTML con XSLT
Entrada: `ranking.xml` y `ranking.xsl`. Salida: `ranking.html`.

1. Compila (si no lo has hecho): `javac *.java`
2. Ejecuta: `java Transformar`
3. Abre `ranking.html` en el navegador. Usa `ranking.css` por ruta relativa.
Para probar con otra copia: `java Transformar ranking_prueba.xml prueba.html`.
Si cambias un dato del XML y repites el paso 2, la tabla se actualiza.
 
## Utilidades de apoyo y procedencia 
- `Transformar.java`: utilidad que aplica `ranking.xsl` a un XML y escribe el HTML. Está hecha con ayuda de una herramienta de IA (se detalla en el apartado de uso de IA de la memoria). Usa solo el procesador XSLT del JDK (`javax.xml.transform`), sin descargar nada.
- No se usan librerías externas.