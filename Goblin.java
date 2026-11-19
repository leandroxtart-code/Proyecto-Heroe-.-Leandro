public class Goblin extends Villano
{
    public Goblin()
    {
        super ("Goblin");
    }

    @Override
    public void usarPoder()
    {
        System.out.println(getNombre() + "corre hacia ti para cortarte con su daga");
    }
}

