package it.unibo.mvc;

import java.util.List;

/**
 * A Controller responsible for I/O access. It consider only the standard output
 */
public interface Controller {

    /**
     * This method gets the next string to be printed on standard output
     */
    public String getNextString();

    /**
     * Set to the next String to be printed 
     * @param str string got by input
     * @throws IllegalArgumentException the string that will be passed in input 
     * should not be null
     */
    public void setNextString(String str);

    /**
     * This method get the history of printed strings
     * @return a List with all the Strings that had been printed
     */
    public List<String> getHistory();

    /**
     * This method prints the current string that has been set
     * @throws IllegalStateException if the current string is unset
     */
    public void printCurrentString();
}
