package ej3;

import java.util.HashMap;
import java.util.Map;

public class ImageProxy implements Image {
    private ImageFile imageFile;
    private String path;
    private static Map<String, ImageFile> cache = new HashMap<>();

    public ImageProxy(String path) {
        this.path = path;
    }

    @Override
    public void display() {
        if (imageFile == null) {
            imageFile = new ImageFile(path);
            cache.get(path);
            if(imageFile == null) {
                imageFile = new ImageFile(path);
                cache.put(path, imageFile);
            }
        }
        imageFile.display();
    }
}
