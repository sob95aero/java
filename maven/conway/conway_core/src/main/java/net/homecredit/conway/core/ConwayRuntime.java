package net.homecredit.conway.core;

import net.homecredit.conway.model.Cell;

abstract public class ConwayRuntime {

    private Cell livingCell;
    private Cell deadCell;

    public ConwayRuntime() {
        livingCell = initLivingCell();
        deadCell = initDeadCell();
    }

    public abstract Cell initLivingCell() ;
    public  abstract Cell initDeadCell();

    public Cell getLivingCell() {
        return livingCell;
    }

    public Cell getDeadCell() {
        return deadCell;
    }
}
