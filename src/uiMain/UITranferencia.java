package uiMain;

import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.Cuenta;
import gestorAplicacion.usuario.CuentaAhorro;

import java.util.Scanner;

public class UITranferencia extends UIMenu  {
    public static void transaccion(Cliente cliente){
        traercuentas();
        System.out.println("Ingrese el numero de cuenta origen");
        int idOrigen= sc.nextInt();
        System.out.println("Ingrese el numero de cuenta destino");
        int idDestino= sc.nextInt();
        System.out.println("Ingrese valor a transferir");
        int valor1= sc.nextInt();
        cliente.hacerTransferencia(idOrigen,idDestino,valor1);
    }
}


