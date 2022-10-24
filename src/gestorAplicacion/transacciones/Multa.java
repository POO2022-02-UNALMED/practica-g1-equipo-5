package gestorAplicacion.transacciones;

import gestorAplicacion.usuario.Cuenta;

import gestorAplicacion.usuario.CuentaAhorro;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;


public class Multa {
    public static final int plazoPago = 30;
    private long monto;

    private CuentaAhorro cuenta;
    private int tiempoMulta;
    private String fecha;
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    static ArrayList<Multa> Multas = new ArrayList<Multa>();

    public Multa(){

        this(null);
    }

    public Multa (Cuenta cuenta){
        this( 50000, cuenta,String.valueOf(LocalDate.now()));

    }

    public Multa( long monto, Cuenta cuenta, String fecha){


        this.monto = monto;
        this.cuenta = (CuentaAhorro) cuenta;
        this.fecha = fecha;
        Multas.add(this);
    }

    public static void eliminarMulta(CuentaAhorro cuenta,long monto){


        cuenta.setMulta(null);
        cuenta.setSaldoDisponible(cuenta.getSaldoDisponible()-((int) monto));
    }


    public static void multarCuenta(CuentaAhorro cuenta){
        cuenta.setMulta(new Multa(cuenta));

    }

    /* Metodo usado para calcular el monto por mora despues de no haber cumplido el
    *   plazoPago. Si la cantidad de dias despues de haber pasado Plazopago
    *   es mayor a 90 se Bloquea la cuenta pasando Estado:boolean a false
    * */
    public void mora(Pago pago){
        long fechaMulta = formato.parse(this.fecha, new ParsePosition(0)).getTime(); // fecha a entero (en milisegundos desde 1970)
        long fechaPago = formato.parse(pago.getFecha(), new ParsePosition(0)).getTime();
        long discriminante =  (fechaPago-fechaMulta)/86400000;

        if (discriminante > plazoPago){
            long diasMora = discriminante- plazoPago;
            this.setMonto((long) (this.monto*Math.pow(1.01,diasMora))); //aplicar un mora del 1% por dia de mora

            if (diasMora > 90){                 // esto deberia de compararse por ultima fecha de pago y no por los dias de mora
                multarCuenta((CuentaAhorro) pago.getCuenta());
            }
        }
    }
    /* Metodo usado para calcular el monto por mora despues de no haber cumplido el
     *   fechaPago del prestamo. Si la cantidad de dias despues de haber pasado fechaPago
     *   es mayor a 90 se multa la cuenta pasando Multa:boolean a true y generando una nueva multa
     * */
    public void mora(Pago pago,CuentaAhorro cuenta){
        long fechaMulta = formato.parse(cuenta.getPrestamo().getFechaPago(), new ParsePosition(0)).getTime(); // fecha a entero (en milisegundos desde 1970)
        long fechaPago = formato.parse(pago.getFecha(), new ParsePosition(0)).getTime();
        long discriminante =  (fechaPago-fechaMulta)/86400000;

        if (discriminante > plazoPago) {
            long diasMora = discriminante - plazoPago;
            cuenta.setDeuda((int) (cuenta.getDeuda() * Math.pow(1.01, diasMora))); //aplicar un mora del 1% por dia de mora

            if (diasMora > 90){                 // esto deberia de compararse por ultima fecha de pago y no por los dias de mora
                multarCuenta(cuenta);
            }
        }
    }


    public String toString() {
        if (cuenta.tieneMultta()){

            return "Usted actualmente cuenta con una multa de: " + this.getMonto() +
                    "\nDesde: " + this.getFecha();

        } else {

            return "Usted no cuenta con multas actualmente";

        }
    }

    //Setters getters
    public Cuenta getCuenta() {return cuenta;}

    public void setCuenta(CuentaAhorro cuenta) {this.cuenta = cuenta;}

    public long getMonto() {return monto;}

    public void setMonto(long monto) {this.monto = monto;}

    public String getFecha() {return fecha;}

    public void setFecha(String fecha) {this.fecha = fecha;}
}