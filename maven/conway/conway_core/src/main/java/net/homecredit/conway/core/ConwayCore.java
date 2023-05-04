package net.homecredit.conway.core;

import net.homecredit.conway.model.Cell;

import java.util.Random;

public class ConwayCore {

    public static final Random RANDOM = new Random();
    Cell deadCell;
    Cell livingCell;

    public ConwayCore(ConwayRuntime runtime) {
        this.livingCell = runtime.getLivingCell();
        this.deadCell = runtime.getDeadCell();
    }

    public Cell getLivingCell() {
        return livingCell;
    }

    public Cell getDeadCell() {
        return deadCell;
    }

    public void init(Cell[][] map, int random) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (random == 0) {
                    map[i][j] = deadCell;
                    continue;
                }
                if (RANDOM.nextInt() % random == 0) {
                    map[i][j] = livingCell;
                } else {
                    map[i][j] = deadCell;
                }
            }
        }
    }

    public Cell[][] getNextState(Cell[][] map) {
        Cell newMap[][] = new Cell[map.length][map.length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                newMap[i][j] = checkCell(map, i, j);
            }
        }
        return newMap;
    }

    private Cell checkCell(Cell[][] map, int i, int j) {
        int liveCount = 0;
        for (int k = -1; k <= 1; k++) {
            for (int l = -1; l <= 1; l++) {
                Cell cell;
                try {
                    cell = map[i - k][j - l];
                } catch (ArrayIndexOutOfBoundsException e) {
                    cell = deadCell;
                }

                if (cell.isLiving()) {
                    liveCount++;
                }
            }
        }
        boolean isLiving = map[i][j].isLiving(); //because we count self in previous step
        if (isLiving) {
            liveCount -= 1;
        }

        if (isLiving) {
            if (liveCount < 2) {
                return deadCell;
            }
            if (liveCount > 1 && liveCount < 4) {
                return livingCell;
            }
            if (liveCount > 3) {
                return deadCell;
            }
        }

        if (!isLiving && liveCount == 3) {
            return livingCell;
        }
        return deadCell;
    }
}
