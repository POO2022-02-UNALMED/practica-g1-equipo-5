package uiMain;
import gestorAplicacion.usuario.Cliente;
import gestorAplicacion.usuario.Cuenta;
import gestorAplicacion.usuario.CuentaAhorro;


public class UIMovimiento extends UIMenu  {
    public static void movimiento(Cliente cliente){
            System.out.println(
                    """
                            Elija el tipo de transaccion:
                            1. ver movimientos
                            2. Ver transacciones
                            3. Ver Pagos
                            """);
            int tipoTransaccion= sc.nextInt();
            switch (tipoTransaccion) {
                case (1) -> {

                }
                case (2) -> {
                    cliente.movimiento.consultarTransferencias();
                }
                case (3) -> {
                }
            }
    }
}


