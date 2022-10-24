package gestorAplicacion.usuario;

import gestorAplicacion.transacciones.Multa;
import gestorAplicacion.transacciones.Prestamo;

import java.util.ArrayList;

public class CuentaAhorro extends Cuenta{
    private int deuda;
    public static ArrayList<Multa> multas = new ArrayList<>();
    public static ArrayList<Prestamo> prestamos = new ArrayList<>();


    public CuentaAhorro(Cliente titular) {
        super(titular);
    }

    @Override
    public String toString() {
        return "Cuenta "+getId()+"\n"+
                "saldoTotal=" + saldoTotal +
                ", SaldoDisponible=" + SaldoDisponible +
                ", titular=" + titular +
                ", numero="+numero+
                ", prestamo=" +  prestamos +
                ", deuda=" + deuda +
                ", multa=" + multas +
                ", estado=" + estado +
                '}';
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

    public boolean tieneMultta() {
        return multas != null;

    }

    public boolean tienePrestamo() {
        return prestamos != null;
    }

    public int getDeuda() {
        return deuda;
    }

    public void setDeuda(int deuda) {
        this.deuda = deuda;
    }

    public static ArrayList<Multa> getMultas() {
        return multas;
    }

    public static void setMultas(ArrayList<Multa> multas) {
        CuentaAhorro.multas = multas;
    }

    public static ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public static void setPrestamos(ArrayList<Prestamo> prestamos) {
        CuentaAhorro.prestamos = prestamos;
    }
}
