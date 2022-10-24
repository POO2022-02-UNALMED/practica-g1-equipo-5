package baseDatos;

import gestorAplicacion.transacciones.Bolsillo;
import gestorAplicacion.transacciones.Prestamo;
import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.Cuenta;
import gestorAplicacion.usuario.CuentaAhorro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Deserializador {
    private static File rutaTemp = new File("src\\baseDatos\\temp");

    public static void deserializar(Cliente cliente){
        File[] docs = rutaTemp.listFiles();
        FileInputStream fis;
        ObjectInputStream ois;

        for (File file : docs) {
            if (file.getAbsolutePath().contains("prestamos.txt")){
                try {
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);

                    Cliente.setListaCuentas((ArrayList<Cuenta>) ois.readObject());
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                } catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("bolsillos.txt")) {
                try {
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);

                    Cliente.listarCuentas().setMisBolsillos((ArrayList<Bolsillo>) ois.readObject());
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                } catch (ClassNotFoundException e){
                    e.printStackTrace();
                }

            } /* else if (file.getAbsolutePath().contains("pagos.txt")) {
                try {
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);

                    cliente.getCuenta().setMisBolsillos((ArrayList<Bolsillo>) ois.readObject());
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                } catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("trasnferencias.txt")) {
                try {
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);

                    cliente.getCuenta().setMisBolsillos((ArrayList<Bolsillo>) ois.readObject());
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                } catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
            }*/
        }
    }

}
