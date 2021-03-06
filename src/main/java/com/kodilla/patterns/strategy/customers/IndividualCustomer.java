package com.kodilla.patterns.strategy.customers;

import com.kodilla.patterns.strategy.customers.Customer;
import com.kodilla.patterns.strategy.predictors.ConservativePredictor;

public class IndividualCustomer extends Customer {
    public IndividualCustomer(String name){
        super(name);
        this.buyPredictor  = new ConservativePredictor();
    }
}
