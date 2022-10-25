package gestorAplicacion.transacciones;

import gestorAplicacion.usuario.Cuenta;

import java.io.Serializable;

public class Bolsillo implements Serializable {
    public enum Categoria {
        VIAJES, EDUCACION, SALUD, ALIMENTACION, TRANSPORTE, HOGAR, IMPREVISTOS, OTROS;
    }
    public int id;
    private int cargarBolsillo;
    private Cuenta cuenta;
    private Categoria categoria;
    private final int metaAhorro;


    public Bolsillo(int metaAhorro, Cuenta cuenta, int opcion) {
        this.cuenta = cuenta;
        this.categoria = Categoria.values()[opcion];
        this.metaAhorro=metaAhorro;

    }

    public static Bolsillo crearBolsillo(int metaAhorro, Cuenta cuenta, int opcion) {
        return new Bolsillo(metaAhorro, cuenta, opcion);
    }



    public String cargarBolsillo() {
        saldoDisponible = cuenta.getSaldoTotal() - metaAhorro;
        this.cargarBolsillo=metaAhorro;
        cuenta.setSaldoDisponible(saldoDisponible);
        cuenta.misBolsillos.set(cuenta.misBolsillos.indexOf(this),this);
        return "Lograste la meta";
    }
    public void cargarBolsillo(int valor) {
        saldoDisponible = cuenta.getSaldoTotal() - valor;
        this.cargarBolsillo+=valor;
        cuenta.setSaldoDisponible(saldoDisponible);
        cuenta.misBolsillos.set(cuenta.misBolsillos.indexOf(this),this);
    }
    public void descargarBolsillo() {
        saldoDisponible= cuenta.getSaldoDisponible() + metaAhorro;
        this.cargarBolsillo-=metaAhorro;
        cuenta.setSaldoTotal(saldoDisponible);
        cuenta.misBolsillos.set(cuenta.misBolsillos.indexOf(this),this);
    }
    public void descargarBolsillo(int valor) {
        saldoDisponible= cuenta.getSaldoDisponible() + metaAhorro;
        this.cargarBolsillo-=valor;
        cuenta.setSaldoTotal(saldoDisponible);
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

    @Override
    public String toString() {
        return "Bolsillo{" +
                "Monto cargado =" + cargarBolsillo +
                ", Número de cuenta =" + cuenta.getNumero() +
                ", Categoria=" + categoria +
                ", Meta de Ahorro=" + metaAhorro +
                ", ID = "+this.getId()+
                '}';
    }
}


