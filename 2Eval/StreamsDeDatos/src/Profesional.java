public class Profesional {

    private String nombre;
    private int edad;
    private char genero;
    private int profesional;
    private String profesionalStr;

    public Profesional(String nombre, int edad, char genero, int profesional) throws Exception {
        setEdad(edad);
        setGenero(genero);
        setNombre(nombre);
        setProfesional(profesional);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) throws Exception {
        if (genero != 'M' && genero != 'F' && genero != 'm' && genero != 'f') {
            throw new Exception("El valor de genero debe ser M o F");
        }else {
            this.genero = genero;
        }
    }

    public int getProfesional() {
        return profesional;
    }

    public void setProfesional(int profesional) throws Exception {
        if (profesional != 1 && profesional != 2 && profesional != 3){
            throw new Exception("El valor de profesional debe ser 1, 2 o 3");
        }else {
            this.profesional = profesional;
            if (profesional == 1) {
                this.profesionalStr = "Jugador";
            } else if (profesional == 2) {
                this.profesionalStr = "Directivo";
            } else {
                this.profesionalStr = "Fisio";
            }
        }
    }

    public String getProfesionalStr() {
        return profesionalStr;
    }

    @Override
    public String toString() {
        return "Profesional{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", genero=" + genero +
                ", profesional=" + profesional +
                ", profesionalStr='" + profesionalStr + '\'' +
                '}';
    }
}
