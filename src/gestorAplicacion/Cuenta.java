package gestorAplicacion;

public class Cuenta {
    private int numero;
    private String tipo;
    private int saldo;
    private Prestamo deuda;
    private boolean estado;
    private Tarjeta tarjeta;

    public Cuenta(int numero, String tipo, Prestamo deuda, boolean estado, Tarjeta tarjeta) {
        this.numero = numero;
        this.tipo = tipo;
        this.deuda = deuda;
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

    public Prestamo getDeuda() {
        return deuda;
    }

    public void setDeuda(Prestamo deuda) {
        this.deuda = deuda;
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
