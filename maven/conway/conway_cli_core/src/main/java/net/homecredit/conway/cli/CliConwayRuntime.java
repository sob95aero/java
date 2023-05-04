package net.homecredit.conway.cli;

import net.homecredit.conway.model.Cell;
import net.homecredit.conway.core.ConwayRuntime;

public class CliConwayRuntime extends ConwayRuntime {

    public Cell initLivingCell() {
        return new LivingCliCell();
    }

    public Cell initDeadCell() {
        return new DeadCliCell();
    }
}
