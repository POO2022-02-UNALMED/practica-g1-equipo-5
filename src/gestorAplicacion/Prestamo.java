package gestorAplicacion;
public class Prestamo {

    private int valorPrestamo;
    private String diasMora;
    private String fechaPago;
    private String tipoPrestamo;
    private double interes;
    private static final int topeMax=7000000;
    private static final int topeMin=500000;
    public int cuotasDePago=24;
    public Cuenta cuentaDestino;
    private int valorCuota;

    public Prestamo(int valor,Cuenta cuenta,String tipoPrestamo){
        this.cuentaDestino=cuenta;
        generarPrestamo(valor,tipoPrestamo);
    }

    public void generarPrestamo(int valorPrestamo,String tipoPrestamo){

        if (cuentaDestino.getPrestamo()==null)
            if (valorPrestamo>=topeMin && valorPrestamo<= topeMax) {
                switch (tipoPrestamo) {
                    case "universitario" -> interes = 0.06;
                    case "hobbie" -> interes = 0.04;
                    case "libre" -> interes = 0.10;
                    default -> System.out.println("Ingresar uno de los tipos validos de prestamos");
                }
                int valorTotalPrestamo = (int) (valorPrestamo + valorPrestamo * interes);
                cuentaDestino.setDeuda(valorTotalPrestamo);
                cuentaDestino.setSaldo(cuentaDestino.getSaldo() + valorPrestamo);
                cuentaDestino.setPrestamo(this);
                this.valorCuota=valorPrestamo/cuotasDePago;
                this.valorPrestamo=valorPrestamo;
                this.tipoPrestamo=tipoPrestamo;
            }
    }

    public void saldarCuota(int cantidadCuotas){
            cuentaDestino.setDeuda(cuentaDestino.getDeuda()-(valorCuota*cantidadCuotas));
            cuotasDePago-=1;
            this.valorPrestamo-=valorCuota;
    }

    public void saldarCuota(){
        cuentaDestino.setDeuda(cuentaDestino.getDeuda()-valorCuota);
        cuotasDePago-=1;
        this.valorPrestamo-=valorCuota;
    }

    public void saldarPrestamo(){
        cuentaDestino.setDeuda(0);
        cuentaDestino.setPrestamo(null);
    }

    public int getValorPrestamo() {
        return valorPrestamo;
    }

    public void setValorPrestamo(int valorPrestamo) {
        this.valorPrestamo = valorPrestamo;
    }

    public String getDiasMora() {
        return diasMora;
    }

    public void setDiasMora(String diasMora) {
        this.diasMora = diasMora;
    }

    public int getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(int valorCuota) {
        this.valorCuota = valorCuota;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
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
