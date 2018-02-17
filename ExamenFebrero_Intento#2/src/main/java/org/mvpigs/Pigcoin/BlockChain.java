package org.mvpigs.Pigcoin;

import java.util.ArrayList;

public class BlockChain {
    private ArrayList<Transaction> blockChain = new ArrayList<Transaction>(); // lo componen las transacciones de pigcoins que han realizado los propietarios de las wallets

    // Constructor
    public BlockChain() {
    }

    //Metodos
    public ArrayList<Transaction> getBlockChain() {
        return this.blockChain;
    }

    public void summarize() {
        for (Transaction transaction : blockChain) {
            System.out.println(transaction.toString());
        }
    }

    public void summarize(int posicion) {
        System.out.println(blockChain.get(posicion));
    }

    public void addOrigin(Transaction transaction) {
        System.out.println(transaction);
    }
}