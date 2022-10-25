package gestorAplicacion.usuario;


import gestorAplicacion.transacciones.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {
    private String nombre;
    public Cuenta cuenta;
    public static ArrayList<Cuenta> listaCuentas=new ArrayList<>();
    private int cedula;
    public Movimiento movimiento;

    public Cliente(String nombre, int cedula,int tipoCuenta) {
        this.nombre = nombre;
        this.cedula = cedula;
        listaCuentas.add(new CuentaAhorro(this,10000));
        listaCuentas.add(new CuentaCorriente(this,20000));
    }

    public static Cuenta buscarCuenta(int id){
        for (Cuenta cuenta : listaCuentas) {
            if (id == listaCuentas.get(listaCuentas.indexOf(cuenta)).getId()) {
                return cuenta;
            }
        }
        return null;
    }
    public static Cuenta listarCuentas(){
        for (Cuenta cuenta : listaCuentas) {
            return cuenta;
        }
        return null;
    }
    public static Bolsillo buscarBolsillo(int id,int idbolsillo){

        Cuenta cuenta = buscarCuenta(id);
        return  cuenta.getMisBolsillos().get(idbolsillo);

        }


    public static Multa buscarMulta(int id,int idMulta){

        CuentaAhorro cuenta = (CuentaAhorro) buscarCuenta(id);
        return cuenta.getMultas().get(idMulta);

    }
    public static Prestamo buscarPrestamo(int id,int idPrestamo){

        CuentaAhorro cuenta = (CuentaAhorro) buscarCuenta(id);
        return cuenta.getPrestamos().get(idPrestamo);

    }


    public void hacerTransferencia (int id,int id1, int valor){
        Cuenta c1 = this.buscarCuenta(id);
        Cuenta c2 = this.buscarCuenta(id1);
        Transferencia tr= new Transferencia ();
        tr.enviarDinero(c1,c2,valor);
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

    public void solicitarPrestamo(int valor,String tipoPrestamo,int id){
        if (valor>=Prestamo.topeMin && valor<= Prestamo.topeMax)
            ((CuentaAhorro) buscarCuenta(id)).getPrestamos().add(new Prestamo(valor, ((CuentaAhorro) buscarCuenta(id)), tipoPrestamo));
    }

    public void generarAhorro(int valor,int categoria,int id){
        buscarCuenta(id).getMisBolsillos().add(Bolsillo.crearBolsillo(valor,buscarCuenta(id),categoria));

    }
    public void cargarAhorro(int valor,int idCuenta,int idBolsillo){
        buscarBolsillo(idCuenta,idBolsillo).cargarBolsillo(valor);
    }

    public void cargarAhorro(int idCuenta,int idBolsillo){
        buscarBolsillo(idCuenta,idBolsillo).cargarBolsillo();
    }

    public void descargarAhorro(int idCuenta, int IdBolsillo){
        buscarBolsillo(idCuenta, IdBolsillo).descargarBolsillo();
    }

    public void descargarAhorro(int valor,int idCuenta, int IdBolsillo){
        buscarBolsillo(idCuenta, IdBolsillo).descargarBolsillo(valor);
    }

    public String hacerPagoPrestamo(int idCuenta, int idPrestamo, int cuota){ //arreglar para arrojar el prestamo numeroDePrestamo
        Pago pago = new Pago(buscarPrestamo(idCuenta,idPrestamo).getValorCuota() * cuota,buscarCuenta(idCuenta),"Prestamo");
        return pago.RealizarPagoPrestamo(cuota, idCuenta,idPrestamo);
    }

    public String hacerPagoPrestamo( int idCuenta, int idPrestamo){ //arreglar para arrojar el prestamo numeroDePrestamo
        Pago pago = new Pago(buscarPrestamo(idCuenta,idPrestamo).getValorPrestamo(),buscarCuenta(idCuenta),"Prestamo");
        return pago.RealizarPagoPrestamo(idCuenta, idPrestamo);
    }

    public String hacerPagoMulta(int idCuenta, int idMulta, int monto){ //arreglar para arrojar el prestamo numeroDeMulta

        Pago pago = new Pago(monto,buscarCuenta(idCuenta),"Multa");

        return pago.realizarPagoMulta(Cliente.buscarMulta(idCuenta,idMulta), idMulta, monto);
    }

    public String hacerPagoMulta(int idCuenta, int idMulta){ //arreglar para arrojar el prestamo numeroDeMulta

        Pago pago = new Pago( (int) Cliente.buscarMulta(idCuenta,idMulta).getMonto(),buscarCuenta(idCuenta),"Multa");

        return pago.realizarPagoMulta(Cliente.buscarMulta(idCuenta,idMulta), idMulta, idMulta);
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

    public static ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public static void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        Cliente.listaCuentas = listaCuentas;
    }
}
