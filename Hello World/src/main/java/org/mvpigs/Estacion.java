package estacion;

import java.util.concurrent.ThreadLocalRandom;

import bicicleta.Bicicleta;
import tarjetaUsuario.TarjetaUsuario;

public class Estacion {
   private int id;
   private String direccion;
   private int numeroAnclajes;
   private Bicicleta[] anclajes;

   public Estacion(int id, String direccion, int anclajes) {
       this.id = id;
       this.direccion = direccion;
       this.numeroAnclajes = anclajes;
       this.anclajes = new Bicicleta[anclajes];
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

   public class void consultarEstacion() {
       System.out.print("El id es: " + getId);
       System.out.print("La direccion es: " + getDireccion);
       System.out.print("El numero de anclajes es: " + getNumeroAnclajes);
   }

   public int anclajesLibres() {
       int anclajesLibres = null;
       for (Bicicleta anclaje: this.anclajes) {
           if (anclaje == null) {
               anclajesLibres++;
           }
       }
       return anclajesLibres;
   }
}