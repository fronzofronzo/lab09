package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements a SimpleController. In toBePrinted is stored 
 *
 */
public final class SimpleController implements Controller {

    private String toBePrinted = null;
    private List<String> history;

    public SimpleController() {
        history = new ArrayList<>();
    }

    @Override
    public String getNextString() {
        return toBePrinted;
    }

    @Override
    public void setNextString(String str) {
        if(str == null) {
            throw new IllegalArgumentException("String should not be null");
        }
        toBePrinted = str;
    }

    @Override
    public List<String> getHistory() {
        return new ArrayList<>(List.copyOf(history));
    }

    @Override
    public void printCurrentString() {
        if(this.toBePrinted == null) {
            throw new IllegalStateException("String is unset");
        }
        System.out.println(toBePrinted);
        history.add(toBePrinted);
    }

}
