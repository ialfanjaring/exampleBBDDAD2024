package Ej1;

import Ej1.modelo.Producto;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Producto producto1 = new Producto(1, "Producto1", 50, true, '1');
        Producto producto2 = new Producto(2, "Producto2", 50, true, 'a');
        Producto producto3 = new Producto(3, "Producto3", 8, true, 'a');
        Producto producto4 = new Producto(4, "Producto4", 50, false, 'a');
        Producto producto5 = new Producto(5, "Producto5", 50, true, 'k');
        Producto producto6 = new Producto(6, "Producto6", 133, false, 'a');
        Producto producto7 = new Producto(7, "Producto7", 50, true, 'a');
        List<Producto> productoList = List.of(producto1,producto2,producto3,producto4,producto5,producto6,producto7);




        //System.out.println(productos);

        escribeFicheroBinario("productos.dat", productoList);

        leerFicheroBinario("productos.dat");
    }

    private static void leerFicheroBinario(String nombreFichero) {

        try (RandomAccessFile raf = new RandomAccessFile(nombreFichero, "rw")){
            //Calcular el tamaño de bloque (El mismo que al escribir);
            /*
            raf.writeInt(p.getId());
            raf.writeBytes(String.format("%-10s", p.getNombre()));
            raf.writeDouble(p.getPrecio());
            raf.writeBoolean(p.isDescuento());
            raf.writeChar(p.getTipo());
             */
            int tamañoDeBloque = Integer.BYTES + 10 + Double.BYTES + 1 + Character.BYTES;

            raf.seek(0);

            while (raf.getFilePointer() < raf.length()){
                int id = raf.readInt();
                byte [] nombreByte = new byte[10];
                raf.readFully(nombreByte);
                String nombre = new String(nombreByte).trim();
                double precio = raf.readDouble();
                boolean descuento = raf.readBoolean();
                char tipo = raf.readChar();

                Producto producto = new Producto(id,nombre,precio,descuento,tipo);

                System.out.println(producto);

            }

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private static void escribeFicheroBinario(String nombreFichero, List<Producto> productoList) {

        try (RandomAccessFile raf = new RandomAccessFile(nombreFichero, "rw")){
            for (Producto p: productoList){
               // System.out.println(p);
                raf.writeInt(p.getId());
                raf.writeBytes(String.format("%-10s", p.getNombre()));
                raf.writeDouble(p.getPrecio());
                raf.writeBoolean(p.isDescuento());
                raf.writeChar(p.getTipo());
            }

        }catch (IOException e){
            throw new RuntimeException(e);
        }



    }
}
