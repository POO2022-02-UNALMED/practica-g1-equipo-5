package gestorAplicacion;
public class Prestamo {

    private int valorPrestamo;
    private String fechaPrestamo;
    private String fechaPago;
    private String tipoPrestamo;
    private double interes;
    private int tope;
    public Cuenta cuentaDestino;

    public Prestamo(int valor,Cuenta cuenta,String tipoPrestamo){
        this.valorPrestamo=valor;
        this.cuentaDestino=cuenta;
        this.tipoPrestamo=tipoPrestamo;
        generarPrestamo(valor,tipoPrestamo);
    }

    public void generarPrestamo(int valorPrestamo,String tipoPrestamo){
        switch (tipoPrestamo) {
            case  "hogar"-> interes = 0.06;
            case "vehiculo" -> interes = 0.04;
            case "libre" -> interes = 0.10;
            default -> System.out.println("Ingresar uno de los tipos validos de prestamos");
        }
        int valorTotalPrestamo=(int)(valorPrestamo+valorPrestamo*interes);
        cuentaDestino.setDeuda(valorTotalPrestamo);
        cuentaDestino.setSaldo(cuentaDestino.getSaldo()+valorPrestamo);
        cuentaDestino.setPrestamo(this);
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

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public String getTipoPrestamo() {
        return tipoPrestamo;
    }

    public void setTipoPrestamo(String tipoPrestamo) {
        this.tipoPrestamo = tipoPrestamo;
    }

}
