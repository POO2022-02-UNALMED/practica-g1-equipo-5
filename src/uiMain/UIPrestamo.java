package uiMain;

import gestorAplicacion.transacciones.Prestamo;
import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.CuentaAhorro;
import gestorAplicacion.usuario.CuentaCorriente;

import java.util.ArrayList;
import java.util.Scanner;

public class UIPrestamo extends UIMenu {
    public static void prestamo(Cliente cliente) {
        int opcion;
        System.out.println("Ingresa el ID de la cuenta que deseas aplicar el prestamo");
        UIMenu.traercuentas();
        opcion = sc.nextInt();
        if (opcion>=0 && opcion < Cliente.listaCuentas.size()) {
            if (Cliente.buscarCuenta(opcion) instanceof CuentaCorriente) {
                System.out.println("Los prestamos solo pueden ser realzados por una cuenta de Ahorro");
                return;
            }

            System.out.println("Puedes solicitar un prestamo entre 500.000 y 7'000.000 a 24 cuotas\n Ingresa el valor a solicitar");
            int valor = sc.nextInt();
            if (valor < 500000 || valor > 7000000) {

                System.out.println("Valor erroneo");
                return;
            }
            System.out.println("Elige el tipo de prestamo (universitario,hobbie,libre)");
            String tipoPrestamo = sc.next();

            if (!tipoPrestamo.equals("universitario") && !tipoPrestamo.equals("hobbie") && !tipoPrestamo.equals("libre")) {

                System.out.println("Valor erroneo");
                return;
            }

            cliente.solicitarPrestamo(valor, tipoPrestamo, opcion);
            ArrayList<Prestamo> prestamos = ((CuentaAhorro) cliente.listaCuentas.get(opcion)).getPrestamos();
            System.out.println((prestamos.get(prestamos.size() - 1)).mensajePrestamo()); //para obtener el iltimo item de prestamos es decir este prestamo

        }
    }
}
