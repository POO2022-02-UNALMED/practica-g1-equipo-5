package gestorAplicacion;
import java.util.ArrayList;

public abstract class Cuenta {
    private  static int numero = 10000000;
    private String tipo;
    private int saldoTotal;
    private int saldoDisponible;
    protected ArrayList<Bolsillo> misBolsillos = new ArrayList<>();
    private Cliente titular;
    private Prestamo prestamo;
    private int deuda;
    private boolean multa;
    private boolean estado;

    public Cuenta(String tipo, Cliente titular) {
        this.tipo = tipo;
        this.titular = titular;
        this.estado = true;
        Cuenta.numero++;
        if (getMisBolsillos().isEmpty()){
            this.saldoDisponible = this.saldoTotal;
        }
    }

    public abstract void aumentarSaldo(int cantidad);

    public abstract void disminuirSaldo(int cantidad);

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        Cuenta.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        saldoDisponible = saldoDisponible;
    }

    public ArrayList<Bolsillo> getMisBolsillos() {
        return misBolsillos;
    }

    public void setMisBolsillos(ArrayList<Bolsillo> misBolsillos) {
        this.misBolsillos = misBolsillos;
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

}
