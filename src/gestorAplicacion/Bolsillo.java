package gestorAplicacion;
import java.util.ArrayList;
public class Bolsillo {
    public enum Categoria{
        VIAJE, ESTUDIO, VESTUARIO, VEHICULO, OTRO
    }
    private int valor;
    private Cuenta cuenta;
    private String categoria;
    private int saldoDisponible;
    private ArrayList<Bolsillo> ahorro = new ArrayList<>();


    public Bolsillo(int valor, Cuenta cuenta,String categoria){
        this.valor = valor;
        this.cuenta = cuenta;
        this.categoria = Categoria.valueOf(categoria).toString();
    }

    public void crearBolsillo(){
        ahorro.add(this);
    }
    public void cargarBolsillo(){
        saldoDisponible = cuenta.getSaldo()-valor;
        //Agregar set y get de saldoDisponible en clase Cuenta
        cuenta.setSaldo(saldoDisponible);
    }

    public void descargarBolsillo(){
        saldoDisponible = cuenta.getSaldo()+valor;
        //Agregar set y get de saldoDisponible en clase Cuenta
        cuenta.setSaldo(saldoDisponible);
    }

    public void eliminarBolsillo(){
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
