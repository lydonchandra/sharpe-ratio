package com.don.trading;

import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.don.trading.ratio.Sharpe;

public class SharpeTest 
    extends TestCase
{
	private final static Logger LOGGER = LoggerFactory.getLogger(SharpeTest.class);

    @org.junit.Test
    public void testGetSharpeRatio() throws IOException {
    	final Sharpe sharpe = new Sharpe();
    	
    	final double [] returns2 = { 0.0164 , 0.0585, 0.0922, 0.0351, -0.0088, 0.0107, 0.1303, 0.094, 0.1049, -0.0508 };
    	assertEquals( sharpe.getSharpeRatio(returns2, 0.05), 2.6568000353699786 );
    	
    	final double [] returns4 = { 0.054, 0.0086, -0.0846, 0.1040, 0.013, 0.0037, 0.0078, 0.0116, 0.00923, 0.0112, 0.0187, 0.0061 };
    	assertEquals( sharpe.getSharpeRatio(returns4, 0.0035), 1.0898282924873377 );
    	LOGGER.info("finished");
    }
}
