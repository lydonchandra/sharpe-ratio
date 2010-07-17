package com.don.trading;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;

import com.don.trading.ratio.Sharpe;

public class SharpeTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SharpeTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SharpeTest.class );
    }
    
    public void testGetSharpeRatio() {
    	Sharpe sharpe = new Sharpe();
    	
    	double [] returns2 = { 0.0164 , 0.0585, 0.0922, 0.0351, -0.0088, 0.0107, 0.1303, 0.094, 0.1049, -0.0508 };
    	assertEquals( sharpe.getSharpeRatio(returns2, 0.05), 2.6568000353699786 );
    	
    	double [] returns4 = { 0.054, 0.0086, -0.0846, 0.1040, 0.013, 0.0037, 0.0078, 0.0116, 0.00923, 0.0112, 0.0187, 0.0061 };
    	assertEquals( sharpe.getSharpeRatio(returns4, 0.0035), 1.0898282924873377 );
    	
    	
    	
    	
    	
    	
    	
    }
}
