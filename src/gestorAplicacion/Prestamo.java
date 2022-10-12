package gestorAplicacion;

public class Prestamo {
    private int valorPrestamo;
    private String fechaPrestamo;
    private String fechaPago;
    private String tipoPrestamo;
    private static double interes=0.1;
    private int tope;
    public Cuenta cuentaDestino;

    public Prestamo(int valor,Cuenta cuenta){
        this.valorPrestamo=valor;
        this.cuentaDestino=cuenta;
    }

    public int getValorPrestamo() {
        return valorPrestamo;
    }

    public void setValorPrestamo(int valorPrestamo) {
        this.valorPrestamo = valorPrestamo;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getTope() {
        return tope;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }

    public static double getInteres() {
        return interes;
    }

    public static void setInteres(double interes) {
        Prestamo.interes = interes;
    }

    public void generarPrestamo(int valorPrestamo){
        int valorTotalPrestamo=(int)(valorPrestamo*Prestamo.interes);
            cuentaDestino.setDeuda(valorTotalPrestamo);
    }

    public void pagarPrestamoParcial(int valor){
        if (valor <= cuentaDestino.getDeuda() ) {
            int nuevoValor = cuentaDestino.getDeuda() - valor;
            cuentaDestino.setDeuda(nuevoValor);
        }
    }

    public void pagarPrestamoTotal(){
        if (cuentaDestino.getSaldo()>= cuentaDestino.getDeuda())
                cuentaDestino.setDeuda(0);
        else {
            System.out.println("No tienes el suficiente dinero para realizar el pago total");
        }
    }

}
