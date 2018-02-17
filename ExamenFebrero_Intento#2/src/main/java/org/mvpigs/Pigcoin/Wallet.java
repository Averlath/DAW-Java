package org.mvpigs.Pigcoin;

import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.KeyPair;
import java.util.ArrayList;

public class Wallet {
    private PublicKey address = null; //  dirección pública o clave pública de la wallet
    private PrivateKey sKey = null; // clave privada de la wallet
    private double total_input = 0; // total de pigcoins que han sido recibidos
    private double total_output = 0; // total de pigcoins que se han enviado
    private double balance = 0; // pigcoins que "posee" este usuario
    private ArrayList<Transaction> inputTransacions = new ArrayList<Transaction>(); // transacciones que tienen como destino esta dirección pública
    private ArrayList<Transaction> outputTransactions = new ArrayList<Transaction>(); // son las transacciones que tiene como origen esta dirección pública


    //Constructor
    public Wallet() {
    }


    //Metodos
    public void generateKeyPair() {
        KeyPair pair = GenSig.generateKeyPair();
        this.setSK(pair.getPrivate());
        this.setAddress(pair.getPublic());
    }

    public void setAddress(PublicKey address) {
        this.address = address;
    }

    public void setSK(PrivateKey sKey) {
        this.sKey = sKey;
    }

    public PublicKey getAddress() {
        return address;
    }

    public PrivateKey getSKey() {
        return sKey;
    }

    public String toString() {
        String wallets = "\nWallet = " + this.getAddress().hashCode() + "\nTotal_input = " + this.total_input + "\nTotal_output = " + this.total_output + "\nBalance = " + this.balance + "\n";
        return wallets;
    }

    public ArrayList<Transaction> getInputTransaction() {
        return this.inputTransacions;
    }

    public ArrayList<Transaction> getOutputTransaction() {
        return this.outputTransactions;
    }
}