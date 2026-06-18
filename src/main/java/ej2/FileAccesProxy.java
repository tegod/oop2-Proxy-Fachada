package ej2;

import java.io.IOException;

public class FileAccesProxy implements ReadFile {
    private FileAccess  fileAccess;

    public FileAccesProxy(String ruta, String nombre) {
        fileAccess = new FileAccess(ruta, nombre);
    }

    @Override
    public String readFile(Usuario usuario) throws IOException {
        String nombre = fileAccess.nombreArchivo();

        if (nombre.startsWith("i")) {
            if (!usuario.poseePermiso(Permiso.ADMIN)) {
                throw new SecurityException("Se requiere permiso administrativo");
            }
        }
        else if (nombre.startsWith("m")) {
            if (!usuario.poseePermiso(Permiso.ADMIN) && !usuario.poseePermiso(Permiso.INTERMEDIO)) {
                throw new SecurityException("Se requiere permiso administrativo o intermedio");
            }
        }

        return fileAccess.readFile(usuario);
    }
}
