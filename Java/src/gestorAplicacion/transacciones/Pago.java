package gestorAplicacion.transacciones;

import gestorAplicacion.usuario.Cuenta;
import gestorAplicacion.usuario.CuentaAhorro;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Pago implements Serializable {
    private long monto;
    private int id = 1000;
    private String fecha;
    private CuentaAhorro cuenta;
    private Prestamo prestamo;
    private Multa multa;

    protected String tipo;

    LocalDate currentDate = LocalDate.now();
    static ArrayList<Pago> pagos = new ArrayList<Pago>();

    public Pago(int monto, Cuenta cuenta,Multa multa , String tipo){
        this.monto = monto;
        id = getId()+1;
        this.fecha = currentDate.toString();
        this.cuenta = (CuentaAhorro) cuenta;
        this.tipo = tipo;
        this.multa=multa;
        pagos.add(this);

    }
    public Pago(int monto, Cuenta cuenta,Prestamo prestamo, String tipo){
        this.monto = monto;
        id = getId()+1;
        this.fecha = currentDate.toString();
        this.cuenta = (CuentaAhorro) cuenta;
        this.tipo = tipo;
        this.prestamo=prestamo;
        pagos.add(this);

    }
    /*Este metodo filtra los pagos de prestamos y le añade los pagos de multas*/
    public static ArrayList<Pago> separarPagos(){
        ArrayList<Pago> multas = new ArrayList<Pago>();
        ArrayList<Pago> prestamos = new ArrayList<Pago>();
        for (Pago pago:pagos){
            if (pago.getTipo().equals("Multa")){
                multas.add(pago);
            } else {
                prestamos.add(pago);
            }
        }
        prestamos.addAll(multas);
        return prestamos;
    }

    /* Este metodo calcula la diferencia del monto a la hora de pagar una multa
    * separa casos dependiendo si es mayor menor o igual
    * retorna un mensaje dependiendo del caso
    * */
    public String realizarPagoMulta(Multa multa,int monto){

        Multa.mora(this, multa);

        if (!cuenta.isEstado()) {return "su cuenta está bloqueada";} //en caso de que el metodo anterior haya dado false evitar problemas de consola

        else if (cuenta.getSaldoDisponible()< monto) {return "Saldo insuficiente";}

        else if (this.monto==multa.getMonto()){return realizarPagoMulta(multa);}
            multa.pagarMulta(monto);
            return "Este es su nuevo monto: "+ multa.getMonto();
    }

    public String realizarPagoMulta(Multa multa){
        Multa.mora(this, multa);

        if (!cuenta.isEstado()){return "su cuenta está bloqueada";}//en caso de que el metodo anterior haya dado false evitar problemas de consola

        else if(cuenta.getSaldoDisponible()< monto){ return "Saldo insuficiente";}

        multa.pagarMulta();
        return "su multa fue pagada con exito" +
                "\nEste es su nuevo Saldo: "+ multa.getCuenta().getSaldoDisponible();

        // no se si poner que retorne algo para posteriores metodos
    }

    /* Este metodo realiza el pago de prestamo a travez de la consulta del
    * estado saldo y prestamo de cuenta y la consulta de cuotas fechas de pago y los dias de mora de prestamo
    * para al final calcular el nuevo saldo y el estado del prestamo
    * */
    public String RealizarPagoPrestamo(){ //opcion 1 para pagar un prestamo (pago total del prestamo)
        Multa.mora(this,cuenta,prestamo);

        if(!cuenta.isEstado()) return "Su cuenta está bloqueada";

        if(cuenta.getDeuda()!= prestamo.getValorPrestamo()) {
                cuenta.setDeuda(0);
            }
        if (prestamo.getValorPrestamo() <= cuenta.getSaldoDisponible()){
            prestamo.saldarPrestamo();
            return "Su deuda ha sido saldada" +
                    "\nNuevo saldo: " + cuenta.getSaldoDisponible();

        } else{
            return "Saldo insuficiente";
        }

    }
    /* Este metodo realiza el pago de prestamo a travez de la consulta del
     * estado saldo y prestamo de cuenta y la consulta de cuotas fechas de pago y los dias de mora de prestamo
     * para al final calcular el nuevo saldo y el estado del prestamo
     * */
    public String RealizarPagoPrestamo(int cuotas){ //opcion 2 para pagar un prestamo. pago por x cuotas. dato (int cuotas) introducido por consola. se debe limitar que sea desde 1 hasta 24
        //organizar para tener un index de prestamo
        Multa.mora(this,cuenta,prestamo);

        if(!cuenta.isEstado())return "Su cuenta está bloqueada";

        if (cuotas > prestamo.cuotasDePago) return "Valor de cuotas es exedente";

        if (this.monto > cuenta.getSaldoDisponible()) return "Saldo insuficiente";

        if (cuotas == prestamo.cuotasDePago){

            prestamo.saldarPrestamo();
            return "Su deuda ha sido saldada" +
                    "\nNuevo saldo: " + cuenta.getSaldoDisponible();

        } else {
            prestamo.saldarCuota(cuotas);
            return "Nuevo saldo: " + cuenta.getSaldoDisponible() +
                    "\nDeuda actual: " + cuenta.getDeuda() +
                    "\nTe Faltan "+ prestamo.cuotasDePago + " cuotas";
        }
    }



    //setters getters

    public String getFecha() {return fecha;}

    public void setFecha(String fecha) {this.fecha = fecha;}

    public Cuenta getCuenta() {return cuenta;}

    public void setCuenta(CuentaAhorro cuenta) {this.cuenta = cuenta;}

    public int getId() {return id;}
    public long getMonto() {return monto;}
    public void setMonto(long monto) {this.monto = monto;}

    public static ArrayList<Pago> getPagos() {return pagos;}

    public static void setPagos(ArrayList<Pago> pagos) {Pago.pagos = pagos;}

    public String getTipo() {return tipo;}

    public void setTipo(String tipo) {this.tipo = tipo;}

    @Override
    public String toString() {
        return "Pago" +
                "monto=" + monto +
                ", id=" + pagos.indexOf(this) +
                ", fecha='" + fecha + '\'' +
                ", cuenta=" + cuenta.getNumero() +
                ", tipo='" + tipo + '\'' +
                '\n';
    }
}
