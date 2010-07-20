package com.don.trading.ratio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sterling {
	public Sterling() throws IOException {
		// BasicConfigurator.configure();
		Properties prop = new Properties();
		final String filename = "src/main/resources/log4j.properties";
		final InputStream is = new FileInputStream(filename);
		prop.load(is);
		PropertyConfigurator.configure(prop);
		is.close();
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(Sterling.class);
	
	public final double getSterlingRatio( final double[] returns ) {
		Compound compound = new Compound();
		double cror = compound.getCror(returns);
		double annualCror = compound.getAnnualCror(cror);
		 
		
		
		return 0.0;
	}
	
	
	
}
