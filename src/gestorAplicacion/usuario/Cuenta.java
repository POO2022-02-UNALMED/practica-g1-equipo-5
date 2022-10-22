package gestorAplicacion.usuario;

import gestorAplicacion.transacciones.Bolsillo;
import gestorAplicacion.transacciones.Multa;
import gestorAplicacion.transacciones.Prestamo;

import java.util.ArrayList;

public abstract class Cuenta {

    protected static int numero = 10000000;
    protected int saldoTotal;
    protected int SaldoDisponible;
    protected Cliente titular;
    protected Prestamo prestamo;
    public ArrayList<Bolsillo> misBolsillos = new ArrayList<>();
    protected int deuda;
    protected Multa multa;
    protected boolean estado;
    
    public Cuenta(Cliente titular) {
        this.titular = titular;
        this.estado = true;
        Cuenta.numero++;

    }

    public abstract void aumentarSaldo(int cantidad);

    public abstract void disminuirSaldo(int cantidad);

    public abstract void  solicitarPrestamo(int valorPrestamo, String tipoPrestamo);

    public abstract boolean tieneMultta();

    public abstract boolean tienePrestamo();

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        Cuenta.numero = numero;
    }

    public int getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(int saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public int getSaldoDisponible() {
        return SaldoDisponible;
    }

    public void setSaldoDisponible(int saldoDisponible) {
        SaldoDisponible = saldoDisponible;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public int getDeuda() {
        return deuda;
    }

    public void setDeuda(int deuda) {
        this.deuda = deuda;
    }

    public ArrayList<Bolsillo> getMisBolsillos() {
        return misBolsillos;
    }

    public void setMisBolsillos(ArrayList<Bolsillo> misBolsillos) {
        this.misBolsillos = misBolsillos;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }



    public void setAhorro(ArrayList<Bolsillo> ahorro) {
        this.misBolsillos = ahorro;
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
                '}';
    }
}
