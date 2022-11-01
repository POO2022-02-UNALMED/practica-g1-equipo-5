package uiMain;

import gestorAplicacion.usuario.Cliente;



public class UIMovimiento extends UIMenu  {
    public static void movimiento(Cliente cliente){
            System.out.println(
                    """
                            Elija el tipo de transaccion:
                            1. Ver todas tus transacciones disponibles
                            2. Ver transferencias realizadas
                            3. Ver Pagos realizados""");
            int tipoTransaccion= sc.nextInt();
            switch (tipoTransaccion) {
                case (1) -> {
                    System.out.println(
                            """
                                    Elija una cuenta:
                                     """);
                    UIMenu.traercuentasAhorro();
                    int id= sc.nextInt();
                    if (id>=0 && id <= cliente.listaCuentas.size()) {
                        System.out.println(" Estas son tus transacciones disponibles");
                        UIMenu.traerPrestamos(id);
                        UIMenu.traerMultas(id);
                        UIMenu.traerBolsillos(id);
                    }

                }
                case (2) -> {
                    System.out.println("Transferencias Realizadas:\n" );
                    System.out.println(cliente.movimientoTransferencia());
                }
                case (3) -> {
                    System.out.println("Pagos realizados: ");
                    System.out.println(cliente.movimientoPago());
                }
            }
    }
}


