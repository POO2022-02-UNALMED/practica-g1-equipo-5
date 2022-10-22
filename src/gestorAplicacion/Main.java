package gestorAplicacion;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Valentina", null, 102020123);




        Cliente cliente2 = new Cliente("nombre",null,102921082);

        CuentaAhorro cuentaA = new CuentaAhorro(cliente1);

        cuentaA.solicitarPrestamo(10000, "universitario");
        System.out.println(cuentaA.prestamo.getValorPrestamo());
        System.out.println(cuentaA.prestamo.getInteres());
        System.out.println(cuentaA.prestamo.getTipoPrestamo());



        cliente1.retirarDinero(5000000);



        cliente1.getCuenta().setPrestamo(new Prestamo(100000,cliente1.getCuenta(),"vehiculo"));

    }
}
