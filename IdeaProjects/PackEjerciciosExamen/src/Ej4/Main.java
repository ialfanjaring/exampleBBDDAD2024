package Ej4;

import Ej4.modelo.Producto;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        //Calcular el producto mas caro por categoria

        List<Producto> productoList = cargaCSV("Ej4.csv");

        productoList.stream().collect(Collectors.groupingBy(Producto::getCategoria,
                        Collectors.maxBy(Comparator.comparing(Producto::getPrecio))))
                .forEach((categoria, producto )-> System.out.println("Producto más caro de la categoría " + categoria + " " + producto));
    }

    private static List<Producto> cargaCSV(String nombreFichero) {

        //Abrir el CSV
        //Leer una linea, y crear un Producto con los datos de la linea
        List <Producto> listaProducto = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(nombreFichero))){

            String linea;


            while ((linea= reader.readLine()) != null){
                String [] campos = linea.split(";");
                if (campos.length == 3){
                    String nombre = campos [0];
                    double precio = Double.parseDouble(campos [1]);
                    String campo = campos [2];

                    Producto producto = new Producto(nombre, precio, campo);
                    listaProducto.add(producto);
                }
            }


        }catch (IOException e) {
            throw new RuntimeException(e);
        }


        //devolver una lista de Productos

        return listaProducto;

    }
}
