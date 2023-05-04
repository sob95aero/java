package net.homecredit.conway.model;

public abstract class DeadCell implements Cell {

    public boolean isLiving() {
        return false;
    }

}
