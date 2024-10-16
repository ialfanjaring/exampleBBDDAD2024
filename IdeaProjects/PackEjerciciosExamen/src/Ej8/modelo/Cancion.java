package Ej8.modelo;

public class Cancion {
    String nombre;
    String cantante;

    public Cancion() {
    }

    public Cancion(String nombre, String cantante) {
        this.nombre = nombre;
        this.cantante = cantante;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "nombre='" + nombre + '\'' +
                ", cantante='" + cantante + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }
}
