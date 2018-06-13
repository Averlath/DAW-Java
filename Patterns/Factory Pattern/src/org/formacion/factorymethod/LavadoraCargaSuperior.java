package org.formacion.factorymethod;

public class LavadoraCargaSuperior extends Lavadora {

    public LavadoraCargaSuperior() {
    	    this.tipoCarga = "superior";
    }
}

/*
public class LavadoraCargaSuperiorFactoria extends ?? {
    @Override
    public Lavadora creaLavadoraTipo() {
        return newLavadoraSuperior;
    }
}

*/