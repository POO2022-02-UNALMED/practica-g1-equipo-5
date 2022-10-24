package uiMain;

import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.CuentaAhorro;

import java.util.Scanner;

public class UIPrestamo extends UIMenu {
    public static void prestamo(Cliente cliente){
        int opcion;
        System.out.println("Ingresa el ID de la cuenta que deseas aplicar el prestamo");
        UIMenu.traercuentas();
        opcion = sc.nextInt();
        System.out.println("Puedes solicitar un prestamo entre 500.000 y 7'000.000 a 24 cuotas\n Ingresa el valor a solicitar");
        int valor=sc.nextInt();
        System.out.println("Elige el tipo de prestamo (universitario,hobbie,libre)");
        String tipoPrestamo =sc.next();
        cliente.solicitarPrestamo(valor,tipoPrestamo,opcion);
        System.out.println(((CuentaAhorro)cliente.listaCuentas.get(opcion)).getPrestamo());

    }
}
