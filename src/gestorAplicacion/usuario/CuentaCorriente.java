package gestorAplicacion.usuario;

import gestorAplicacion.transacciones.Prestamo;

public class CuentaCorriente extends Cuenta{

    public CuentaCorriente(Cliente titular,int saldo) {
        super(titular);
    }

    @Override
    public String toString() {
        return "Cuenta "+getId()+"\n"+
                "saldoTotal=" + saldoTotal +
                ", SaldoDisponible=" + saldoDisponible +
                ", titular=" + titular +
                ", estado=" + estado +
                '}';
    }
}
