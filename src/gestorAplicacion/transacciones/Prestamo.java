package gestorAplicacion.transacciones;

import gestorAplicacion.usuario.Cuenta;
import gestorAplicacion.usuario.CuentaAhorro;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Prestamo {

    private int valorPrestamo;
    private String diasMora;
    private String fechaPago;
    private String fechaPrestamo;
    LocalDate currentDate = LocalDate.now();
    private String tipoPrestamo;
    private double interes;
    private static final int topeMax=7000000;
    private static final int topeMin=500000;
    public int cuotasDePago=24;
    public CuentaAhorro cuenta;
    private int valorCuota;
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

    public Prestamo(int valor,CuentaAhorro cuenta,String tipoPrestamo){
        this.cuenta =cuenta;
        if (this.cuenta.getPrestamo()==null)
            generarPrestamo(valor,tipoPrestamo);
    }

    public void generarPrestamo(int valorPrestamo,String tipoPrestamo){
                    if (valorPrestamo>=topeMin && valorPrestamo<= topeMax) {
                switch (tipoPrestamo) {
                    case "universitario" -> interes = 0.06;
                    case "hobbie" -> interes = 0.04;
                    case "libre" -> interes = 0.10;
                    default -> System.out.println("Ingresar uno de los tipos validos de prestamos");
                }
                int valorTotalPrestamo = (int) (valorPrestamo + valorPrestamo * interes);
                cuenta.setDeuda(valorTotalPrestamo);
                cuenta.setSaldoTotal(cuenta.getSaldoTotal() + valorPrestamo);
                cuenta.setSaldoDisponible(cuenta.getSaldoDisponible() + valorPrestamo);
                cuenta.setPrestamo(this);
                this.valorCuota=valorPrestamo/cuotasDePago;
                this.valorPrestamo=valorPrestamo;
                this.tipoPrestamo=tipoPrestamo;
                this.fechaPrestamo = String.valueOf(currentDate);

                long fechaPrestamoToLong = formato.parse(this.fechaPrestamo, new ParsePosition(0)).getTime();
                this.fechaPago = formato.format(new Date(fechaPrestamoToLong + 2592000000L));   //sumar 30 dias para generar fecha de pago
        }
    }

    public void saldarCuota(int cantidadCuotas){
        int valor=valorCuota*cantidadCuotas;
        cuenta.setDeuda(cuenta.getDeuda()-(valor));
        cuenta.setSaldoDisponible(cuenta.getSaldoDisponible()-valor);
        cuenta.setSaldoTotal(cuenta.getSaldoTotal()-valor);
        cuotasDePago-=cantidadCuotas;
        this.valorPrestamo-=valorCuota;
    }

    public void saldarCuota(){
        cuenta.setDeuda(cuenta.getDeuda()-valorCuota);
        cuotasDePago-=1;
        cuenta.setSaldoDisponible(cuenta.getSaldoDisponible()-valorCuota);
        cuenta.setSaldoTotal(cuenta.getSaldoTotal()-valorCuota);
        this.valorPrestamo-=valorCuota;
    }

    public void saldarPrestamo(){
        cuenta.setDeuda(0);
        cuenta.setPrestamo(null);
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

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    @Override
    public String toString() {
        return "Ha sido aprobado tu prestamo" +
                "\nCon un valor de " + valorPrestamo +
                "\nEn la fecha " + fechaPrestamo +
                "\nDe tipo " + tipoPrestamo +
                "\nCon una tasa de interes de " + interes +
                "," +"\nFue desembolsado en la cuenta " + cuenta.getNumero() +
                "\nLa cuota a pagar será de " + valorCuota +
                "\nPara una deuda total de " + cuenta.getDeuda();

    }
}