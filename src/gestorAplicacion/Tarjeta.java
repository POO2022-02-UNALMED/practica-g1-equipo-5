package gestorAplicacion;

import java.util.Random;

public class Tarjeta {
    private String numero;
    private Cliente titular;
    private Cuenta cuenta;
    private int saldo=0;
    private String estado;
    private int cupo;

    Random random =new Random();

    public Tarjeta(Cliente cliente, Cuenta cuenta){

        this.titular=cliente;
        this.cuenta = cuenta;
        numero= String.valueOf(random.nextInt(10));
        this.cupo=(int) (cuenta.getSaldo()*0.60);
    }

    public void recargarSaldo(int valor){
        this.saldo=valor;
        cuenta.setSaldo(cuenta.getSaldo()-valor);

    }

    public void descargarSaldo(int valor){
        saldo-=valor;
        cuenta.setSaldo(cuenta.getSaldo()+valor);
    }

    public void bloquearTarjeta(){
        this.estado="bloqueado";
    }

    public void cupoPersonalizado(int cupo){
        this.cupo=cupo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}

