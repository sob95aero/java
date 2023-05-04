package net.homecredit.main;

public interface Observable {
    void start();

    void stop();

    void restart();

    void changeSpeed(int speed);

    void changeRandom(int value);

    void clicked(int x, int y, boolean live);

    void nextState();

    void clear();
}
