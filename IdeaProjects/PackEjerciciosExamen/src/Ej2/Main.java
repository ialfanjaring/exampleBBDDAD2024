package Ej2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String archivoOriginal = "archivoOriginal.txt";
        String archivoRemplazado = "archivoRemplazado.txt";
        String cadenaBuscar = "nec";
        String cadenaRemplezar = "BETIS";

        buscarYRemplazar(archivoOriginal,archivoRemplazado,cadenaBuscar,cadenaRemplezar);



    }

    private static void buscarYRemplazar(String archivoOriginal, String archivoRemplazado, String cadenaBuscar, String cadenaRemplezar) {

        try(BufferedReader reader = new BufferedReader(new FileReader(archivoOriginal));
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivoRemplazado))){
            String linea;
            while ((linea = reader.readLine()) != null) {
                String lineaModificada = linea.replace(cadenaBuscar, cadenaRemplezar);
                writer.write(lineaModificada);
                writer.newLine();
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
