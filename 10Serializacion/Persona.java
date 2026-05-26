public class Persona {

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int edad;
    private String correo;

    public Persona() {}

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, String correo) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edad = edad;
        this.correo = correo;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidoPaterno() { return apellidoPaterno; }
    public void setApellidoPaterno(String apellidoPaterno) { this.apellidoPaterno = apellidoPaterno; }

    public String getApellidoMaterno() { return apellidoMaterno; }
    public void setApellidoMaterno(String apellidoMaterno) { this.apellidoMaterno = apellidoMaterno; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
               "\nApellido Paterno: " + apellidoPaterno +
               "\nApellido Materno: " + apellidoMaterno +
               "\nEdad: " + edad +
               "\nCorreo: " + correo;
    }
}