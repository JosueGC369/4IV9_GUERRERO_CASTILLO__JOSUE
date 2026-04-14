public class ejemploinfografiatrycatch {
    public static void verificarEdad(int edad) throws Exception {
        if (edad < 18) {

            throw new Exception("Debes ser mayor de edad.");
    } else {
        System.out.println("Acceso permitido.");
    }
}

public static void main(String[] args){

    try{
        verificarEdad(16);
    } catch (Exception e){
        System.out.println("Error: " + e.getMessage());
    } finally {
        System.out.println("Proceso finalizado.");
    }
}
}