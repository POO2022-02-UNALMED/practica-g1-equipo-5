package uiMain;

import baseDatos.*;
import java.util.Scanner;
import gestorAplicacion.transacciones.*;
import gestorAplicacion.usuario.*;


public class UIMenu {

    public static Cliente cliente= new Cliente("Jaimico",20192121,0);
    public static Scanner sc = new Scanner(System.in);
    public static void main(String [] args){
        crearObjetos();

        int opcion;

        do {
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

            switch (opcion) {
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

        } while (opcion != 7);

    }

    public static void traercuentas(){
        for (Cuenta i: Cliente.listaCuentas) {
            System.out.println(i);
        }
    }

    public static void traerBolsillos(int idCuenta) {

        Cuenta cuentas = Cliente.buscarCuenta(idCuenta);

        for (Bolsillo bolsillo : cuentas.misBolsillos) {
            System.out.println(bolsillo.toString());
        }
    }

    public static void traerMultas(int idCuenta) {

        CuentaAhorro cuentas = (CuentaAhorro) Cliente.buscarCuenta(idCuenta);

        for (Multa multa : cuentas.getMultas()) {
            if (multa.isEstado()) {
                System.out.println(multa);
            }
        }
    }

    public static Prestamo traerPrestamos(int idCuenta) {

        CuentaAhorro cuentas = (CuentaAhorro) Cliente.buscarCuenta(idCuenta);

        for (Prestamo prestamo : cuentas.getPrestamos()) {
            if (prestamo.isEstado()) {
                return prestamo;
            }
        }return null;
    }
    public static void crearObjetos(){
        CuentaAhorro c3 = new CuentaAhorro(cliente,2000000);
        Cuenta c4 = new CuentaCorriente(cliente,654345621);
        Multa m1 = new Multa(500000,c3,"2022-12-10");
        Multa m2 = new Multa(30000,c3,"2022-12-07");
        Multa m3 = new Multa(c3);

        //universitario hobbie libre
        Prestamo p1 = new Prestamo(700000,(CuentaAhorro) c3,"universitario","2022-01-07");
        Prestamo p2 = new Prestamo(900000,(CuentaAhorro) c3,"libre","2022-06-18");
        Prestamo p3 = new Prestamo(40000000,(CuentaAhorro) c3,"hobbie","2022-05-01");

        c3.getMultas().add(m1);
        c3.getMultas().add(m2);
        c3.getMultas().add(m3);

        c3.getPrestamos().add(p1);
        c3.getPrestamos().add(p2);
        c3.getPrestamos().add(p3);

        Cliente.getListaCuentas().add(c3);
        Cliente.getListaCuentas().add(c4);
    }
}
