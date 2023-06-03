package org.enums;

public enum FileDirectory {
    CONFIG_FILE("config.properties");

    private String directory;

    private FileDirectory(String directory) {
        this.directory = directory;
    }

    public String getDirectory() {
        String dir = System.getProperty("user.dir") + "/src/main/java/org/config/" + directory;
        return dir.trim();
    }
}

