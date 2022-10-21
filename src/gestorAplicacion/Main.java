package gestorAplicacion;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Valentina", null, 102020123);
        cliente1.setCuenta(new CuentaAhorro("1",cliente1));
        //cliente1.getCuenta().setSaldo(10000000);

        //System.out.println(cliente1.getCuenta().getSaldo());
        Cliente cliente2 = new Cliente("nombre",null,102921082);
        cliente2.setCuenta(new CuentaCorriente("1",cliente2));

        cliente1.retirarDinero(5000000);

        //System.out.print(cliente1.getCuenta().getSaldo());

        cliente1.getCuenta().setPrestamo(new Prestamo(100000,cliente1.getCuenta(),"vehiculo"));

    }
}
