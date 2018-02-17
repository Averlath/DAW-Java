package org.mvpigs.Pigcoin;

import java.security.PublicKey;

public class Transaction {
    private String hash = null; //Identificador de la transaccion en el BlockChain
    private String prev_hash = null; // identificador de la transacción previa
    private PublicKey pKey_sender = null; // dirección desde la que se envían los pigcoins
    private PublicKey pKey_recipient = null; //  dirección pública a la que se envían los pigcoins
    private double pigcoins = 0; // cantidad de pigcoins que se envían
    private String message = null; // mensaje que acompaña a la transacción
    private byte[] signature = null; // el mensaje message firmado con la clave privada del usuario

    public Transaction() {
    }

    public Transaction(String hash, String prev_hash, PublicKey pKey_sender, PublicKey pKey_recipient, double pigcoins, String message) {
        this.hash = hash;
        this.prev_hash = prev_hash;
        this.pKey_sender = pKey_sender;
        this.pKey_recipient = pKey_recipient;
        this.pigcoins = pigcoins;
        this.message = message;
    }

    public String toString() {
        String transactions = "\nhash = " + hash + "\nprev_hash = " + prev_hash + "\nnKey_sender = " + pKey_sender.hashCode() + "\nnKey_recipient = " + pKey_recipient.hashCode() + "\npigcoins = " + pigcoins + "\nmessage = " + message;
        return transactions;
    }
}