package gestorAplicacion.usuario;

import gestorAplicacion.transacciones.Multa;
import gestorAplicacion.transacciones.Pago;
import gestorAplicacion.transacciones.Prestamo;

import java.util.ArrayList;

public class CuentaAhorro extends Cuenta{
    private int deuda;
    public  ArrayList<Multa> multas = new ArrayList<>();
    public  ArrayList<Prestamo> prestamos = new ArrayList<>();

    public CuentaAhorro(Cliente titular,int saldo) {
        super(titular,saldo,"Ahorro");
    }

    @Override
    public String toString() {
        if (isEstado()){
            return "Cuenta (Ahorro) -> ID = "+getId()+ ":" + "\n"+
                    "Saldo total=" + saldoTotal +
                    ", Saldo disponible=" + saldoDisponible +
                    ", Numero="+numero+
                    ", Dueda=" + deuda +
                    ", Estado=Activo";
        } else {
            return "Cuenta (Ahorro) -> ID = "+getId()+ ":" + "\n"+
                    "Saldo total=" + saldoTotal +
                    ", Saldo disponible=" + saldoDisponible +
                    ", Numero="+numero+
                    ", Dueda=" + deuda +
                    ", Estado=Inactivo";
        }
    }
    @Override
    public void aumentarSaldo(int cantidad) {
        if (isEstado()){
            setSaldoTotal(getSaldoTotal() + cantidad);
        }
    }

    @Override
    public void disminuirSaldo(int cantidad) {
        if (isEstado() && (getSaldoDisponible() >= cantidad)){
            setSaldoTotal(getSaldoTotal() - cantidad);
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


    public ArrayList<Multa> getMultas() {return multas;}

    public void setMultas(ArrayList<Multa> multas) {this.multas = multas;}

    public ArrayList<Prestamo> getPrestamos() {return prestamos;}

    public void setPrestamos(ArrayList<Prestamo> prestamos) {this.prestamos = prestamos;}

}
