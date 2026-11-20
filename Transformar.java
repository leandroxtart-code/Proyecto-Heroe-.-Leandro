import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

// Utilidad de apoyo: aplica ranking.xsl a un XML y escribe el HTML resultante.
// Usa el procesador XSLT que incluye el JDK (paquete javax.xml.transform), sin descargar nada.
//
// Uso:
//   java Transformar                       -> ranking.xml  ->  ranking.html
//   java Transformar otro.xml otro.html    -> para probar con copias
public class Transformar
{
    public static void main(String[] args)
    {
        String xml = "ranking.xml";
        String html = "ranking.html";

        if (args.length >= 2)
        {
            xml = args[0];
            html = args[1];
        }

        try
        {
            TransformerFactory fabrica = TransformerFactory.newInstance();
            Transformer transformador = fabrica.newTransformer(new StreamSource(new File("ranking.xsl")));
            transformador.transform(new StreamSource(new File(xml)), new StreamResult(new File(html)));
            System.out.println("Generado " + html + " a partir de " + xml);
        }
        catch (Exception e)
        {
            System.out.println("Error al transformar: " + e.getMessage());
        }
    }
}
