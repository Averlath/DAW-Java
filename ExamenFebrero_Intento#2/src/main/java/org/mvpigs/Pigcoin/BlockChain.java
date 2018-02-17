package org.mvpigs.Pigcoin;

import org.mvpigs.Pigcoin.Transaction;
import org.mvpigs.Pigcoin.Wallet;
import org.mvpigs.Pigcoin.GenSig;

import java.security.PublicKey;

public class BlockChain {
    private String[] blockChain = null; // lo componen las transacciones de pigcoins que han realizado los propietarios de las wallets

    public void summarize() {
        System.out.println(blockChain);
    }

    public void addOrigin(Transaction transaction) {
        System.out.println(transaction);
    }

    public void processTransactions(PublicKey pKey_sender, PublicKey pKey_recipient, int consumedCoins, String message, byte[] signedTransaction) {}

    public void isConsumedCoinValid(int consumedCoins) {}

    public void isSignatureValid(PublicKey pKey_sender, String message, byte[] signedTransaction) {}

    public void createTransaction(PublicKey pKey_sender, PublicKey pKey_recipient, int consumedCoins, String message, byte[] signedTransaction) {}

    public void loadInputTransactions(PublicKey address) {}

    public void loadOutputTransactions(PublicKey address) {}

    public void loadWallet(PublicKey address) {}
}