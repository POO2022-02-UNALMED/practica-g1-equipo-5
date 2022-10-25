package uiMain;

import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.CuentaAhorro;

public class UIPago extends UIMenu{
    public static void Pagar(Cliente cliente){
        System.out.println(
                """
                        Seleccione el tipo de pago que desea realizar
                        1. Pagar prestamo
                        2. Pagar multa""");
        int opcionPagos=sc.nextInt();
        int opcion;
        System.out.println("Ingresa el ID de la cuenta que deseas aplicar el prestamo");
        UIMenu.traercuentas();
        opcion = sc.nextInt(); //variable que trae la cuenta
        switch (opcionPagos) {
            case (1) -> {
                if ((((CuentaAhorro) Cliente.buscarCuenta(opcion)).getPrestamos()).size() == 0) {
                    System.out.println("Usted no cuenta con prestamos actualmente");
                    return;
                }
                System.out.println("Prestamos Actualmente activos: ");
                traerPrestamos(opcion);
                System.out.println("elija el ID del prestamo que desea pagar");
                int numeroDePrestamo=sc.nextInt(); //id del prestamo
                System.out.println("""
                                    1. Pago parcial
                                    2. Pago completo""");

                int pago = sc.nextInt();

                switch (pago) {
                    case (1) -> {
                        System.out.println("cuantas cuotas desea pagar?");
                        int cuotas = sc.nextInt(); //numero de cuotas
                        System.out.println("Valor de la transaccion: ");

                        System.out.println((Cliente.buscarPrestamo(opcion,numeroDePrestamo)).getValorCuota()*cuotas );

                        System.out.println("""
                                            Desea realizar el pago?
                                            1. Si
                                            2.No""");
                        int caso = sc.nextInt();
                        if (caso == 1) {
                            //cuenta, prestamo, cuota
                            System.out.println(cliente.hacerPagoPrestamo(opcion,numeroDePrestamo,cuotas));
                        }
                    }
                    case (2) -> {
                        System.out.println("Valor de la transaccion: ");
                        System.out.println( Cliente.buscarPrestamo(opcion,numeroDePrestamo).getValorPrestamo()* (1+Cliente.buscarPrestamo(opcion,numeroDePrestamo).getInteres()));
                        System.out.println("""
                                            Desea realizar el pago?
                                            1. Si
                                            2.No""");
                        int caso = sc.nextInt();
                        if (caso == 1) {
                            // cuenta, prestamo
                            System.out.println(cliente.hacerPagoPrestamo(opcion,numeroDePrestamo));
                        }
                    }
                }
            }
            case (2) -> {
                if ((((CuentaAhorro) Cliente.buscarCuenta(opcion)).getMultas()).size() == 0) {
                    System.out.println("Usted no cuenta con multas actualmente");
                    return;
                }
                System.out.println("Multas Actualmente activos: ");
                traerMultas(opcion);

                System.out.println("Elija el ID de la multa que desea pagar");
                int numeroDeMulta=sc.nextInt(); //

                System.out.println("""
                                    1. Pago parcial
                                    2. Pago completo""");
                int pago = sc.nextInt();

                switch (pago) {
                    case (1) -> {

                        System.out.println("Ingrese el valor de la transaccion");
                        int valorM = sc.nextInt();
                        System.out.println(cliente.hacerPagoMulta(opcion,numeroDeMulta,valorM));
                    }
                    case (2) -> {
                        System.out.println("Valor de la transaccion: ");
                        System.out.println( Cliente.buscarMulta(opcion,numeroDeMulta).getMonto() );
                        System.out.println("""
                                            Desea realizar el pago?
                                            1. Si
                                            2.No""");

                        int caso = sc.nextInt();
                        if (caso == 1) {

                            String mensaje =cliente.hacerPagoMulta(opcion,numeroDeMulta);
                            System.out.println(mensaje);
                        }
                    }
                }
            }
        }
    }
}
