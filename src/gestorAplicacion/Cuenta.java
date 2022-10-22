package gestorAplicacion;

import java.util.ArrayList;

public abstract class Cuenta {

    protected static int numero = 10000000;
    protected int saldoTotal;
    protected int SaldoDisponible;
    protected Cliente titular;
    protected Prestamo prestamo;
    protected ArrayList<Bolsillo> misBolsillos = new ArrayList<>();
    protected int deuda;
    protected boolean multa;
    protected boolean estado;
    
    public Cuenta(Cliente titular) {
        this.titular = titular;
        this.estado = true;
        Cuenta.numero++;

    }


    public abstract void aumentarSaldo(int cantidad);

    public abstract void disminuirSaldo(int cantidad);

    public abstract void  solicitarPrestamo(int valorPrestamo, String tipoPrestamo);

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

    public boolean isMulta() {
        return multa;
    }

    public void setMulta(boolean multa) {
        this.multa = multa;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    public ArrayList<Bolsillo> getAhorro() {
        return misBolsillos;
    }

    public void setAhorro(ArrayList<Bolsillo> ahorro) {
        this.misBolsillos = ahorro;
    }

}
