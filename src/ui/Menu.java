package ui;

import java.io.*;
import model.*;
import exceptions.*;

public class Menu {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private MiniMarket market;

    public Menu() {
        market = new MiniMarket();
    }

    public void showMenu() throws IOException {
        bw.write("MENU PRINCIPAL: Elija una opcion segun su requerimiento\n");
        bw.write("-------------------------------MANEJO DEL MARKET-------------------------------\n");
        bw.write("(1) Para registrar el ingreso de una nueva persona al Market\n");
        bw.write("(2) Para consultar la cantidad de personas que han intentado ingresar\n");
        bw.write("-----------------------------------SALIR-----------------------------------------\n");
        bw.write("(3) Para salir de app\n");
        bw.flush();
    }

    public int readOption() throws IOException {
        int choice = Integer.parseInt(br.readLine());
        return choice;
    }

    public String readPerson() throws IOException {
        String msg = "";
        bw.write("Ingrese el tipo de documento de la persona a ingresar\n");
        bw.write("0- TI - Tarjeta de identidad\n");
        bw.write("1- CC - Cedula de ciudadanía\n");
        bw.write("2- PP - Pasaporte\n");
        bw.write("3- CE - Cedula de Extranjeria\n");
        bw.flush();
        int type = Integer.parseInt(br.readLine());
        DocumentType[] dTypes = DocumentType.values();
        DocumentType dt = null;
        for (int i = 0; i < dTypes.length; i++) {
            if (i == type) {
                dt = dTypes[i];
            }
        }
        bw.write("Ingrese el numero de documento de la persona a ingresar\n");
        bw.flush();
        int id = Integer.parseInt(br.readLine());
        try {
            msg = market.addPersonToMarket(dt, id) + "\n";
        } catch (UnderAgeException u) {
            bw.write("Menor de edad(-18).\n");
            bw.flush();
            u.printStackTrace();
        } catch (DateException d) {
            if (d.getState()) {
                bw.write("Hoy es dia par y tu penultimo digito tambien lo es, no puedes ingresar.\n");
            } else {
                bw.write("Hoy es dia impar y tu penultimo digito tambien lo es, no puedes ingresar.\n");
            }
            bw.flush();
            d.printStackTrace();
        }
        return msg;
    }

    public String attempts() {
        return "La cantidad de personas al momento, que han intentado ingresar es de: " + market.getAttempts() + "\n";
    }

    public void doOperation(int choice) throws IOException {
        switch (choice) {
        case 1:
            bw.write(readPerson());
            break;
        case 2:
            bw.write(attempts());
            break;
        case 3:
            bw.write("Gracias por utilizar nuestros servicios");
            break;
        default:
            bw.write("Error, opción no válida");
        }
        bw.flush();
    }

    public void startProgram() throws IOException {
        int option;
        do {
            showMenu();
            option = readOption();
            doOperation(option);
        } while (option != 3);
    }
}
