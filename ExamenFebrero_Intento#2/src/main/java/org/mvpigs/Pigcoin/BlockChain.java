package org.mvpigs.Pigcoin;

import java.util.ArrayList;
import java.security.PublicKey;

public class BlockChain {
    ArrayList<Transaction> blockChain = new ArrayList<Transaction>(); // lo componen las transacciones de pigcoins que han realizado los propietarios de las wallets

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

    public void summarize(int position) {
        System.out.println(blockChain.get(position));
    }

    public void addOrigin(Transaction transaction) {
        blockChain.add(transaction);
    }
}