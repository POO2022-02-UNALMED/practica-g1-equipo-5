package gestorAplicacion;
import java.util.ArrayList;
public class Bolsillo {
    public enum Categoria {
        VIAJES, EDUCACION, SALUD, ALIMENTACION, TRANSPORTE, HOGAR, IMPREVISTOS, OTROS;
    }

    private int cargarBolsillo;
    private Cuenta cuenta;
    private Categoria categoria;
    private final int metaAhorro;
    private int saldoDisponible;


    public Bolsillo(int metaAhorro, Cuenta cuenta, int opcion) {
        this.cuenta = cuenta;
        this.categoria = Categoria.values()[opcion];
        this.metaAhorro=metaAhorro;
    }
    public void cargarBolsillo() {
        saldoDisponible = cuenta.getSaldoTotal() - metaAhorro;
        cuenta.setSaldoDisponible(saldoDisponible);
    }
    public void cargarBolsillo(int valor) {
        saldoDisponible = cuenta.getSaldoTotal() - valor;
        this.cargarBolsillo+=valor;
        cuenta.setSaldoDisponible(saldoDisponible);
        cuenta.misBolsillos.set(cuenta.misBolsillos.indexOf(this),this);
    }
    public void descargarBolsillo() {
        cuenta.saldoTotal = cuenta.getSaldoDisponible() + metaAhorro;
    }
    public void descargarBolsillo(int valor) {
        cuenta.saldoTotal = cuenta.getSaldoDisponible() + valor;
        this.cargarBolsillo+=valor;
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

    @Override
    public String toString() {
        return "Bolsillo{" +
                "Monto cargado =" + cargarBolsillo +
                ", Número de cuenta =" + cuenta.getNumero() +
                ", Categoria=" + categoria +
                ", Meta de Ahorro=" + metaAhorro +
                '}';
    }
}


