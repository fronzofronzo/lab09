package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String HOME_FOLDER = System.getProperty("user.home");
    private File current = new File(HOME_FOLDER + SEPARATOR + "output.txt");

    public void setFile(File f) {
        if(!f.isFile()) {
            throw new IllegalArgumentException("It's not a file");
        }
        this.current = f;
    }

    public File getCurrentFIle() {
        return this.current;
    }

    public String getPath() {
        return current.getAbsolutePath();
    }

    /**
     * Method that prints the content of a String on the current file
     * @param s is the String got by input
     * @throws IOException 
     */
    public void printStringOnFile(String s) throws IOException {
        try(PrintStream ps = new PrintStream(current)) {
            ps.print(s);
        }
    }
}
