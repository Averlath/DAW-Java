package org.mvpigs.Estacion;

import java.util.concurrent.ThreadLocalRandom;

import org.mvpigs.Bicicleta.Bicicleta.*;
import org.mvpigs.TarjetaUsuario.TarjetaUsuario;

public class Estacion {
    private int id;
    private String direccion;
    private int numeroAnclajes;
    private org.mvpigs.Bicicleta.Bicicleta[] anclajes;

    public Estacion(int id, String direccion, int anclajes) {
        this.id = id;
        this.direccion = direccion;
        this.numeroAnclajes = anclajes;
        this.anclajes = new org.mvpigs.Bicicleta.Bicicleta[anclajes];
    }

    public int getId() {
        return id;
    }
 
    public String getDireccion() {
        return direccion;
    }
 
    public int getNumeroAnclajes() {
        return numeroAnclajes;
    }
 
    public void consultarEstacion() {
        System.out.print("El id es: " + getId());
        System.out.print("La direccion es: " + getDireccion());
        System.out.print("El numero de anclajes es: " + getNumeroAnclajes());
    }
 
    public int anclajesLibres() {
        int anclajesLibres = 0;
        for (org.mvpigs.Bicicleta.Bicicleta anclaje: this.anclajes) {
            if (anclaje == null) {
                anclajesLibres++;
            }
        }
        return anclajesLibres;
    }
}