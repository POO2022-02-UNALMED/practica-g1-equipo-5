package uiMain;

import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.Cuenta;
import gestorAplicacion.usuario.CuentaAhorro;

import java.util.Scanner;

public class UITranferencia extends UIMenu  {
    public static void transaccion(Cliente cliente) {
        Scanner sc = new Scanner(System.in);
        UIMenu.traercuentas();
        System.out.println("Ingrese el numero de cuenta origen");
        int idOrigen = sc.nextInt();
        System.out.println("Ingrese el numero de cuenta destino");
        int idDestino = sc.nextInt();
        if (idOrigen >= 0 && idOrigen < Cliente.listaCuentas.size() && idDestino < Cliente.listaCuentas.size()) {
            System.out.println("Ingrese valor a transferir");
            int valor1 = sc.nextInt();

            System.out.println( cliente.hacerTransferencia(idOrigen, idDestino, valor1));

        }
    }
}


