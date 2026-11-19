public class Orco extends Villano
{
    public Orco()
    {
        super ("Orco");
    }

    @Override
    public void usarPoder()
    {
        System.out.println("Este " + getNombre() + " te lanzará rocas u objetos punzantes y pesados");
    }
}
