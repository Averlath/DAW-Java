package org.mvpigs.Cotxox;

import org.mvpigs.Cotxox.Carrera;

public class Tarifa {
    static double costeMilla = 1.35;
    static double costeMinuto = 0.35;
    static double costeMinimo = 5.0;
    static int porcentajeComision = 20;

    public static double getCosteDistancia(double distancia) {
        return distancia * costeMilla;
    }

    public static double getCosteTiempo(int minutos) {
        return minutos * costeMinuto;
    }

    public static double getCosteTotalEsperado(Carrera carrera) {
        double costeTotal = getCosteDistancia(carrera.getDistancia())+getCosteTiempo(carrera.getTiempoEsperado());
        return costeTotal;
    }
}