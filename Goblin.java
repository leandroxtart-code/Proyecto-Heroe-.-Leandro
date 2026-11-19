public class Goblin extends Villano
{
    public Goblin()
    {
        super ("Goblin");
    }

    @Override
    public void usarPoder()
    {
        System.out.println("El " + getNombre() + " logra hacerte un corte con su daga");
    }
}

