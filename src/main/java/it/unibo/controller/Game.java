package it.unibo.controller;

import it.unibo.model.human.Player;
import it.unibo.model.human.PlayerImpl;
import it.unibo.view.screen.Screen;
import it.unibo.view.screen.ScreenImpl;

/**
 * Implementation of the Game engine.
 */
public final class Game implements Runnable {
    private static final int FPS = 120;
    private static final int NANO_IN_SEC = 1_000_000_000;

    private final Thread gameThread;
    private final InputHandler inputHandler;
    private final Screen screen;
    private final Player player;

    /**
     * Sets up all the parameters.
     */
    public Game() {
        inputHandler = new InputHandlerImpl();
        player = new PlayerImpl(ScreenImpl.SCREEN_WIDTH / 2, ScreenImpl.SCREEN_HEIGHT / 2);
        screen = new ScreenImpl(inputHandler);
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        final double drawInterval = NANO_IN_SEC / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                draw();
                delta--;
            }
        }
    }

    private void update() {
        player.setDirection(inputHandler.getDirection());
        player.move();
    }

    private void draw() {
        screen.renderHuman(player);
    }
}
