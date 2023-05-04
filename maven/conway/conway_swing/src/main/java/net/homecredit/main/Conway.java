package net.homecredit.main;

import net.homecredit.conway.core.ConwayCore;
import net.homecredit.conway.model.Cell;
import net.homecredit.conway.swing.SwingConwayRuntime;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static net.homecredit.conway.swing.SwingCell.SIZE;

public class Conway extends JFrame {

    private static final int GRID_SIZE = 50;
    public static final int RANDOM = 10;
    public static final int DELAY = 20;

    private static GridLayout grid = new GridLayout(GRID_SIZE,GRID_SIZE);
    private static Cell map[][] = new Cell[GRID_SIZE][GRID_SIZE];
    private static ConwayCore conwayCore = new ConwayCore(new SwingConwayRuntime());

    public Conway(String name) {
        super(name);
        conwayCore.init(map, RANDOM);
    }

    public static MapPanel getGridPanel() {
        final MapPanel gridPanel = new MapPanel(conwayCore);
        gridPanel.setLayout(grid);
        gridPanel.setMap(map);
        return gridPanel;
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method is invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        Conway frame = new Conway("Conway way of life demo.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.

        MapPanel gridPanel = getGridPanel();
        final Observable observable = gridPanel.getObservable();

        gridPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                observable.clicked(e.getX(), e.getY(), SwingUtilities.isLeftMouseButton(e));
            }
        });

        gridPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                observable.clicked(e.getX(), e.getY(),SwingUtilities.isLeftMouseButton(e));
            }
        });
        frame.add(gridPanel);


        JButton clear = new JButton("Clear");
        clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                observable.clear();
            }
        });


        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                observable.start();
            }
        });

        JButton stop = new JButton("Stop");
        stop.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                observable.stop();
            }
        });

        JButton nextState = new JButton("Next state");
        nextState.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                observable.nextState();
            }
        });

        JButton restart = new JButton("Restart");
        restart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                observable.restart();
            }
        });

        SpinnerModel model = new SpinnerNumberModel(50, 1, 500, 10);
        final JSpinner spinner = new JSpinner(model);
        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                observable.changeSpeed((Integer) spinner.getValue());
            }
        });

        SpinnerModel randomModel = new SpinnerNumberModel(5, 1, 20, 1);
        final JSpinner random = new JSpinner(randomModel);
        random.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                observable.changeRandom((Integer) random.getValue());
            }
        });

        JPanel panel = new JPanel();
        panel.add(clear);
        panel.add(start);
        panel.add(stop);
        panel.add(nextState);
        panel.add(restart);
        panel.add(spinner);
        panel.add(random);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setPreferredSize(new Dimension(GRID_SIZE * SIZE+SIZE, GRID_SIZE * SIZE + 100 ));

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
