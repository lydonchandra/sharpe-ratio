package com.don.trading;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.don.trading.ratio.Sterling;

public class SterlingTest extends TestCase {
	private final static Logger LOGGER = LoggerFactory.getLogger(SharpeTest.class);
	
	@Test
	public void testGetSterlingRatio() throws IOException{
		final double [] returns = { 0.112, 0.149,-0.015, -0.051, 0.005, 0.097, -0.017, 0.059, 0.039, -0.005, 0.017, 0.033, 0.111, 0.052, 0.075 };
		final double [] vami =    { 1112, 1278, 1259, 1194, 1200, 1317, 1294, 1371, 1424, 1417, 1441, 1489, 1654, 1740, 1870 };
		
		final double [] vami2 = { 1119, 1130, 1198, 1287, 1296, 1360, 1442, 1483, 1737, 1852, 1869, 2145 };
		Sterling sterling = new Sterling();
		final double sterlingRatio = sterling.getSterlingRatio(returns);
		LOGGER.info("CROR={}", sterlingRatio);
	
	}
	
}
