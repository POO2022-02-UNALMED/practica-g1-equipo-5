package baseDatos;
import gestorAplicacion.usuario.Cliente;

import java.io.*;

public class Serializador {
    private static File rutaTemp = new File("src\\baseDatos\\temp");

    public static void serializar(Cliente cliente) {
        FileOutputStream fos;
        ObjectOutputStream oos;
        File[] docs = rutaTemp.listFiles();
        PrintWriter pw;

        for (File file : docs) {
            try {
                pw = new PrintWriter(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        for (File file : docs) {
            if (file.getAbsolutePath().contains("prestamos.txt")) {
                try {
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(cliente.getCuenta().getPrestamo());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("bolsillos.txt")) {
                try {
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(cliente.getCuenta().getMisBolsillos());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (file.getAbsolutePath().contains("pagos.txt")) {
                try {
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(cliente.getCuenta().getMisBolsillos());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (file.getAbsolutePath().contains("transferencias.txt")) {
                try {
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(cliente.getCuenta().getMisBolsillos());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}