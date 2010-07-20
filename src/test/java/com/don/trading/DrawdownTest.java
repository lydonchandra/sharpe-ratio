package com.don.trading;

import java.io.IOException;
import java.text.DecimalFormat;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.don.trading.ratio.Drawdown;

public class DrawdownTest 
    extends TestCase
{
	private final static Logger LOGGER = LoggerFactory.getLogger(DrawdownTest.class);

    @org.junit.Test
    public void testGetMaxDrawdown() throws IOException {
    	final double[] vami = { 1624, 1675, 1830, 1844, 1521, 1366, 1307, 1141, 955, 976, 901, 889, 697, 842, 961, 975 };
    	Drawdown drawdown = new Drawdown();
    	double maxDrawDown = drawdown.getMaxDrawdown(vami);
    	LOGGER.info("Max drawdown = {}", maxDrawDown);
    	
    	DecimalFormat fiveDec = new DecimalFormat("#.#####");
    	double roundedDraw = Double.valueOf(fiveDec.format(maxDrawDown));
    	assertEquals( roundedDraw, -0.48210 );
    }
}
