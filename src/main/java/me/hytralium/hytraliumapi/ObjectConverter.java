package me.hytralium.hytraliumapi;

import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class ObjectConverter {
    public static String convertObjectToString(Object object) {
        String encodedOnject;
        try {
            ByteArrayOutputStream io = new ByteArrayOutputStream();
            BukkitObjectOutputStream os = new BukkitObjectOutputStream(io);
            os.writeObject(object);
            os.flush();
            byte[] serializedObject = io.toByteArray();
            encodedOnject = Base64.getEncoder().encodeToString(serializedObject);
            return encodedOnject;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object convertStringToObject(String string) {
        try {
            byte[] serializedObject;
            serializedObject = Base64.getDecoder().decode(string);
            ByteArrayInputStream in = new ByteArrayInputStream(serializedObject);
            BukkitObjectInputStream is = new BukkitObjectInputStream(in);
            return is.readObject();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
