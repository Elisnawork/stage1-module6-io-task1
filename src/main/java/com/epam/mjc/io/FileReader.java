package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = null;
        Integer age = null;
        String email = null;
        Long phone = null;

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length < 2) {
                    continue;
                }
                String key = parts[0].trim();
                String value = parts[1].trim();

                switch (key) {
                    case "Name":
                        name = value;
                        break;

                    case "Age":
                        age = Integer.parseInt(value);
                        break;

                    case "Email":
                        email = value;
                        break;

                    case "Phone":
                        phone = Long.parseLong(value);
                        break;
                }

            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Profile(name, age, email, phone);
    }
}
