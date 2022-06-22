package com.acme.mytrader.price;

import com.acme.mytrader.execution.ExecutionService;

import static org.junit.jupiter.api.Assertions.*;

class PriceListenerImplTest {

    @Mock
    ExecutionService executionService;
    PriceListener priceListener;

    @Before
    public void setUp() {
        priceListener = new PriceListenerImpl(executionService, 55, 100);
    }

    @Test
    public void excutebuyNegativeFlow() {
        priceListener.priceUpdate("IBM", 50);
        Mockito.verify(executionService).buy("IBM", 50, 100);
    }

    @Test
    public void executeBuyPositiveFlow() {
        priceListener.priceUpdate("IBM", 60);
        Mockito.verifyZeroInteractions(executionService);
    }
}