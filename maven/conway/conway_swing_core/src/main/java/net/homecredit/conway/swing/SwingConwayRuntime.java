package net.homecredit.conway.swing;

import net.homecredit.conway.model.Cell;
import net.homecredit.conway.core.ConwayRuntime;

public class SwingConwayRuntime extends ConwayRuntime {

    public Cell initLivingCell() {
        return new LivingSwingCell();
    }

    public Cell initDeadCell() {
        return new DeadSwingCell();
    }
}
