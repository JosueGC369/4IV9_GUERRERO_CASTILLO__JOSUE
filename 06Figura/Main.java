class Main{
    
    public static void main(String[] args){
        try {
            //aqui solo existe la instancia de la clase de figura
            Figura obj = new Figura();
            obj.menu();
        } catch (Exception e) {
            System.out.println("Ocurrio un error inesperado en el programa: " + e.getMessage());
        } finally {
            System.out.println("El programa ha finalizado");
        }
    }
}