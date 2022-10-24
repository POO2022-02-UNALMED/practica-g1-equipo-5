package gestorAplicacion.usuario;

public class CuentaCorriente extends Cuenta{

    public CuentaCorriente(Cliente titular,int saldo) {
        super(titular);
    }
    public CuentaCorriente(Cliente titular,int saldo) {
        super(titular,saldo);
    }

    @Override
    public String toString() {
        return "Cuenta "+getId() + ":" + "\n"+
                "saldoTotal=" + saldoTotal +
                ", SaldoDisponible=" + saldoDisponible +
                ", titular=" + titular +
                ", estado=" + estado;
    }

    @Override
    public void aumentarSaldo(int cantidad) {
        if (isEstado()){
            setSaldoTotal(getSaldoTotal() + cantidad);
        }
    }

    @Override
    public void disminuirSaldo(int cantidad) {
        if (isEstado() && (getSaldoDisponible() > cantidad)){
            setSaldoDisponible(getSaldoDisponible() - cantidad);
        }
    }

}
