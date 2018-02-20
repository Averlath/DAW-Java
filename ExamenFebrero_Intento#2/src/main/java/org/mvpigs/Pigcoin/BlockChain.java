package org.mvpigs.Pigcoin;

import org.mvpigs.Pigcoin.Transaction;
import org.mvpigs.Pigcoin.Wallet;

import java.util.ArrayList;
import java.security.PublicKey;
import java.util.Map;

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

    public boolean isSignatureValid(PublicKey sender, String message, byte[] messageSigned) {
        return GenSig.verify(sender, message, messageSigned);
    }

    public boolean isConsumedCoinValid(Map<String,Double> usedCoins) {
        for (Map.Entry<String, Double> usedCoin : usedCoins.entrySet()) {
            if (getBlockChain().contains(usedCoin.getKey())) {
                return false;
            }
        }
        return true;
    }

    public void createTransaction(PublicKey sender, PublicKey recipient, Map <String,Double> usedCoins, String message, byte[] messageSigned){
        for (Map.Entry<String, Double> usedCoin : usedCoins.entrySet()) {
            String hash = "hash_" + (getBlockChain().size() + 1);
            PublicKey receptor = (usedCoin.getKey().split("_")[0].equals("CA")) ? sender : recipient;
            Transaction transaccion = new Transaction(hash, usedCoin.getKey(), sender, receptor, usedCoin.getValue(), message);
            addOrigin(transaccion);
        }
    }

    public void processTransactions(PublicKey sender, PublicKey recipient, Map<String,Double> usedCoins, String message, byte[] messageSigned) {
        if (isSignatureValid(sender, message, messageSigned) && isConsumedCoinValid(usedCoins)) {
            createTransaction(sender, recipient, usedCoins,message, messageSigned);
        }
    }
}