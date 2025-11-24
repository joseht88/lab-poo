package pe.edu.utp.poo.util.collection.generic;

public class Test {
    public static void main(String[] args) {
        ParOrdenado<String, Integer> obj = new ParOrdenado<>("Celular N°", 999999999);
        System.out.println("Key = " + obj.getKey());
        System.out.println("Value = " + obj.getValue());
    }
}
