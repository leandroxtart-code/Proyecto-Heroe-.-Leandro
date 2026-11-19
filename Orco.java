public class Orco extends Villano
{
    public Orco()
    {
        super ("Orco");
    }

    @Override
    public void usarPoder()
    {
        System.out.println(getNombre() + " te lanzara rocas y objetos punzantes");
    }
}
