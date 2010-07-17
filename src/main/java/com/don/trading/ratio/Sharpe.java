package com.don.trading.ratio;

import java.math.BigDecimal;

import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;

public class Sharpe {
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

    	System.out.println("mean=" + mean);
    	System.out.println("annualMean=" + annualizedMean);
    	
    	double std = stats.getStandardDeviation();
    	double annualizedStd = std * Math.sqrt(12);
    	
    	System.out.println("std=" + std);
    	System.out.println("annualStd=" + annualizedStd );

    	double sharpeRatio = 0.0;
    	sharpeRatio = (annualizedMean - (riskFreeReturn) ) / annualizedStd;
    	
    	
    	System.out.println("sharpeRatio="+ sharpeRatio);
    	
    	System.out.println("");
    	return sharpeRatio;

	}
}
