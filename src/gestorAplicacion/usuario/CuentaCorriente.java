package gestorAplicacion.usuario;

import gestorAplicacion.transacciones.Prestamo;

public class CuentaCorriente extends Cuenta{

    public CuentaCorriente(Cliente titular) {
        super(titular);
    }

    @Override
    public String toString() {
        return "Cuenta "+getId()+"\n"+
                "saldoTotal=" + saldoTotal +
                ", SaldoDisponible=" + SaldoDisponible +
                ", titular=" + titular +
                ", estado=" + estado +
                '}';
    }
}
