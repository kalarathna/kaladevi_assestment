package com.acme.mytrader.strategy;

import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceSource;
import org.junit.Test;

public class TradingStrategyTest {
    @Mock
    private PriceSource priceSource;
    @Mock
    private PriceListener priceListener;

    private TradingStrategy tradingStrategy;

    @Before
    public void setUp() {
        tradingStrategy = new TradingStrategy(priceSource, priceListener);
    }

    @Test
    public void testPositiveFlow() {
        String security = "IBM";
        double stockPrice = 60.0;
        tradingStrategy.execute(security, stockPrice);

        verify(priceListener).priceUpdate(security, stockPrice);
    }

    @Test
    public void testNegativeFlow() {
        String security = "IBM";
        double stockPrice = 0.0;

        tradingStrategy.execute(security, stockPrice);

        verifyZeroInteractions(priceListener);
    }
}
