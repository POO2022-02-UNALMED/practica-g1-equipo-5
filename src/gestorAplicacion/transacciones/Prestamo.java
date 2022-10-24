package gestorAplicacion.transacciones;

import gestorAplicacion.usuario.CuentaAhorro;

import java.io.Serializable;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Prestamo implements Serializable {

    private int valorPrestamo;
    private String diasMora;
    private String fechaPago;
    private String fechaPrestamo;
    LocalDate currentDate = LocalDate.now();
    private String tipoPrestamo;
    private double interes;
    public static final int topeMax=7000000;
    public static final int topeMin=500000;
    public int cuotasDePago=24;
    public CuentaAhorro cuenta;
    private int valorCuota;
    private boolean estado;
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

    public Prestamo(int valor,CuentaAhorro cuenta,String tipoPrestamo){
        this.cuenta =cuenta;
        this.fechaPrestamo = String.valueOf(currentDate);
        long fechaPrestamoToLong = formato.parse(this.fechaPrestamo, new ParsePosition(0)).getTime();
        this.fechaPago = formato.format(new Date(fechaPrestamoToLong + 2592000000L));   //sumar 30 dias para generar fecha de pago
        generarPrestamo(valor,tipoPrestamo);
        this.estado = true;
    }
    public Prestamo(int valor,CuentaAhorro cuenta,String tipoPrestamo,String fechaPrestamo){
        this.cuenta =cuenta;
        this.fechaPrestamo = fechaPrestamo;
        long fechaPrestamoToLong = formato.parse(this.fechaPrestamo, new ParsePosition(0)).getTime();
        this.fechaPago = formato.format(new Date(fechaPrestamoToLong + 2592000000L));   //sumar 30 dias para generar fecha de pago
        generarPrestamo(valor,tipoPrestamo);
        this.estado = true;
    }

    public void generarPrestamo(int valorPrestamo,String tipoPrestamo){
                switch (tipoPrestamo) {
                    case "universitario" -> interes = 0.06;
                    case "hobbie" -> interes = 0.04;
                    case "libre" -> interes = 0.10;
                    default -> System.out.println("Ingresar uno de los tipos validos de prestamos");
                }
                int valorTotalPrestamo = (int) (valorPrestamo + valorPrestamo * interes);
                cuenta.setDeuda(valorTotalPrestamo + cuenta.getDeuda());
                cuenta.setSaldoTotal(cuenta.getSaldoTotal() + valorPrestamo);
                cuenta.setSaldoDisponible(cuenta.getSaldoDisponible() + valorPrestamo);
                this.valorCuota=valorPrestamo/cuotasDePago;
                this.valorPrestamo=valorPrestamo;
                this.tipoPrestamo=tipoPrestamo;
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
        cuenta.setDeuda(cuenta.getDeuda()-valorPrestamo);
        this.setEstado(false);
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

    public boolean isEstado() {return estado;}

    public void setEstado(boolean estado) {this.estado = estado;}
    public int getId() { return cuenta.getPrestamos().indexOf(this); }

    public String mensajePrestamo(){
        return "Ha sido aprobado tu prestamo" +
                " con un valor de " + valorPrestamo +
                " en la fecha " + fechaPrestamo +
                "\nDe tipo " + tipoPrestamo +
                " con una tasa de interes del " + interes +
                "," +"fue desembolsado en la cuenta " + cuenta.getNumero() +
                "\nLa cuota a pagar será " + valorCuota +
                " para una deuda total de " + cuenta.getDeuda();
    }

    @Override
    public String toString() {
        return this.getId() + ": Prestamo con un valor de " + valorPrestamo + " de tipo " + tipoPrestamo + " La cuota a pagar es " + valorCuota;

    }
}
