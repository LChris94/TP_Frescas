package ChrisTP.Clases;

public class Vikingo extends Humano {
    private Integer BebedorProfesional;
    private Integer cantidad_cerveza = 0;

    public Vikingo(String nombre, Integer edad, Integer peso, Integer BebedorProfesional) {
        super(nombre, edad, peso, new OrinarVikingoImp(), new BeberVikingoImp());
        this.setBebedorProfesional(BebedorProfesional);
    }



    public Integer beberViking()
    {
        this.setCantidad_cerveza(this.getCantidad_cerveza()+9);
        return  this.getBeber().tomar_fresca()+this.getBebedorProfesional();
    }

    public Integer getBebedorProfesional() {
        return BebedorProfesional;
    }

    public void setBebedorProfesional(Integer bebedorProfesional) {
        BebedorProfesional = bebedorProfesional;
    }


    @Override
    public String toString() {
        return "Nombre:'" + Nombre + '\'' +
                ", Edad:" + Edad +
                ", Peso:" + Peso;
    }

    public Integer getCantidad_cerveza() {
        return cantidad_cerveza;
    }

    public void setCantidad_cerveza(Integer cantidad_cerveza) {
        this.cantidad_cerveza = cantidad_cerveza;
    }
}
