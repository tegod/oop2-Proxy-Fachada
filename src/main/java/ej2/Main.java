package ej2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Usuario juanAdmin = new Usuario("Juan (Administrador)", List.of(Permiso.ADMIN));
        Usuario anaIntermedio = new Usuario("Ana (Supervisor)", List.of(Permiso.INTERMEDIO));
        Usuario pedroBasico = new Usuario("Pedro (Operario)", List.of(Permiso.BASICO));

        ReadFile archivoImportante = new FileAccesProxy("C:/datos", "importante_formulas.txt");
        ReadFile archivoModerado = new FileAccesProxy("C:/datos", "manual_procedimientos.txt");
        ReadFile archivoComun = new FileAccesProxy("C:/datos", "lista_precios.txt");

        evaluarAcceso(archivoImportante, juanAdmin);
        evaluarAcceso(archivoImportante, anaIntermedio);
        evaluarAcceso(archivoImportante, pedroBasico);

        evaluarAcceso(archivoModerado, juanAdmin);
        evaluarAcceso(archivoModerado, anaIntermedio);
        evaluarAcceso(archivoModerado, pedroBasico);

        evaluarAcceso(archivoComun, pedroBasico);
    }

    private static void evaluarAcceso(ReadFile archivo, Usuario usuario) {
        try {
            archivo.readFile(usuario);
            System.out.println("-> Éxito: Acceso AUTORIZADO por el Proxy.");
        } catch (SecurityException e) {
            System.out.println("-> Bloqueo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("-> Éxito: Autorizado por el Proxy (Error posterior de lectura física en disco).");
        }
    }
}
