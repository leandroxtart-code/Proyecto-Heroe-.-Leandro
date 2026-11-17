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
        System.out.println(nombre + " corre hacia ti para golpearte");
    }
    
    public void saltar()
    {
        System.out.println(nombre + " da un salto agil");
    }

    public void usarPoder()
    {
        System.out.println(nombre + " prepara su poder");
    }
}
