package gestorAplicacion;

public class CuentaAhorro extends Cuenta{

    public CuentaAhorro(String tipo, Cliente titular) {
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
