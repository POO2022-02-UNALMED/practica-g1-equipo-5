package gestorAplicacion;

public class CuentaCorriente extends Cuenta{

    public CuentaCorriente(Cliente titular) {
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

    @Override
    public void solicitarPrestamo(int valorPrestamo, String tipoPrestamo) {
        prestamo = new Prestamo(valorPrestamo, this, tipoPrestamo);
    }

    @Override
    public boolean tieneMultta() {
        return multa != null;
    }

    @Override
    public boolean tienePrestamo() {
        return prestamo != null;
    }


}
