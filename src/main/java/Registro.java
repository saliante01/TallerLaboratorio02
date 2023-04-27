import java.util.InputMismatchException;
import java.util.Scanner;


public class Registro {
    public static void main(String[] args) {
        String[][] registro = new String[50][3];
        int a = -1;


        do {
            System.out.println("""
                    Menú
                    1) Agregar persona.
                    2) Mostrar la cantidad de personas mayores de edad.
                    3) Mostrar la cantidad de personas menores de edad.
                    4) Mostrar la cantidad de personas de tercera edad.
                    5) Mostrar la cantidad de personas según estado civil (Soltero/a - Casado/a).
                    6)Salir.
                    """);


            do {
                try {
                    a = new Scanner(System.in).nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Opción inválida");
                }
                if (a < 1 || a > 6) System.err.println("Opción inválida ingrese un numero entre 1 y 6");
            } while (a < 1 || a > 6);


            if (a == 1) {
                if (verificarEspacio(registro)) {
                    int indiceDisponible = obtenerUltimoEspacio(registro);
                    String nombre;
                    String Estadocivil;
                    int edad;

                    while (true) {
                        System.out.println("Ingrese el nombre: ");
                        try {
                            nombre = new Scanner(System.in).nextLine();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }


                    while (true) {
                        try {
                            System.out.println("Ingrese el estado civil: ");
                            Estadocivil = verificarEstadoCivil();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }


                    while (true) {
                        try {
                            System.out.println("Ingrese la edad: ");
                            edad = Integer.parseInt(new Scanner(System.in).nextLine());
                        } catch (InputMismatchException | NumberFormatException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        if (edad < 0 || edad > 120) {
                            System.err.println("Edad inválida");
                            continue;
                        }
                        break;
                    }


                    registro[indiceDisponible][0] = nombre;
                    registro[indiceDisponible][1] = Estadocivil;
                    registro[indiceDisponible][2] = String.valueOf(edad);
                    System.out.println("Persona agregada.");
                } else {
                    System.out.println("No hay cupo.");
                }
                a = -1;
            } else if (a == 2) {
                int mayoresDeEdad = 0;


                for (String[] persona : registro) {
                    try {
                        if (Integer.parseInt(persona[2]) >= 18) mayoresDeEdad++;
                    } catch (NumberFormatException ignored) {

                    }
                }


                System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
            } else if (a == 3) {
                int menoresDeEdad = 0;
                int queSera = obtenerUltimoEspacio(registro);


                for (int i = 0; i < queSera; i++) {
                    try {
                        if (Integer.parseInt(registro[i][2]) < 18) menoresDeEdad++;
                    } catch (NumberFormatException ignored) {
                    }
                }


                System.out.println("Hay " + menoresDeEdad + " menores de edad.");
                a = -1;
            } else if (a == 4) {
                int mmmm = 0;


                for (String[] persona : registro) {
                    try {
                        if (Integer.parseInt(persona[2]) >= 60 && persona[1].equals("casado/a")) {
                            mmmm++;
                        } else if (Integer.parseInt(persona[2]) >= 65 && persona[1].equals("soltero/a")) {
                            mmmm++;
                        }
                    } catch (NumberFormatException | NullPointerException ignored) {
                    }
                }
                System.out.println("Hay " + mmmm + " personas de tercera edad");
                a = -1;
            } else if (a == 5) {
                int c = 0;
                int d = 0;
                for (String[] persona : registro) {
                    try {

                        if (persona[1].equals("casado/a")) {
                            c++;
                        } else if (persona[1].equals("soltero/a")) {
                            d++;
                        }
                    } catch (NullPointerException ignored) {
                    }
                }


                System.out.println("Hay " + d + " casados/as.");
                System.out.println("Hay " + c + " solteros/as.");
                a = -1;
            } else {
                System.exit(0);
            }
        } while (true);
    }

    private static String verificarEstadoCivil() {
        while (true) {
            try {
                System.out.println("""
                        1) Casado/a
                        2) Soltero/a
                        """);
                Scanner sc = new Scanner(System.in);
                int i = sc.nextInt();
                if (i == 1) {
                    return "casado/a";
                } else if (i == 2) {
                    return "soltero/a";
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida");
            }
        }
    }


    public static int obtenerUltimoEspacio(String[][] registro) {
        return registro.length - ultimoIndex(registro);
    }


    public static boolean verificarEspacio(String[][] registro) {
        return ultimoIndex(registro) != 0;
    }


    public static int ultimoIndex(String[][] registro) {
        for (int i = 0; i < registro.length; i++) {
            if (registro[i][0] == null) {
                return registro.length - i;
            }
        }


        return 0;
    }

}