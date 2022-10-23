package gestorAplicacion.usuario;

import gestorAplicacion.transacciones.Multa;
import gestorAplicacion.transacciones.Prestamo;

public class CuentaAhorro extends Cuenta{
    private int deuda;
    private Multa multa;
    private Prestamo prestamo;


    public CuentaAhorro(Cliente titular) {
        super(titular);
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "saldoTotal=" + saldoTotal +
                ", SaldoDisponible=" + SaldoDisponible +
                ", titular=" + titular +
                ", prestamo=" + prestamo +
                ", deuda=" + deuda +
                ", multa=" + multa +
                ", estado=" + estado +
                ", id= "+getId()+
                '}';
    }

    public void solicitarPrestamo(int valorPrestamo, String tipoPrestamo) {
        prestamo = new Prestamo(valorPrestamo, this, tipoPrestamo);
    }

    public boolean tieneMultta() {
        return multa != null;

    }

    public boolean tienePrestamo() {
        return prestamo != null;
    }


    public int getDeuda() {
        return deuda;
    }

    public void setDeuda(int deuda) {
        this.deuda = deuda;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
}
