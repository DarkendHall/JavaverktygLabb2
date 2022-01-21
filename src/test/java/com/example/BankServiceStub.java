package com.example;

public class BankServiceStub implements BankService {

    @Override
    public void pay(String id, double amount) {
        if (id.equals("test2"))
            throw new RuntimeException();
    }
}
