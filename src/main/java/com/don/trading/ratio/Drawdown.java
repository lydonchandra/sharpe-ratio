package com.don.trading.ratio;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;

public class Drawdown {
	public Drawdown() {
		BasicConfigurator.configure();
	}
	
	public double getMaxDrawdown(final double[] returns) {
		
		double prev = 0.0;
		
		boolean losing = false;
		List<Double> topVami = new ArrayList<Double>();
		List<Double> bottomVami = new ArrayList<Double>();
		for( double ret: returns ) {

			if( ret < prev ) {
				
				// losing money this month
				if( losing == false ) {
					
					losing = true;
					// prev month top vami, first month we're losing money this month
					topVami.add(prev);			
					
				} else { // losing == true
					
					// do nothing
					// still losing money this month
					
				}
			
			} else { // ret > prev
				
				if( losing == true ) {
					// stop losing money, prev month is bottom vami
					
					losing = false;
					
					bottomVami.add(prev);
					
				} else { // losing == false
					
					// no drawdown, profit this month
					
				}
				
			}

			prev = ret;
		}
		
		// we can have a top vami only (no bottom vami) as trader keeps losing, max drawdown will be NaN
		int idx = 0;
		Double maxDraw = Double.NaN;
		for( double top : topVami ) {
			
			try {

				double bottom = bottomVami.get(idx);
				
				double tempDraw = ( bottom - top ) / top;
				
				if( maxDraw.equals(Double.NaN) ) {
					maxDraw = tempDraw;
				} else {
					maxDraw = (tempDraw < maxDraw) ? tempDraw : maxDraw;
				}
				
			} catch( Exception e ) {
				
			}
			
			idx++;
		}
		
		return maxDraw;
	}
	
	
	
}
