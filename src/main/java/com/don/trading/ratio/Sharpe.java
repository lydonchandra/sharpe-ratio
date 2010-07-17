package com.don.trading.ratio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
		String filename = "src/main/resources/log4j.properties";
		InputStream is = new FileInputStream(filename);
		prop.load(is);
		PropertyConfigurator.configure(prop);
	}
	
	private final static Logger logger = LoggerFactory.getLogger(Sharpe.class);
	
	public BigDecimal getSharpeRatio(BigDecimal annualTradingReturn, BigDecimal riskFreeRate, BigDecimal tradingReturnDeviation ) {
		BigDecimal sharpeRatio = annualTradingReturn.subtract(riskFreeRate).divide(tradingReturnDeviation);
		return sharpeRatio;
	}
	
	public double getSharpeRatio(double [] returns, double riskFreeReturn) {
		DescriptiveStatistics stats = new DescriptiveStatistics();
    	for( double item : returns) {
    		stats.addValue(item);
    	}

    	double mean = stats.getMean();
    	double annualizedMean = mean * 12;

    	logger.info("mean={}", mean);
    	logger.info("mean=" + mean);
    	logger.info("annualMean=" + annualizedMean);
    	
    	double std = stats.getStandardDeviation();
    	double annualizedStd = std * Math.sqrt(12);
    	
    	logger.info("std=" + std);
    	logger.info("annualStd=" + annualizedStd );

    	double sharpeRatio = 0.0;
    	sharpeRatio = (annualizedMean - (riskFreeReturn) ) / annualizedStd; // *  unbiasedFactor;
    	
    	logger.info("sharpeRatio="+ sharpeRatio);
    	
    	logger.info("");
    	return sharpeRatio;

	}
}
