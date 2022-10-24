package uiMain;
import java.util.Scanner;
import gestorAplicacion.transacciones.Bolsillo;
import gestorAplicacion.transacciones.Multa;
import gestorAplicacion.transacciones.Prestamo;
import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.Cuenta;
public class UIPago {
    public static void Pagar(Cliente cliente){
        Scanner sc = new Scanner(System.in);
        System.out.println(
                """
                        Seleccione el tipo de pago que desea realizar
                        1. Pagar prestamo
                        2. Pagar multa""");
        int opcionPagos=sc.nextInt();
        //linea de seleccione su cuenta

        switch (opcionPagos) {
            case (1) -> {
                System.out.println("Prestamos Actualmente activos: ");
                //linea para llamar una funcion que retorne uno por uno los prestamos en una lista

                System.out.println("cual desea pagar?");
                int numeroDePrestamo=sc.nextInt();
                //linea que permite elegir el prestamo

                System.out.println("""
                                    1. Pago parcial
                                    2. Pago completo""");
                int pago = sc.nextInt();

                switch (pago) {
                    case (1) -> {
                        System.out.println("cuantas cuotas desea pagar?");
                        int cuotas = sc.nextInt();
                        System.out.println("Valor de la transaccion: ");
                        //linea que retorna o imprime el valor del costo del prestamo
                        System.out.println("""
                                            Desea realizar el pago?
                                            1. Si
                                            2.No""");
                        int caso = sc.nextInt();
                        if (caso == 1) {
                            //System.out.println(cliente.hacerPagoPrestamo(cuotas, numeroDePrestamo));
                        }
                    }
                    case (2) -> {
                        System.out.println("Valor de la transaccion: ");
                        //linea que retorna o imprime el valor del costo del prestamo
                        System.out.println("""
                                            Desea realizar el pago?
                                            1. Si
                                            2.No""");
                        int caso = sc.nextInt();
                        if (caso == 1) {
                            //System.out.println(cliente.hacerPagoPrestamo(numeroDePrestamo));
                        }
                    }
                }
            }
            case (2) -> {
                System.out.println("Multas Actualmente activos: ");
                //linea para llamar una funcion que retorne uno por uno las multas en una lista

                System.out.println("cual desea pagar?");
                int numeroDeMulta=sc.nextInt();
                //linea que permite elegir la multa

                System.out.println("""
                                    1. Pago parcial
                                    2. Pago completo""");
                int pago = sc.nextInt();

                switch (pago) {
                    case (1) -> {

                        System.out.println("Ingrese el valor de la transaccion");
                        int valorM = sc.nextInt();

                        //System.out.println(cliente.hacerPagoMulta(valorM, numeroDeMulta));
                    }
                    case (2) -> {
                        System.out.println("Valor de la transaccion: ");
                        //linea que retorna o imprime el valor del costo de la multa
                        System.out.println("""
                                            Desea realizar el pago?
                                            1. Si
                                            2.No""");

                        int caso = sc.nextInt();
                        if (caso == 1) {
                            //System.out.println(cliente.hacerPagoMulta(numeroDeMulta));
                        }
                    }
                }
            }
        }
    }
}
