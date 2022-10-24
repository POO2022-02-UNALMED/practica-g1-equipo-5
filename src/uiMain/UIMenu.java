package uiMain;

import baseDatos.*;
import java.util.Scanner;
import gestorAplicacion.transacciones.*;
import gestorAplicacion.usuario.*;


public class UIMenu {
    public static Cliente cliente= new Cliente("Jaimico",20192121,0);
    public static Scanner sc = new Scanner(System.in);
    public static void main(String [] args){
        int opcion;

        do{
            System.out.println("Bienvenido a PiggyBank\n Elija una opción:");
            System.out.println(
                    """
                            1. Solicitar Prestamo
                            2. Realizar Pagos
                            3. Bolsillos
                            4. Transferencias
                            5. Movimientos
                            6. Salir""");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    UIPrestamo.prestamo(cliente);
                    break;
                case 2:
                    UIPago.Pagar(cliente);
                    break;
                case 3:
                    UIBolsillos.bolsillo(cliente);
                    break;
                case 4:

                    UITranferencia.transaccion(cliente);

                    break;
                case 5:
                    UIMovimiento.movimiento(cliente);
                    break;
                case 6:
                    System.out.println("Vuelva pronto");
                    Serializador.serializar(cliente);
                    System.exit(0);
                default:
                    System.out.println("Por favor ingrese una opción valida");
            }

        }while(opcion != 7);

    }
    public static void traercuentas(){
        for (Cuenta i: Cliente.listaCuentas) {
            System.out.println(i.toString());
        }
    }
    public static void traerBolsillos(int idCuenta){

        Cuenta cuentas = Cliente.buscarCuenta(idCuenta);

        for (Bolsillo bolsillo: cuentas.misBolsillos) {
            System.out.println(bolsillo.toString());
        }
    }
    public static void traerMultas(int idCuenta){

        CuentaAhorro cuentas = (CuentaAhorro) Cliente.buscarCuenta(idCuenta);

        for (Multa multa:  cuentas.getMultas()) {
            if (multa.isEstado()) {
                System.out.println(multa);
            }
        }
    }
    public static Prestamo traerPrestamos(int idCuenta){

        CuentaAhorro cuentas = (CuentaAhorro) Cliente.buscarCuenta(idCuenta);

        for (Prestamo prestamo:  cuentas.getPrestamos()) {
            if (prestamo.isEstado()) {
                return prestamo;
            }
        }
    }
}
