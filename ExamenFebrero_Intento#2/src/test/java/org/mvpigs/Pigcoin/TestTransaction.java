package org.mvpigs.Pigcoin;

import org.mvpigs.Pigcoin.Transaction;
import org.mvpigs.Pigcoin.Wallet;

import junit.framework.TestCase;
import org.junit.*;

public class TestTransaction extends TestCase {
    Wallet wallet_1;
    Wallet wallet_2;
    Transaction transaction;

    @Before
    public void SetUp() {
        wallet_1 = new Wallet();
        wallet_1.generateKeyPair();

        wallet_2 = new Wallet();
        wallet_2.generateKeyPair();
    }

    //No puedo ejecutar:
    /*@Test
    public void testCrearTransaccion() {
        Transaction transaction = new Transaction();
        transaction = new Transaction("hash_1", "0", wallet_1.getAddress(), wallet_2.getAddress(), 20, "a flying pig!");
        assertEquals("hash_1" , transaction.getHash());
        assertEquals(wallet_1.getAddress(), transaction.getpKey_sender());
        assertEquals(wallet_2.getAddress(), transaction.getpKey_recipient());
    }

    @Test
    public void testTransaccionToString(){
        transaction = new Transaction("hash_1", "0", wallet_1.getAddress(), wallet_2.getAddress(), 20, "a flying pig!");
        System.out.println(transaction.toString());
    }*/
}