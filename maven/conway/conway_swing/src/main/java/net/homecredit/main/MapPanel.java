package net.homecredit.main;

import net.homecredit.conway.core.ConwayCore;
import net.homecredit.conway.swing.SwingCell;
import net.homecredit.conway.model.Cell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static net.homecredit.main.Conway.DELAY;
import static net.homecredit.main.Conway.RANDOM;

public class MapPanel extends JPanel {

    private final ConwayCore conwayCore;
    private Cell[][] map;

    JPanel grid = new JPanel();

    private Timer timer;

    private int random = RANDOM;

    public MapPanel(final ConwayCore conwayCore) {
        this.conwayCore = conwayCore;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        timer = new Timer(DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                map = conwayCore.getNextState(map);
                repaint();
            }
        });
    }

    @Override
    public Graphics getGraphics() {
        return super.getGraphics();
    }

    public void setMap(Cell[][] map) {
        this.map = map;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        print(map, g);
        grid.repaint();
    }

    private void print(Cell[][] map, Graphics g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                SwingCell cell = (SwingCell) map[i][j];
                cell.setG(g);
                cell.setX(i * SwingCell.SIZE);
                cell.setY(j * SwingCell.SIZE);
                cell.showSelf();
            }
        }
    }

    public Observable getObservable() {
        return new Observable() {
            @Override
            public void start() {
                timer.start();
            }

            @Override
            public void stop() {
                timer.stop();
            }

            @Override
            public void restart() {
                timer.stop();
                conwayCore.init(map, random);
                timer.start();
            }

            @Override
            public void changeSpeed(int speed) {
                timer.setDelay(speed);
            }

            @Override
            public void changeRandom(int value) {
                random = value;
            }

            @Override
            public void clicked(int x, int y, boolean live) {
                map[x / SwingCell.SIZE][y / SwingCell.SIZE] = live ? conwayCore.getLivingCell() : conwayCore.getDeadCell();
                repaint();
            }

            @Override
            public void nextState() {
                map = conwayCore.getNextState(map);
                repaint();
            }

            @Override
            public void clear() {
                stop();
                conwayCore.init(map, 0);
                repaint();
            }
        };
    }
}
