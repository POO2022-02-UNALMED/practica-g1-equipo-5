package uiMain;

import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.CuentaAhorro;

import java.util.Scanner;

public class UISolicitarPrestamo {
    public static void solicitarPrestamo(Cliente cliente){
        Scanner sc = new Scanner(System.in);
        System.out.println("Puedes solicitar un prestamo entre 500.000 y 7'000.000 a 24 cuotas\n Ingresa el valor a solicitar");
        int valor=sc.nextInt();
        System.out.println("Elige el tipo de prestamo (universitario,hobbie,libre)");
        String tipoPrestamo =sc.next();
        ((CuentaAhorro)cliente.cuenta).solicitarPrestamo(valor,tipoPrestamo);
        System.out.println(((CuentaAhorro) cliente.cuenta).getPrestamo().toString());
    }
}
