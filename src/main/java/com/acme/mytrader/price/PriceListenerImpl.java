package com.acme.mytrader.price;


import com.acme.mytrader.execution.ExecutionService;

public class PriceListenerImpl implements PriceListener{

    private ExecutionService executionService;
    private double triggerLevel;
    private int volume;

    public PriceListenerImpl(ExecutionService executionService, double triggerLevel, int volume){
        this.executionService=executionService;
        this.triggerLevel=triggerLevel;
        this.volume=volume;
    }

    @Override
    public void priceUpdate(String security, double price) {

        if(!security.isEmpty() && security!=null){
        if(price<=triggerLevel){
            executionService.buy(security,price,volume);
        }
        }

    }
}
