package gestorAplicacion;

import java.util.ArrayList;

public class Cuenta {
    private int numero;
    private String tipo;
    private int saldo;
    ArrayList<Prestamo> prestamos= new ArrayList<>();
    private int deuda;
    private boolean estado;
    private Tarjeta tarjeta;

    public Cuenta(int numero, String tipo, boolean estado, Tarjeta tarjeta) {
        this.numero = numero;
        this.tipo = tipo;
        this.estado = estado;
        this.tarjeta = tarjeta;
    }

    public void aumentarSaldo(int cantidad){
        if (estado){
            saldo += cantidad;
        }
    }

    public void disminuirSaldo(int cantidad){
        if (estado && cantidad < saldo){
            saldo -= cantidad;
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Prestamo prestamos) {
        this.prestamos.add(prestamos);
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getDeuda() {
        return deuda;
    }

    public void setDeuda(int deuda) {
        this.deuda += deuda;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }


}
