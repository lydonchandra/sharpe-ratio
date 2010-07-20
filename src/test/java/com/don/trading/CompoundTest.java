package com.don.trading;

import java.text.DecimalFormat;

import junit.framework.TestCase;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.don.trading.ratio.Compound;

public class CompoundTest 
    extends TestCase
{
	private final static Logger LOGGER = LoggerFactory.getLogger(CompoundTest.class);

    @org.junit.Test
    public void testGetCror() {
    	
    	Compound compound = new Compound();
    	
    	final double [] vami = { 1119, 1130, 1198, 1287, 1296, 1360, 1442, 1483, 1737, 1852, 1869, 2145 };
    	final double cror = compound.getCror(vami);
    	LOGGER.info("CROR = {}", cror);

    	DecimalFormat fiveDec = new DecimalFormat("#.#####");
    	final double roundCror = Double.valueOf(fiveDec.format(cror) );
    	LOGGER.info("roundCror = {}", roundCror);

    	assertEquals( roundCror, 0.06566);
    	
    	final double annualCror = compound.getAnnualCror(cror);
    	LOGGER.info("Annual cror = {}", annualCror);
    	final double roundAnnualCror = Double.valueOf( fiveDec.format(annualCror) );
    	assertEquals( roundAnnualCror, 1.14500);
    	
    }
    
    
}
