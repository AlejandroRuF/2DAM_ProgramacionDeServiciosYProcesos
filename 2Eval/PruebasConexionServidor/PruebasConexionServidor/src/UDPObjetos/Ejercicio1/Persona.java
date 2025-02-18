package UDPObjetos.Ejercicio1;

import java.io.Serializable;

public class Persona implements Serializable {

    private String nombre;
    private int edad;

    public Persona(String nombre, int edad){
        setNombre(nombre);
        setEdad(edad);
    }

    public String getNombre(){
        return nombre;
    }

    public int getEdad(){
        return edad;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
