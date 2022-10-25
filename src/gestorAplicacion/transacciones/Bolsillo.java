package gestorAplicacion.transacciones;

import baseDatos.Deserializador;
import gestorAplicacion.usuario.Cuenta;

import java.io.Serializable;

public class Bolsillo implements Serializable {
    public enum Categoria {
        VIAJES, EDUCACION, SALUD, ALIMENTACION, TRANSPORTE, HOGAR, IMPREVISTOS, OTROS;
    }
    public int id;
    private int valorCargaBolsillo;
    private Cuenta cuenta;
    private Categoria categoria;
    private int metaAhorro;
    private int saldoDisponible;

    public Bolsillo(int metaAhorro, Cuenta cuenta, int opcion) {
        this.cuenta = cuenta;
        this.categoria = Categoria.values()[opcion];
        this.metaAhorro=metaAhorro;
    }

    public static Bolsillo crearBolsillo(int metaAhorro, Cuenta cuenta, int opcion) {
        cuenta.setSaldoDisponible(cuenta.getSaldoTotal());
        return new Bolsillo(metaAhorro, cuenta, opcion);
    }
    public String cargarBolsillo() {
        if(cuenta.getSaldoDisponible()<metaAhorro){
            return "No tienes saldo suficiente en la cuenta para cargar el bolsillo";
        }
        else if(valorCargaBolsillo == metaAhorro){
            return "La meta de ahorro ya fue alcanzada";
        }
        else if(cuenta.misBolsillos.isEmpty()){
            return "No existe un bolsillo, por favor cree uno";
        }
        this.valorCargaBolsillo = metaAhorro;
        cuenta.setSaldoDisponible(cuenta.getSaldoTotal()-cuenta.saldoEnBolsillos());
        cuenta.misBolsillos.set(cuenta.misBolsillos.indexOf(this),this);
        return "Felicitaciones, alcanzaste tu meta de ahorro";
    }

    public String cargarBolsillo(int valor) {
        if(cuenta.getSaldoDisponible()<valor){
            return "No tienes saldo suficiente en la cuenta para cargar el bolsillo";
        }
        else if(cuenta.misBolsillos.isEmpty()){
            return "No existe un bolsillo, por favor cree uno";
        }
        else if(valor+valorCargaBolsillo == metaAhorro){
            return "La meta de ahorro ya fue alcanzada";
        }
        else if(valor+valorCargaBolsillo > metaAhorro){
            return "Verifica tu saldo en el bolsillo, es posible que excedas el valor posible a recargar ";
        }
        this.valorCargaBolsillo +=valor;
        cuenta.setSaldoDisponible(cuenta.getSaldoTotal()-cuenta.saldoEnBolsillos());
        cuenta.misBolsillos.set(cuenta.misBolsillos.indexOf(this),this);
        return "El bolsillo fue cargado con "+getValorCargaBolsillo();
    }
    public String descargarBolsillo() {
        if(cuenta.misBolsillos.isEmpty() || valorCargaBolsillo == 0){
            return "Debe crear o cargar el bolsillo para poder descargarlo";
        }
        cuenta.setSaldoTotal(cuenta.getSaldoDisponible()+cuenta.saldoEnBolsillos());
        cuenta.setSaldoDisponible(cuenta.getSaldoTotal());
        this.valorCargaBolsillo -= valorCargaBolsillo;
        cuenta.misBolsillos.set(cuenta.misBolsillos.indexOf(this),this);
        return "Se ha descargado el bolsillo completamente. ";
    }
    public String descargarBolsillo(int valor) {
        if (valorCargaBolsillo <= valor){
            descargarBolsillo();
        }
        else if(cuenta.misBolsillos.isEmpty() || valorCargaBolsillo == 0){
            return "Debe crear o cargar el bolsillo para poder descargarlo";
        }
        this.valorCargaBolsillo -=valor;
        cuenta.setSaldoTotal(cuenta.getSaldoDisponible()+cuenta.saldoEnBolsillos());
        cuenta.misBolsillos.set(cuenta.misBolsillos.indexOf(this),this);
        return "Se ha descargado el valor del bolsillo a tu cuenta, quedas con un saldo de ahorro de: " +getValorCargaBolsillo();
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return cuenta.getMisBolsillos().indexOf(this);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValorCargaBolsillo() {
        return valorCargaBolsillo;
    }

    public void setValorCargaBolsillo(int valorCargaBolsillo) {
        this.valorCargaBolsillo = valorCargaBolsillo;
    }

    public String mensajeBolsillo() {
        return  "Has iniciado un nuevo ahorro: " +
                " Número de bolsillo = "+this.getId()+
                ", se asoció a la cuenta = " + cuenta.getNumero() +
                ", \n estableciste una meta de ahorro de = " + metaAhorro +
                ", para ser usado en = " + categoria +
                " \n hasta el momento has ahorrado = " + valorCargaBolsillo +
                ' ';
    }
    @Override
    public String toString() {
        return "Bolsillo: "+this.getId() + ", en la cuenta " + cuenta.getNumero() + " con una meta de ahorro " +  metaAhorro  + " hasta el momento has ahorrado " + valorCargaBolsillo;
    }
}


