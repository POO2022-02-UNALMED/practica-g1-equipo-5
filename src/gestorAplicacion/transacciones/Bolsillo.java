package gestorAplicacion.transacciones;

import gestorAplicacion.usuario.Cuenta;

import java.io.Serializable;

public class Bolsillo implements Serializable {
    public enum Categoria {
        VIAJES, EDUCACION, SALUD, ALIMENTACION, TRANSPORTE, HOGAR, IMPREVISTOS, OTROS;
    }
    public int id;
    private int valorCargaBolsillo;
    private Cuenta cuenta;
    private Categoria categoria;
    private final int metaAhorro;
    private int saldoDisponible;

    public Bolsillo(int metaAhorro, Cuenta cuenta, int opcion) {
        this.cuenta = cuenta;
        this.categoria = Categoria.values()[opcion];
        this.metaAhorro=metaAhorro;
    }
    public static Bolsillo crearBolsillo(int metaAhorro, Cuenta cuenta, int opcion) {
        cuenta.setSaldoDisponible(cuenta.getSaldoTotal());
        return new Bolsillo(metaAhorro, cuenta, opcion);
    }

    public String cargarBolsillo() {
        if(cuenta.getSaldoDisponible()<metaAhorro){
            return "No tienes saldo suficiente en la cuenta para cargar el bolsillo";
        }
        this.valorCargaBolsillo = metaAhorro;
        cuenta.setSaldoDisponible(cuenta.getSaldoTotal()-cuenta.saldoEnBolsillos());
        cuenta.misBolsillos.set(cuenta.misBolsillos.indexOf(this),this);
        return "Felicitaciones, alcanzaste tu meta de ahorro";
    }
    public String cargarBolsillo(int valor) {
        if(cuenta.getSaldoDisponible()<valor){
            return "No tienes saldo suficiente en la cuenta para cargar el bolsillo";
        }
        this.valorCargaBolsillo +=valor;
        cuenta.setSaldoDisponible(cuenta.getSaldoTotal()-cuenta.saldoEnBolsillos());
        cuenta.misBolsillos.set(cuenta.misBolsillos.indexOf(this),this);
        return "El bolsillo fue cargado con "+getValorCargaBolsillo();
    }
    public void descargarBolsillo() {
        this.valorCargaBolsillo -=metaAhorro;
        cuenta.setSaldoTotal(cuenta.getSaldoDisponible()+cuenta.saldoEnBolsillos());
        cuenta.misBolsillos.set(cuenta.misBolsillos.indexOf(this),this);
    }
    public void descargarBolsillo(int valor) {
        this.valorCargaBolsillo -=valor;
        cuenta.setSaldoTotal(cuenta.getSaldoDisponible()-cuenta.saldoEnBolsillos());
        cuenta.misBolsillos.set(cuenta.misBolsillos.indexOf(this),this);
    }

    public void eliminarBolsillo() {
        this.cuenta = null;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return cuenta.getMisBolsillos().indexOf(this);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValorCargaBolsillo() {
        return valorCargaBolsillo;
    }

    public void setValorCargaBolsillo(int valorCargaBolsillo) {
        this.valorCargaBolsillo = valorCargaBolsillo;
    }

    @Override
    public String toString() {
        return "Has iniciado un nuevo ahorro: " +
                " Se asoció a la cuenta = " + cuenta.getNumero() +
                " número de bolsillo = "+this.getId()+
                ", estableciste una meta de ahorro de = " + metaAhorro +
                ", para ser usado en = " + categoria +
                " hasta el momento has ahorrado = " + valorCargaBolsillo +
                '}';
    }
}


