package uiMain;
import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.Cuenta;
import gestorAplicacion.usuario.CuentaAhorro;


public class UIMovimiento extends UIMenu  {
    public static void movimiento(Cliente cliente){
            System.out.println(
                    """
                            Elija el tipo de transaccion:
                            1. Ver movimientos activos
                            2. Ver transacciones realizadas
                            3. Ver Pagos realizados
                            """);
            int tipoTransaccion= sc.nextInt();
            switch (tipoTransaccion) {
                case (1) -> {
                    System.out.println(
                            """
                                    Elija una cuenta:
                                     """);
                    UIMenu.traercuentas();
                    int id= sc.nextInt();
                    System.out.println("Estos son tus movimientos Activos");
                    UIMenu.traerPrestamos(id);
                    UIMenu.traerMultas(id);
                    UIMenu.traerBolsillos(id);

                }
                case (2) -> {
                    System.out.println("Transferencias Realizadas: ");
                    cliente.movimiento.consultarTransferencias();
                }
                case (3) -> {
                    System.out.println("Pagos realizados: ");
                    cliente.movimiento.consultarPagos();
                }
            }
    }
}


