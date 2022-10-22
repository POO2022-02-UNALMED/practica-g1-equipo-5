package baseDatos.temp;

import gestorAplicacion.usuario.Cuenta;

import java.io.*;

public class Serializador {
    private static File rutaTemp = new File("src\\baseDatos\\temp");

    public static void serializar(Cuenta cuenta){
        FileOutputStream fos;
        ObjectOutputStream oos;
        File[] docs= rutaTemp.listFiles();
        PrintWriter pw;

        for (File file:docs){
            try {
                pw= new PrintWriter(file);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }

        for (File file: docs){
            if(file.getAbsolutePath().contains("cliente")){
                try {
                    fos=new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(cuenta.getTitular());
                }catch (FileNotFoundException e){
                    e.printStackTrace();

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            else if (file.getAbsolutePath().contains("cliente")) {
                try{
                    fos=new FileOutputStream(file);
                    oos=new ObjectOutputStream(fos);
                    oos.writeObject(cuenta.getSaldoDisponible());
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

