package org.mvpigs.Estacion;

import java.util.concurrent.ThreadLocalRandom;

import org.mvpigs.Bicicleta.Bicicleta;
import org.mvpigs.TarjetaUsuario.TarjetaUsuario;

public class Estacion {
    private int id;
    private String direccion;
    private int numeroAnclajes;
    private Bicicleta[] anclajes;

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
        System.out.println("El id es: " + getId());
        System.out.println("La direccion es: " + getDireccion());
        System.out.println("El numero de anclajes es: " + getNumeroAnclajes());
    }
 
    public int anclajesLibres() {
        int anclajesLibres = 0;
        for (Bicicleta anclaje : this.anclajes) {
            if (anclaje == null) {
                anclajesLibres++;
            }
        }
        return anclajesLibres;
    }

    public void consultarAnclajes() {
        int posicion = 0;
        int numeroAnclaje = 0;

        for (Bicicleta bicicleta : this.anclajes) {
            numeroAnclaje = posicion + 1;
            if (bicicleta != null) {
                System.out.println("Anclaje " + numeroAnclaje + " " + this.anclajes[posicion].getId());
            } else {
                System.out.println("Anclaje " + numeroAnclaje + " libre");
                posicion++;
            }
        }
    }

    public void mostrarAnclaje(Bicicleta bicicleta, int numeroAnclaje) {
        System.out.println("bicicleta: " + bicicleta.getId() + "anclada en el anclaje: " + numeroAnclaje);
    }

    public void anclarBicicleta(Bicicleta bicicleta) {
        int posicion = 0;
        int numeroAnclaje = posicion + 1;
        
        for (org.mvpigs.Bicicleta.Bicicleta anclaje : this.anclajes) {
            if (anclaje == null) {
                this.anclajes[posicion] = bicicleta;
                mostrarAnclaje(bicicleta, numeroAnclaje);
            }
        }
    }
    
    public boolean leerTarjetaUsuario(TarjetaUsuario tarjetaUsuario) {
        return tarjetaUsuario.getActivada();
    }

    public int generarAnclaje() {
        Integer numeroEntero = ThreadLocalRandom.current().nextInt(0, this.anclajes.length);
        return numeroEntero;
    }

    public void mostrarBicicleta(Bicicleta bicicleta, int numeroAnclaje) {
        System.out.println("bicicleta retirada: " + bicicleta.getId() + " de anclaje: " + numeroAnclaje);
    }

    public void retirarBicicleta(TarjetaUsuario tarjetaUsuario) {
        if (leerTarjetaUsuario(tarjetaUsuario)) {
            boolean biciRetirada = false;
            while (!biciRetirada) {
                int posicion = generarAnclaje();
                int numeroAnclaje = posicion + 1;

                if (this.anclajes[posicion] != null) {
                    mostrarBicicleta(this.anclajes[posicion], numeroAnclaje);
                    this.anclajes[posicion] = null;
                    biciRetirada = true;
                }
            }
        } else {
            System.out.println("Tarjeta de usuario inactiva");
        }
    }
}