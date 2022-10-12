package gestorAplicacion;

public class Cuenta {
    private int numero;
    private String tipo;
    private int saldo;
    private int deuda; //esta debe de ser de tipo prestamo
    private boolean estado;

    public Cuenta(int numero, String tipo, int deuda, boolean estado) {
        this.numero = numero;
        this.tipo = tipo;
        this.deuda = deuda;
        this.estado = estado;
    }

    public void aumentarSaldo(int cantidad){
        if (this.estado){
            this.saldo += cantidad;
        }
    }

    public void disminuirSaldo(int cantidad){
        if (this.estado && cantidad < this.saldo){
            this.saldo -= cantidad;
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
        this.deuda = deuda;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
