package com.don.trading.ratio;

import org.apache.log4j.BasicConfigurator;

public class Compound {
	public Compound() {
		 BasicConfigurator.configure();
	}
	
	private final double VAMI = 1000.00;
	
	// cror compound rate or return
	// vami value add monthly index
	public final double getCror( final double[] vami) {
		final int N = vami.length;
		final double beginVami = VAMI;
		final double finalVami = vami[N-1];
		
		final double cror = Math.pow((finalVami/beginVami), (1.0/N) ) - 1;
		
		return cror;
	}
	
	public final double getAnnualCror( final double monthCror ) {
		
		return ( Math.pow( (1 + monthCror), 12) - 1  );
	}
}
