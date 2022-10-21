package gestorAplicacion;

public class CuentaCorriente extends Cuenta{

    public CuentaCorriente(String tipo, Cliente titular) {
        super(titular);
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
