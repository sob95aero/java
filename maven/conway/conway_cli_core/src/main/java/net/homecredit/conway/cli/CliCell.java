package net.homecredit.conway.cli;

import net.homecredit.conway.model.Cell;

import java.io.BufferedWriter;
import java.io.IOException;

abstract public class CliCell implements Cell {

    private BufferedWriter out;

    public void setOut(BufferedWriter out) {
        this.out = out;
    }

    public void showSelf() {
        try {
            if (isLiving()) {
                out.write(" | x");
            } else {
                out.write(" |  ");
            }
        } catch (IOException e) {
            // just ignore it for now
        }
    }
}
