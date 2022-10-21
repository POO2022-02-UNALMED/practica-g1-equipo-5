package gestorAplicacion;
import java.util.ArrayList;
public class Bolsillo {
    public enum Categoria {
        VIAJES, EDUCACION, SALUD, ALIMENTACION, TRANSPORTE, HOGAR, IMPREVISTOS, OTROS;
    }

    private int valor;
    private Cuenta cuenta;
    private Categoria categoria;
    private int saldoDisponible;
    private ArrayList<Bolsillo> ahorro = new ArrayList<>();

    public Bolsillo(int valor, Cuenta cuenta, String categoria) {
        this.valor = valor;
        this.cuenta = cuenta;
        this.categoria = Categoria.valueOf(categoria);
    }

    public void crearBolsillo() {
        ahorro.add(this);
    }

    public void cargarBolsillo() {
        saldoDisponible = cuenta.getSaldoTotal() - valor;
        cuenta.setSaldoDisponible(saldoDisponible);
    }

    public void descargarBolsillo() {
        saldoDisponible = cuenta.getSaldoTotal() + valor;
        //Agregar set y get de saldoDisponible en clase Cuenta
        cuenta.setSaldoDisponible(saldoDisponible);
    }

    public void eliminarBolsillo() {
        //Agregar atributo de tipo bolsillo en cuenta
        this.cuenta = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
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
}


