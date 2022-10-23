package gestorAplicacion.usuario;

import gestorAplicacion.transacciones.Bolsillo;
import gestorAplicacion.transacciones.Prestamo;
import gestorAplicacion.transacciones.Pago;

public class Cliente {
    private String nombre;
    public Cuenta cuenta;
    private int cedula;

    public Cliente(String nombre, int cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.cuenta = new CuentaAhorro(this);
    }
    public int consultarSaldo(){
        return cuenta.getSaldoTotal();
    }
    public void retirarDinero(int valorRetiro){
        cuenta.setSaldoDisponible(cuenta.getSaldoDisponible()-valorRetiro);
    }
    public void cosignarDinero(int valoraConsignacion){
        cuenta.setSaldoTotal(cuenta.getSaldoTotal()+valoraConsignacion);
    }

    public void solicitarPrestamo(int valor,String tipoPrestamo){
        cuenta.setPrestamo(new Prestamo(valor,cuenta,tipoPrestamo));
    }

    public void generarAhorro(int valor,int categoria){
        cuenta.getMisBolsillos().add(Bolsillo.crearBolsillo(valor,cuenta,categoria));

    }
    public void cargarAhorro(int valor,int id){
        for (Bolsillo i : cuenta.getMisBolsillos()) {
             if (id==cuenta.getMisBolsillos().get(cuenta.getMisBolsillos().indexOf(i)).getId()){
                 i.cargarBolsillo(valor);
             }

        }
    }

    public void cargarAhorro(int id){
        for (Bolsillo i : cuenta.getMisBolsillos()) {
            if (id==cuenta.getMisBolsillos().get(cuenta.getMisBolsillos().indexOf(i)).getId()){
                i.cargarBolsillo();
            }

        }
    }

    public void descargarAhorro(int valor, int id){
                for (Bolsillo i : cuenta.getMisBolsillos()) {
                if (id==cuenta.getMisBolsillos().get(cuenta.getMisBolsillos().indexOf(i)).getId()){
                    i.descargarBolsillo(valor);
                }

            }
    }

    public String hacerPagoPrestamo( int indexPrestamo){ //arreglar para arrojar el prestamo numeroDePrestamo
        Pago pago = new Pago(this.getCuenta().getPrestamo().getValorCuota(),this.getCuenta());
        return pago.RealizarPagoPrestamo();
    }

    public String hacerPagoPrestamo( int cuotas, int indexPrestamo){ //arreglar para arrojar el prestamo numeroDePrestamo
        Pago pago = new Pago(cuotas*this.getCuenta().getPrestamo().getValorCuota(),this.getCuenta());
        return pago.RealizarPagoPrestamo(cuotas);
    }

    public String hacerPagoMulta(int indexMulta){ //arreglar para arrojar el prestamo numeroDeMulta
        Pago pago = new Pago((int) cuenta.getMulta().getMonto() ,this.getCuenta());
        return pago.realizarPagoMulta(cuenta.getMulta());
    }

    public String hacerPagoMulta(int valor, int indexMulta){ //arreglar para arrojar el prestamo numeroDeMulta
        Pago pago = new Pago(valor ,this.getCuenta());
        return pago.realizarPagoMulta(cuenta.getMulta());
    }


    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

}
