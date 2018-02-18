package org.mvpigs.Pigcoin;

import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Wallet {
    private PublicKey address = null; //  dirección pública o clave pública de la wallet
    private PrivateKey sKey = null; // clave privada de la wallet
    private double total_input = 0; // coins de pigcoins que han sido recibidos
    private double total_output = 0; // coins de pigcoins que se han enviado
    private double balance = 0; // pigcoins que "posee" este usuario
    private ArrayList<Transaction> inputTransactions = new ArrayList<Transaction>(); // transacciones que tienen como destino esta dirección pública
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

    public PublicKey getAddress() {
        return address;
    }

    public void setSK(PrivateKey sKey) {
        this.sKey = sKey;
    }

    public PrivateKey getSKey() {
        return sKey;
    }

    public void setTotal_input(double total_input) {
        this.total_input = total_input;
    }

    public double getTotal_input(){
        return this.total_input;
    }

    public void setTotal_output(double total_output) {
        this.total_output = total_output;
    }

    public double getTotal_output(){
        return this.total_output;
    }

    public double getBalance() {
        return this.balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String toString() {
        String wallets = "\nWallet = " + this.getAddress().hashCode() + "\ncoins_input = " + this.total_input + "\ncoins_output = " + this.total_output + "\nBalance = " + this.balance + "\n";
        return wallets;
    }

    public ArrayList<Transaction> getInputTransactions() {
        return inputTransactions;
    }

    public ArrayList<Transaction> getOutputTransactions() {
        return outputTransactions;
    }

    public void Xactions(int sender, int recipient, double coins) {
        if (sender == this.address.hashCode()){
            this.setBalance(this.balance - coins);
        }
        else if (recipient == this.address.hashCode()) {
            this.setBalance(this.balance + coins);
        }
    }

    public void loadCoins(BlockChain blockChain) {
        for (Transaction transaction : blockChain.getBlockChain()) {
            Xactions(transaction.getpKey_sender().hashCode(), transaction.getpKey_recipient().hashCode(), transaction.getPigcoins());
        }
    }

    public void loadInputTransactions(BlockChain blockChain){
        setTotal_input(0);
        for (Transaction transaction : blockChain.getBlockChain()) {
            if (getAddress() == transaction.getpKey_recipient()) {
                inputTransactions.add(transaction);
                total_input+=transaction.getPigcoins();
            }
        }
        setBalance(getTotal_input()-getTotal_output());
    }

    public void loadOutputTransactions(BlockChain blockChain){
        setTotal_output(0);
        for (Transaction transaction : blockChain.getBlockChain()) {
            if (getAddress() == transaction .getpKey_sender()) {
                outputTransactions.add(transaction );
                setTotal_output(transaction .getPigcoins());
            }
        }
        setBalance(getTotal_input()-getTotal_output());
    }

    public Map collectCoins(double pigcoins){
        Map<String, Double> usedCoins = new HashMap<String, Double>();
        for (Transaction transaction : outputTransactions) {
            usedCoins.put(transaction.getHash(), transaction.getPigcoins());
        }
        for (Transaction transaction: inputTransactions) {
            usedCoins.put(transaction.getHash(), transaction.getPigcoins());
        }
        return usedCoins;
    }
}