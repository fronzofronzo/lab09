package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberConsoleView implements DrawNumberView {

    private DrawNumberController controller;

    @Override
    public void setController(DrawNumberController observer) {
        this.controller = observer;    
    }

    @Override
    public void start() {
        System.out.println("Console view started");
    }

    @Override
    public void result(DrawResult res) {
        System.out.println(res.getDescription());
        controller.resetGame();
    }

}