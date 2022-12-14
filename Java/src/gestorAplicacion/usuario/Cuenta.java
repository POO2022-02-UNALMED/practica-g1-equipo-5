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
    protected int saldoDisponible;
    protected Cliente titular;
    public ArrayList<Bolsillo> misBolsillos = new ArrayList<>();
    protected boolean estado;
    protected String tipoCuenta;

    public Cuenta(Cliente titular,int saldo,String tipoCuenta) {
        this.titular = titular;
        this.estado = true;
        this.numero = ((int)((Math.random() * ((100000 - 1000) + 1))) + 1000);
        this.saldoTotal=saldo;
        this.saldoDisponible=saldo;
        this.tipoCuenta=tipoCuenta;
        id = getId() + 1;
        if (misBolsillos.isEmpty()){
            this.saldoDisponible=saldoTotal;
        }
        else{
            this.saldoDisponible = saldoTotal-saldoEnBolsillos();
        }

    }

    public abstract String toString();

    public abstract void aumentarSaldo(int cantidad);

    public abstract void disminuirSaldo(int cantidad);


    public int saldoEnBolsillos(){
        int valorEnBolsilos = 0;
        for (Bolsillo bolsillo: misBolsillos) {
            valorEnBolsilos += bolsillo.getValorCargaBolsillo();
        }return valorEnBolsilos;
    }


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
        return saldoDisponible;
    }

    public void setSaldoDisponible(int saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
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
