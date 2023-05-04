package net.homecredit;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import net.homecredit.conway.cli.CliCell;
import net.homecredit.conway.cli.CliConwayRuntime;
import net.homecredit.conway.core.ConwayCore;
import net.homecredit.conway.model.Cell;
import org.apache.maven.plugin.AbstractMojo;

import java.io.*;

/**
 * Goal which runs the game.
 *
 * @goal game
 */
public class MyMojo
        extends AbstractMojo {

    private static BufferedWriter out;

    int steps = 400;
    int random = 5;
    final int GRID_SIZE = 50;
    Cell map[][] = new Cell[GRID_SIZE][GRID_SIZE];
    private static ConwayCore conwayCore = new ConwayCore(new CliConwayRuntime());


    public void execute() {
        System.out.println("Conway way of life ...");

        try {
            out = new BufferedWriter(new OutputStreamWriter(new
                    FileOutputStream(FileDescriptor.out), "ASCII"), 512);
        } catch (UnsupportedEncodingException e) {
        }

        ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "cls").inheritIO();
        conwayCore.init(map, random);
        while (--steps != 0) {
            map = conwayCore.getNextState(map);
            try {
                Thread.currentThread().sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                processBuilder.start().waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                print(map);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void print(Cell[][] map) throws IOException {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                CliCell cell = (CliCell) map[i][j];
                cell.setOut(out);
                map[i][j].showSelf();
            }
            out.write(" |\n");
        }
        out.flush();
    }


}
