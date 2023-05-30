package org.tasks;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageValidator {

    private static final String IMG_LOCATION = "/Users/testvagrant/Downloads/Personal/Shared/Jithin.jpg";
    private static final int IMG_MIN_WIDTH = 400;
    private static final int IMG_MAX_WIDTH = 600;
    private static final int IMG_MIN_HEIGHT = 600;
    private static final int IMG_MAX_HEIGHT = 800;
    private static final int REQUIRED_BIT_DEPTH = 24; // Either 8 or 16 or 24
    private static final long MAX_IMAGE_SIZE = 5 * 1024 * 1024; // 5MB - replace 5 with the required size in MB

    public static void main(String[] args) {

        File imageFile = new File(IMG_LOCATION);
        System.out.println("Is the image valid? - " + isImageValid(imageFile));

    }

    public static boolean isImageValid(File file) {
        try {

            // Validate image content
            BufferedImage image = ImageIO.read(file);
            System.out.println("1. Image content: " + image);
            if (image == null) {
                return false; //The file is not a valid image
            }

            // Validate image format
            String fileExtension = getFileExtension(file.getName());
            System.out.println("2. Image format: " + fileExtension);
            if (!isSupportedImageFormat(fileExtension)) {
                return false; //The file format is not supported
            }

            //Validate image size
            long fileSize = file.length();
            System.out.println("3. Image maximum allowed size: " + MAX_IMAGE_SIZE);
            System.out.println("4. Image size: " + fileSize);
            if (fileSize > MAX_IMAGE_SIZE) {
                return false; //The image size is not matching
            }

            // Validate image dimensions
            int width = image.getWidth();
            int height = image.getHeight();
            System.out.println("5. Image dimensions: width - " + width + ", and height - " + height);
            if (width < IMG_MIN_WIDTH || width > IMG_MAX_WIDTH || height < IMG_MIN_HEIGHT || height > IMG_MAX_HEIGHT) {
                return false; //The image dimension is not matching
            }

            // Validate image bit depth
            int bitDepth = image.getColorModel().getPixelSize();
            System.out.println("6. Image bit depth: " + bitDepth);
            return bitDepth == REQUIRED_BIT_DEPTH; // The image bit depth in not matching
// All validations passed

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex + 1).toLowerCase();
        }
        return "";
    }

    public static boolean isSupportedImageFormat(String fileExtension) {
        String[] supportedFormats = ImageIO.getReaderFileSuffixes();
        for (String format : supportedFormats) {
            if (format.equalsIgnoreCase(fileExtension)) {
                return true;
            }
        }
        return false;
    }


}
