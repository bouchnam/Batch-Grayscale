import edu.duke.*;
import java.io.*;

public class imagesInverted {
    public ImageResource makeInverted(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for (Pixel pixel: outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            pixel.setRed(255 - inPixel.getRed());
            pixel.setGreen(255 - inPixel.getBlue());
            pixel.setBlue(255 - inPixel.getGreen());
        }
        return outImage;
    }

    public void selectAndConvert () {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = makeInverted(inImage);
            String fName = inImage.getFileName();
            String newName = "inverted-" + fName;
            gray.setFileName("images/" + newName);
            gray.save();
            inImage.draw();
            gray.draw();
        }
    }

    public void testInverted() {
        selectAndConvert();
    }
}