package org.utils;

import org.enums.FileDirectory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class FilesHandler {
    private static Properties properties = new Properties();

    /* Eager Initialization */
    static {
        try {
            properties.load(new FileInputStream(FileDirectory.CONFIG_FILE.getDirectory()));
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getConfigValue(String key) {
        if (Objects.isNull(key) || Objects.isNull(properties.getProperty(key))) {
            try {
                throw new IllegalArgumentException("Property name " + key + " is not found. Please check the config.properties file.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return properties.getProperty(key).trim();
    }

}
