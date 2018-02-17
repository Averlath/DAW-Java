package org.mvpigs.Pigcoin;

import org.mvpigs.Pigcoin.GenSig;
import org.mvpigs.Pigcoin.BlockChain;
import org.mvpigs.Pigcoin.Transaction;

import javax.crypto.interfaces.PBEKey;
import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Signature;
import java.util.Map;

public class Wallet {
    private PublicKey pKey = null; //  dirección pública o clave pública de la wallet
    private PrivateKey sKey = null; // clave privada de la wallet
    private int total_input = 0; // total de pigcoins que han sido recibidos
    private int total_output = 0; // total de pigcoins que se han enviado
    private double balance = 0; // pigcoins que "posee" este usuario
    private String[] inputTransacions = null; // transacciones que tienen como destino esta dirección pública
    private String[] outputTransactions = null; // son las transacciones que tiene como origen esta dirección pública

    public Wallet() {
    }

    public void generateKeyPair() {
        KeyPair pair = GenSig.generateKeyPair();
        this.setSK(pair.getPrivate());
        this.setAddress(pair.getPublic());
    }

    public void setAddress(PublicKey pKey) {
        this.pKey = pKey;
    }

    public void setSK(PrivateKey sKey) {
        this.sKey = sKey;
    }

    public PublicKey getAddress() {
        return pKey;
    }

    public PrivateKey getSKey() {
        return sKey;
    }

    public void sendCoins(PublicKey pkey_recipient, double balance, String message, BlockChain blockChain) {
    }

    public String toString() {
        String wallets = "\nWallet = " + this.getAddress().hashCode() + "\nTotal_input = " + this.total_input + "\nTotal_output = " + this.total_output + "\nBalance = " + this.balance + "\n";
        return wallets;
    }

    public String[] getInputTransaction(String[] InputTransaction) {
        return this.inputTransacions;
    }

    public String[] getOutputTransaction(String[] OutputTransaction) {
        return this.outputTransactions;
    }

    public void loadCoins(BlockChain blockChain) {}

    public void loadInputTransactions(BlockChain blockChain) {}

    public void loadOutputTransactions(BlockChain blockChain) {}

    public void collectCoins(double pigcoins) {}
}