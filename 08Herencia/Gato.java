
public class Gato extends Animal{

    private int num_vidas;

    public Gato(){

    }
    //quiero acceder a los atributos de la clase padre
    public Gato(String nombre, String raza, String tipo_alimento, int edad, int num_vidas){
        //como puedo obtenerlo ocupo la palabra reservada super
        super(nombre, raza, tipo_alimento, edad);
        this.num_vidas = num_vidas;

    }

    public int getNum_vidas(){
        return num_vidas;
    }

    public void setNum_vidas(int num_vidas){
        this.num_vidas = num_vidas;
    }

    //metodo propio del señor gato
    public void mostrarGato(){
        System.out.println("El nombre del michi es: " + getNombre() + "\n"
        +" Su raza es: " + getRaza() + "\n"
        +" Su comida es: " + getTipo_alimento() + "\n"
        +" Su Edad es : " + getEdad() + "\n"
        +" El num de vidas que le resta son: " + num_vidas + "\n");
    }

}