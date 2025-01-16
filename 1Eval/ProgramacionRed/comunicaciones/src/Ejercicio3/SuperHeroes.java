package Ejercicio3;

public class SuperHeroes {
    private String id;
    private String nombre;
    private String identidad;
    private String descripcion;
    private String imagen = "";
    private Boolean marvel;

    public SuperHeroes(String id, String nombre, String identidad, String Descripcion) {

        this.id = id;
        this.nombre = nombre;
        this.identidad = identidad;
        this.descripcion = Descripcion;
        this.marvel = id.contains("M");

    }

    public SuperHeroes(String[] heroes) {

        this.id = heroes[0];
        this.nombre = heroes[1];
        this.identidad = heroes[2];
        this.descripcion = heroes[3];
        this.marvel = id.contains("M");

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Boolean getMarvel() {
        return marvel;
    }

    public void setMarvel(Boolean marvel) {
        this.marvel = marvel;
    }

    @Override
    public String toString() {
        return "SuperHeroes{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", identidad='" + identidad + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", marvel=" + marvel +
                '}';
    }
}
