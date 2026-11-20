# Consultas XPath sobre el ranking

Archivo de prueba: `ranking_prueba.xml` (copia fija de `ranking.xml`, con 10 partidas, para que los resultados no cambien cuando el juego añada partidas).

Estructura del XML: `ranking` > `partida` > `nombre`, `heroe`, `puntos`.

> Comprueba el resultado esperado leyendo `ranking_prueba.xml`, ejecuta la consulta y apunta después lo que veas en pantalla como resultado obtenido.
> Usa comillas rectas (' o ") en las expresiones, no las curvas de Word.

## Consulta 1. Selección de campos

- **Pregunta:** ¿Qué héroes hay registrados en el ranking?
- **Expresión:** `/ranking/partida/heroe/text()`
- **Archivo de prueba:** `ranking_prueba.xml`
- **Resultado esperado:** 10 héroes: Vengador, Panchi, Pruebas, Pruebas2, Pierdo, Abandonar, Pruebas7, Prueba8, Prueba9, Prueba19
- **Resultado obtenido:** [rellena tras ejecutarla]

## Consulta 2. Filtro por puntuación

- **Pregunta:** ¿Qué partidas tienen más de 300 puntos?
- **Expresión:** `/ranking/partida[number(puntos) > 300]`
- **Archivo de prueba:** `ranking_prueba.xml`
- **Resultado esperado:** 5 partidas: Panchi (344), Pruebas (315), Pruebas2 (331), Prueba8 (324) y Prueba19 (341). Carlos no aparece porque tiene 300 y no es mayor que 300
- **Resultado obtenido:** [rellena tras ejecutarla]

## Consulta 3. Filtro por jugador

- **Pregunta:** ¿Qué héroes ha usado el jugador Carlos?
- **Expresión:** `/ranking/partida[normalize-space(nombre) = 'Carlos']/heroe/text()`
- **Archivo de prueba:** `ranking_prueba.xml`
- **Resultado esperado:** Vengador
- **Resultado obtenido:** [rellena tras ejecutarla]

## Consulta 4. Combinación de condiciones en un predicado

- **Pregunta:** ¿Qué héroes ha usado Lean en partidas de entre 200 y 315 puntos?
- **Expresión:** `/ranking/partida[normalize-space(nombre) = 'Lean' and number(puntos) >= 200 and number(puntos) <= 315]/heroe/text()`
- **Archivo de prueba:** `ranking_prueba.xml`
- **Resultado esperado:** Pruebas, Pierdo, Abandonar, Pruebas7 y Prueba9. El rango deja fuera a Panchi, Pruebas2, Prueba8 y Prueba19, y el nombre deja fuera a Carlos (300 puntos)
- **Resultado obtenido:** [rellena tras ejecutarla]

## Consulta 5. Recuento

- **Pregunta:** ¿Cuántas partidas tienen más de 300 puntos?
- **Expresión:** `count(/ranking/partida[number(puntos) > 300])`
- **Archivo de prueba:** `ranking_prueba.xml`
- **Resultado esperado:** 5
- **Resultado obtenido:** [rellena tras ejecutarla]
