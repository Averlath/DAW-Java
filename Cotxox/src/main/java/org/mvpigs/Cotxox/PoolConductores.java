package org.mvpigs.Cotxox;

import org.mvpigs.Cotxox.Conductor;
import java.util.Random;

import java.util.ArrayList;

public class PoolConductores {
    private ArrayList<Conductor> poolConductores;

    public PoolConductores(ArrayList<Conductor> poolConductores) {
        this.poolConductores = poolConductores;
    }

    public void setPoolConductores(ArrayList<Conductor> poolConductores) {
        this.poolConductores = poolConductores;
    }

    public ArrayList<Conductor> getPoolConductores() {
        return this.poolConductores;
    }

    public Conductor asignarConductor() {
        Random rnd = new Random();
        int posicion_conductor = 0;

        do {
            posicion_conductor = rnd.nextInt(poolConductores.size());
        } while (poolConductores.get(posicion_conductor).isOcupado());

        poolConductores.get(posicion_conductor).setOcupado(true);
        Conductor conductor = poolConductores.get(posicion_conductor);

        return conductor;
    }
}