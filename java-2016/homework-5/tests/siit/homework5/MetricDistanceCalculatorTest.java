/**
 * 
 */
package siit.homework5;

import static org.junit.Assert.*;
import org.junit.Test;

import siit.homework5.Distance;
import siit.homework5.MetricDistanceCalculator;
import siit.homework5.MetricDistanceConverter;
import siit.homework5.MetricDistanceExpressionParser;
import siit.homework5.UnknownDistanceFormatException;

/**
 * @author SN
 *
 */
public class MetricDistanceCalculatorTest {

	@Test
	public void returnMetersExpressionIsCalculated() throws UnknownDistanceFormatException{
		// given
		MetricDistanceExpressionParser mockParser = new MetricDistanceExpressionParser(){
			@Override
			public Distance[] parse(String expression) throws UnknownDistanceFormatException {
				return new Distance[]{new Distance(Distance.KILO_METERS, 1), new Distance(Distance.METERS, 1)};
			}	
		};
		MetricDistanceConverter mockConverter = new MetricDistanceConverter(){
			@Override
			public Distance convert(Distance Distance, String toFormat) throws UnknownDistanceFormatException {
				if(Distance.getFormatName().equals(Distance.KILO_METERS)){
					return new Distance(Distance.METERS, 1000);
				} else {
					return Distance;
				}
			}
		};
		MetricDistanceCalculator calc = new MetricDistanceCalculator(mockParser, mockConverter);
		
		// when
		Distance actual = calc.computeDistance("1km+1m", Distance.METERS);
		
		// then
		Distance expected = new Distance(Distance.METERS, 1001);
		assertEquals(expected, actual);
	}

	@Test
	public void returnMetersExpressionIsCalculated2() throws UnknownDistanceFormatException{
		// given
		MetricDistanceExpressionParser mockParser = new MetricDistanceExpressionParser(){
			@Override
			public Distance[] parse(String expression) throws UnknownDistanceFormatException {
				return new Distance[]{new Distance(Distance.MILES, 1), new Distance(Distance.FOOT, 100)};
			}	
		};
		MetricDistanceConverter mockConverter = new MetricDistanceConverter(){
			@Override
			public Distance convert(Distance Distance, String toFormat) throws UnknownDistanceFormatException {
				if(Distance.getFormatName().equals(Distance.MILES)){
					return new Distance(Distance.METERS, 1609.34);
				} else if(Distance.getFormatName().equals(Distance.FOOT)){
					return new Distance(Distance.METERS, 30.48);
				} else{
					return Distance;
				}
			}
		};
		MetricDistanceCalculator calc = new MetricDistanceCalculator(mockParser, mockConverter);
		
		// when
		Distance actual = calc.computeDistance("1miles+100ft", Distance.METERS);
		
		// then
		Distance expected = new Distance(Distance.METERS, 1639.82);
		assertEquals(expected, actual);
	}
	
	@Test
	public void returnInchExpressionIsCalculated() throws UnknownDistanceFormatException{
		// given
		MetricDistanceExpressionParser mockParser = new MetricDistanceExpressionParser(){
			@Override
			public Distance[] parse(String expression) throws UnknownDistanceFormatException {
				return new Distance[]{new Distance(Distance.CENTI_METERS, 150), new Distance(Distance.INCH, 30)};
			}	
		};
		MetricDistanceConverter mockConverter = new MetricDistanceConverter(){
			@Override
			public Distance convert(Distance Distance, String toFormat) throws UnknownDistanceFormatException {
				if(Distance.getFormatName().equals(Distance.CENTI_METERS)){
					return new Distance(Distance.INCH, 59.0551);
				} else{
					return Distance;
				}
			}
		};
		MetricDistanceCalculator calc = new MetricDistanceCalculator(mockParser, mockConverter);
		
		// when
		Distance actual = calc.computeDistance("1miles+100ft", Distance.INCH);
		
		// then
		Distance expected = new Distance(Distance.INCH, 89.05510000000001);
		assertEquals(expected, actual);
	}
	
}
