package com.don.trading.ratio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Properties;

import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sharpe {
	public Sharpe() throws IOException {
		// BasicConfigurator.configure();
		Properties prop = new Properties();
		final String filename = "src/main/resources/log4j.properties";
		final InputStream is = new FileInputStream(filename);
		prop.load(is);
		PropertyConfigurator.configure(prop);
		is.close();
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(Sharpe.class);

	public final BigDecimal getSharpeRatio( final BigDecimal yearTradingReturn, 
											final BigDecimal riskFreeRate, 
											final BigDecimal tradingReturnDeviat ) {
		final BigDecimal sharpeRatio = yearTradingReturn.subtract(riskFreeRate).divide(tradingReturnDeviat);
		return sharpeRatio;
	}

	public final double getSharpeRatio(final double [] returns, final double riskFreeReturn) {
		final DescriptiveStatistics stats = new DescriptiveStatistics();
        for(double item : returns) {
    		stats.addValue(item);
    	}
        
        final int MONTH_IN_YEAR = 12;
        
    	double mean = stats.getMean();
    	double annualizedMean = mean * MONTH_IN_YEAR;

    	LOGGER.info("mean={}", mean);
    	LOGGER.info("annualMean={}",annualizedMean);

    	double std = stats.getStandardDeviation();
    	double annualizedStd = std * Math.sqrt( MONTH_IN_YEAR );

    	LOGGER.info("std={}",std);
    	LOGGER.info("annualStd={}",annualizedStd );

    	double sharpeRatio = 0.0;
    	sharpeRatio = (annualizedMean - (riskFreeReturn) ) / annualizedStd; // *  unbiasedFactor;

    	LOGGER.info("sharpeRatio={}",sharpeRatio);

    	LOGGER.info("");
    	return sharpeRatio;

	}
}
