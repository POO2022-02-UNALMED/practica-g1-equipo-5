package gestorAplicacion;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Valentina", null, 102020123);
        cliente1.setCuenta(new CuentaAhorro("1",cliente1));
        cliente1.setCuenta(new CuentaCorriente("1",cliente1));

        cliente1.getCuenta().setPrestamo(new Prestamo(100000,cliente1.getCuenta(),"vehiculo"));

    }
}
