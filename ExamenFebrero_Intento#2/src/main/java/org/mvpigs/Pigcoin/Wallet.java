package org.mvpigs.Pigcoin;

import org.mvpigs.Pigcoin.GenSig;
import org.mvpigs.Pigcoin.Transaction;
import org.mvpigs.Pigcoin.BlockChain;

import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Map;

public class Wallet {
    private PublicKey address = null; //  dirección pública o clave pública de la wallet
    private PrivateKey sKey = null; // clave privada de la wallet
    private double total_input = 0; // coins de pigcoins que han sido recibidos
    private double total_output = 0; // coins de pigcoins que se han enviado
    private double balance = 0; // pigcoins que "posee" este usuario
    private ArrayList<Transaction> inputTransactions = new ArrayList<Transaction>(); // transactiones que tienen como destino esta dirección pública
    private ArrayList<Transaction> outputTransactions = new ArrayList<Transaction>(); // son las transactiones que tiene como origen esta dirección pública

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

    public void setBalance() {
        double balance = getTotal_input() - getTotal_output();
        if (balance >= 0) {
            this.balance = balance;
        }
    }

    public double getBalance() {
        return this.balance;
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

    public void loadCoins(BlockChain blockChain) {
        double totalIn = 0.0d;
        double totalOut = 0.0d;
        for (Transaction transaction : blockChain.getBlockChain()) {
            if (transaction.getpKey_sender().equals(transaction.getpKey_recipient())
                    && transaction.getpKey_sender().equals(getAddress())) {
                totalIn += transaction.getPigcoins();
                totalOut += transaction.getPigcoins();
            } else if (transaction.getpKey_recipient().equals(getAddress())) {
                totalIn += transaction.getPigcoins();
            } else if (transaction.getpKey_sender().equals(getAddress())) {
                totalOut += transaction.getPigcoins();
        }
        setTotal_output(totalOut);
        setTotal_input(totalIn);
        setBalance();
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
    }

    public void loadOutputTransactions(BlockChain blockChain){
        setTotal_output(0);
        for (Transaction transaction : blockChain.getBlockChain()) {
            if (getAddress() == transaction.getpKey_sender()) {
                outputTransactions.add(transaction);
                setTotal_output(transaction.getPigcoins());
            }
        }
    }

    public Map collectCoins(double pigcoins) {
        Map<String, Double> usedCoins = new HashMap<String, Double>();
        for (Transaction transaction : outputTransactions) {
            usedCoins.put(transaction.getHash(), transaction.getPigcoins());
        }
        for (Transaction transaction: inputTransactions) {
            usedCoins.put(transaction.getHash(), transaction.getPigcoins());
        }
        return usedCoins;
    }

    public byte[] signTransaction(String message) {
        return GenSig.sign(getSKey(), message);
    }

    public void sendCoins(PublicKey address, double pigcoins, String message, BlockChain bChain) {
        Map<String, Double> consumedCoins = collectCoins(pigcoins);
        byte[] messageSignature = signTransaction(message);
        bChain.processTransactions(getAddress(), address, consumedCoins, message, messageSignature);
    }
}