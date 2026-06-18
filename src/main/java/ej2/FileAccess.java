package ej2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileAccess implements ReadFile {
    private String ruta;
    private String nombreArchivo;

    public FileAccess(String ruta, String nombreArchivo) {
        this.ruta = ruta;
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public String readFile(Usuario usuario) throws IOException {
        return Files.readString(Paths.get(ruta + "/" + nombreArchivo));
    }

    public String nombreArchivo() {
        return nombreArchivo;
    }
}
