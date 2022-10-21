package gestorAplicacion;
import java.util.ArrayList;
public class Bolsillo {
    public enum Categoria {
        VIAJES, EDUCACION, SALUD, ALIMENTACION, TRANSPORTE, HOGAR, IMPREVISTOS, OTROS;
    }

    private int valorCarga;
    private Cuenta cuenta;
    private Categoria categoria;
    private final int metaAhorro;
    private int saldoDisponible;


    public Bolsillo(int metaAhorro, Cuenta cuenta, String categoria) {
        this.cuenta = cuenta;
        this.categoria = Categoria.valueOf(categoria);
        this.metaAhorro=metaAhorro;
    }
    
    public void cargarBolsillo(int valor) {
        saldoDisponible = cuenta.getSaldoTotal() - valor;
        this.valorCarga+=valor;
        cuenta.setSaldoDisponible(saldoDisponible);
        cuenta.misBolsillos.set(cuenta.misBolsillos.indexOf(this),this);
    }

    public void descargarBolsillo(int valor) {
        saldoDisponible = cuenta.getSaldoTotal() + valor;
        //Agregar set y get de saldoDisponible en clase Cuenta
        cuenta.setSaldoDisponible(saldoDisponible);
    }

    public void eliminarBolsillo() {
        //Agregar atributo de tipo bolsillo en cuenta
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
                "valorCarga=" + valorCarga +
                ", cuenta=" + cuenta.getNumero() +
                ", categoria=" + categoria +
                ", metaAhorro=" + metaAhorro +
                '}';
    }
}


