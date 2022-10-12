package uiMain;

import java.util.Scanner;

public class UIMenu {
    public void mostrarMenu(){
        Scanner sc = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("Bienvenido a PiggyBank\n Elija una opción:");
            System.out.println("1. Consultar saldo\n " +
                    "2. Retirar dinero\n" +
                    "3. Enviar dinero\n" +
                    "4. Pagar deudas \n" +
                    "5. salir");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    //consultarSaldo()
                    break;
                case 2:
                    //retirarDinero()
                    break;
                case 3:
                    //enviarDinero()
                    break;
                case 4:
                    //pagarDeudas()
                    break;
                default:
                    System.out.println("Por favor ingrese una opción valida");
            }

        }while(opcion != 5);

    }






}
