package gestorAplicacion;

public class CuentaCorriente extends Cuenta{

    public CuentaCorriente(String tipo, Cliente titular) {
        super(tipo, titular);
    }

    @Override
    public void aumentarSaldo(int cantidad) {
        if (isEstado()){
            setSaldo(getSaldo() + cantidad);
        }
    }

    @Override
    public void disminuirSaldo(int cantidad) {
        if (isEstado() && (getSaldo() > cantidad)){
            setSaldo(getSaldo() - cantidad);
        }
    }
}
