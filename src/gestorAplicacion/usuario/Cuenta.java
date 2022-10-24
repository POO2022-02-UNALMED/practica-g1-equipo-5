package gestorAplicacion.usuario;

import gestorAplicacion.transacciones.Bolsillo;
import gestorAplicacion.transacciones.Multa;
import gestorAplicacion.transacciones.Prestamo;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Cuenta implements Serializable {

    protected static int id = 1000;
    protected int numero;
    protected int saldoTotal;
    protected int SaldoDisponible;
    protected Cliente titular;
    public ArrayList<Bolsillo> misBolsillos = new ArrayList<>();
    protected boolean estado;

    public Cuenta(Cliente titular) {
        this.titular = titular;
        this.estado = true;
        this.numero = ((int)((Math.random() * ((100000 - 1000) + 1))) + 1000);
        id = getId() + 1;

    }

    public abstract String toString();

    public abstract void aumentarSaldo(int cantidad);

    public abstract void disminuirSaldo(int cantidad);
    
    public double getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public ArrayList<Bolsillo> getMisBolsillos() {
        return misBolsillos;
    }

    public void setMisBolsillos(ArrayList<Bolsillo> misBolsillos) {
        this.misBolsillos = misBolsillos;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getId() {
        return Cliente.listaCuentas.indexOf(this);
    }
}
