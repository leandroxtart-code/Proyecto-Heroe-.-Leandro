public class Vesperos extends Villano
{
    public Vesperos()
    {
        super ("Vesperos");
    }

    @Override
    public void usarPoder()
    {
        System.out.println(getNombre() + " prepara las almas poseidas contra ti");
    }
}