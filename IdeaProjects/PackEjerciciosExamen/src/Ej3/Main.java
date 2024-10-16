package Ej3;

import Ej3.modelo.Persona;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        Persona persona1 = new Persona("Ivan",20);
        Persona persona2 = new Persona("Jose",40);
        Persona persona3 = new Persona("Manolo",60);
        List<Persona> personaList = List.of(persona1, persona2, persona3);

        //calcular edad promedio

        double edadPromedio = personaList.stream().mapToInt(Persona::getEdad).average().orElse(0);
        System.out.println("La edad promedio es " + edadPromedio);

        //Persona mas joven
        Persona personaJoven = personaList.stream().min((p1, p2) -> p1.getEdad() - p2.getEdad()).orElse(null);
        System.out.println("La persona mas joven es: " + personaJoven);

        List<String> mayores30 = personaList.stream().filter(p -> p.getEdad() > 30).map(Persona::getNombre).toList();

        System.out.println(mayores30);
    }
}
