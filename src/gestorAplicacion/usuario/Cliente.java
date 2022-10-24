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
        listaCuentas.add(new CuentaAhorro(this));
        this.listaCuentas.get(0).setSaldoDisponible(10000);
        listaCuentas.add(new CuentaCorriente(this));
        this.listaCuentas.get(1).setSaldoDisponible(20000);
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
        for (Bolsillo bolsillo : cuenta.misBolsillos) {
            if (idbolsillo == cuenta.getMisBolsillos().get(cuenta.getMisBolsillos().indexOf(bolsillo)).getId()) {
                return bolsillo;
            }
        }
        return null;
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
            ((CuentaAhorro)buscarCuenta(id)).setPrestamo(new Prestamo(valor, ((CuentaAhorro) buscarCuenta(id)), tipoPrestamo));
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

    /*public String hacerPagoPrestamo( int indexPrestamo){ //arreglar para arrojar el prestamo numeroDePrestamo
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
    }*/


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
