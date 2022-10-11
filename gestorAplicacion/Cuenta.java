package gestorAplicacion;

public class Cuenta {
    private int numero;
    private String tipo;
    private static int saldo;
    private int deuda; //esta debe de ser de tipo prestado
    private String estado;

    public Cuenta(int numero, String tipo, int deuda, String estado) {
        this.numero = numero;
        this.tipo = tipo;
        this.deuda = deuda;
        this.estado = estado;
    }

    public void aumentarSaldo(int cantidad){
        if (this.estado == "Activo" || this.estado == "activo"){
            Cuenta.saldo += cantidad;
        }
    }

    public void disminuirSaldo(int cantidad){
        if (this.estado == "Activo" || this.estado == "activo"){
            Cuenta.saldo -= cantidad;
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

    public static int getSaldo() {
        return saldo;
    }

    public static void setSaldo(int saldo) {
        Cuenta.saldo = saldo;
    }

    public int getDeuda() {
        return deuda;
    }

    public void setDeuda(int deuda) {
        this.deuda = deuda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
