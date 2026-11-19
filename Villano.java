public class Villano
{   
    private String nombre;

    public Villano (String nombre)
    {
        this.nombre = nombre;
    }
    
    public String getNombre()
    {
        return nombre;
    }

    public void presentar() 
    {
        System.out.println("Se presenta mi siguiente enemigo (" + nombre + ")");
    }

    public void correr()
    {
        System.out.println("El " + nombre + " corre hacia ti para atacarte");
    }
    
    public void saltar()
    {
        System.out.println("El " + nombre + " da un salto ágil");
    }

    public void usarPoder()
    {
        System.out.println("El " + nombre + " prepara su poder para usarlo contra ti");
    }
}
