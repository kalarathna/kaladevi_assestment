package com.acme.mytrader.strategy;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceListenerImpl;
import com.acme.mytrader.price.PriceSource;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */


public class TradingStrategy {

    private PriceSource priceSource;
    private PriceListener listener;


    public TradingStrategy(PriceSource priceSource, PriceListener listener){
        this.priceSource=priceSource;
        this.listener=listener;
        this.priceSource.addPriceListener(listener);

    }
    public TradingStrategy(){

    }

  public void execute(String security, Double price){

        listener.priceUpdate(security,price);

  }

}
