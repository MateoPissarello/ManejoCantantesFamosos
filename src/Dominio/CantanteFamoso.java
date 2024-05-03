package Dominio;

public class CantanteFamoso {
    private String nombre;
    private String discoConMasVentas;
    private int ventas;

    public CantanteFamoso(String nombre, String discoConMasVentas, int ventas) {
        this.nombre = nombre;
        this.discoConMasVentas = discoConMasVentas;
        this.ventas = ventas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDiscoConMasVentas() {
        return discoConMasVentas;
    }

    public void setDiscoConMasVentas(String discoConMasVentas) {
        this.discoConMasVentas = discoConMasVentas;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    @Override
    public String toString() {
        return "CantanteFamoso{" +
                "nombre='" + nombre + '\'' +
                ", discoConMasVentas='" + discoConMasVentas + '\'' +
                '}';
    }
}
