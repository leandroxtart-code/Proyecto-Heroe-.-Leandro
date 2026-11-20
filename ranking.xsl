<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <!-- Salida: HTML en UTF-8 -->
  <xsl:output method="html" encoding="UTF-8" indent="yes" doctype-system="about:legacy-compat"/>

  <!-- Se aplica a la raíz del documento: <ranking> -->
  <xsl:template match="/ranking">
    <html lang="es">
      <head>
        <meta charset="UTF-8"/>
        <title>Ranking - El Despertar del Héroe</title>
        <!-- Ruta relativa al CSS externo -->
        <link rel="stylesheet" href="ranking.css"/>
      </head>
      <body>
        <h1>Ranking - El Despertar del Héroe</h1>

        <xsl:choose>
          <!-- Si no hay ninguna partida, mensaje claro -->
          <xsl:when test="count(partida) = 0">
            <p class="vacio">Todavía no hay registros disponibles.</p>
          </xsl:when>

          <!-- Si hay partidas, tabla con encabezados -->
          <xsl:otherwise>
            <table>
              <thead>
                <tr>
                  <th>Puesto</th>
                  <th>Jugador</th>
                  <th>Héroe</th>
                  <th>Puntos</th>
                </tr>
              </thead>
              <tbody>
                <xsl:for-each select="partida">
                  <!-- Orden numérico de mayor a menor; en empates se mantiene el orden del XML -->
                  <xsl:sort select="puntos" data-type="number" order="descending"/>
                  <tr>
                    <td><xsl:value-of select="position()"/></td>
                    <td><xsl:value-of select="nombre"/></td>
                    <td><xsl:value-of select="heroe"/></td>
                    <td><xsl:value-of select="puntos"/></td>
                  </tr>
                </xsl:for-each>
              </tbody>
            </table>
          </xsl:otherwise>
        </xsl:choose>
      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>
