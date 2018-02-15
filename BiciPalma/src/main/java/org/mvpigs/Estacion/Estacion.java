package org.mvpigs.Estacion;

import java.util.concurrent.ThreadLocalRandom;

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
        System.out.println("El id es: " + getId());
        System.out.println("La direccion es: " + getDireccion());
        System.out.println("El numero de anclajes es: " + getNumeroAnclajes());
    }
 
    public int anclajesLibres() {
        int anclajesLibres = 0;
        for (org.mvpigs.Bicicleta.Bicicleta anclaje : this.anclajes) {
            if (anclaje == null) {
                anclajesLibres++;
            }
        }
        return anclajesLibres;
    }

    public void consultarAnclajes() {
        int posicion = 0;
        int numeroAnclaje = 0;

        for (org.mvpigs.Bicicleta.Bicicleta bicicleta : this.anclajes) {
            numeroAnclaje = posicion + 1;
            if (bicicleta != null) {
                System.out.println("Anclaje " + numeroAnclaje + " " + this.anclajes[posicion].getId());
            } else {
                System.out.println("Anclaje " + numeroAnclaje + " libre");
                posicion++;
            }
        }
    }

    public void mostrarAnclaje(org.mvpigs.Bicicleta.Bicicleta bicicleta, int numeroAnclaje) {
        System.out.println("bicicleta: " + bicicleta.getId() + "anclada en el anclaje: " + numeroAnclaje);
    }

    public void anclarBicicleta(org.mvpigs.Bicicleta.Bicicleta bicicleta) {
        int posicion = 0;
        int numeroAnclaje = posicion + 1;
        
        for (org.mvpigs.Bicicleta.Bicicleta anclaje : this.anclajes) {
            if (anclaje == null) {
                this.anclajes[0] = bicicleta;
                mostrarAnclaje(bicicleta, numeroAnclaje);
            } else {
                posicion++;
                numeroAnclaje++;
            }
        }
    }
    
    public boolean leerTarjetaUsuario(org.mvpigs.TarjetaUsuario.TarjetaUsuario tarjetaUsuario) {
        return tarjetaUsuario.getActivada();
    }

    public int generarAnclaje() {
        Integer numeroEntero = ThreadLocalRandom.current().nextInt(0, this.anclajes.length);
        return numeroEntero;
    }

    public void mostrarBicicleta(org.mvpigs.Bicicleta.Bicicleta bicicleta, int numeroAnclaje) {
        System.out.println("bicicleta retirada: " + bicicleta.getId() + " de anclaje: " + numeroAnclaje);
    }

    public void retirarBicicleta(org.mvpigs.TarjetaUsuario.TarjetaUsuario tarjetaUsuario) {
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