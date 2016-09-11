/**
 * 
 */
package siit.homework5;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import siit.homework5.Distance;
import siit.homework5.MetricDistanceCalculator;
import siit.homework5.UnknownDistanceFormatException;

/**
 * @author SN
 *
 */
public class MetricDistanceCalculatorIntegrationTest {

	/**
	 * 
	 * @throws UnknownDistanceFormatException
	 */
	@Test
	public void metricDistanceCalculatorWorksWithCorrectInputReturnMeters() throws UnknownDistanceFormatException{
		//given
		String s = "1km - 750m + 0.5miles + 25cm - 2mm";
		MetricDistanceCalculator calc = new MetricDistanceCalculator();
		
		//when
		Distance result = calc.computeDistance(s, Distance.METERS);
		
		//then
		Distance expected = new Distance(Distance.METERS, 1054.9180000000001);
		assertEquals(expected, result);
	}	
	
	/**
	 * The digits after "." are trunked. So test should fail
	 * @throws UnknownDistanceFormatException
	 */
	@Test
	public void metricDistanceCalculatorFailsWithCorrectInput() throws UnknownDistanceFormatException{
		//given
		String s = "1km - 750m + 0.5miles + 25cm - 2mm";
		MetricDistanceCalculator calc = new MetricDistanceCalculator();
		
		//when
		Distance result = calc.computeDistance(s, Distance.METERS);
		
		//then
		Distance expected = new Distance(Distance.METERS, 1054);
		Assert.assertFalse(expected == result);
	}
	
	/**
	 * 
	 * @throws UnknownDistanceFormatException
	 */
	@Test
	public void metricDistanceCalculatorWorksWithCorrectInputReturnMiles() throws UnknownDistanceFormatException{
		//given
		String s = "1km - 750m + 0.5miles + 25cm - 2mm";
		MetricDistanceCalculator calc = new MetricDistanceCalculator();
		
		//when
		Distance result = calc.computeDistance(s, Distance.MILES);
		
		//then
		Distance expected = new Distance(Distance.MILES, 0.6554954525780001);
		assertEquals(expected, result);
	}	
	
	/**
	 * 
	 * @throws UnknownDistanceFormatException
	 */
	@Test
	public void metricDistanceCalculatorWorksWithCorrectInputReturnFoot() throws UnknownDistanceFormatException{
		//given
		String s = "1km - 750m + 0.5miles + 25cm - 2mm";
		MetricDistanceCalculator calc = new MetricDistanceCalculator();
		
		//when
		Distance result = calc.computeDistance(s, Distance.FOOT);
		
		//then
		Distance expected = new Distance(Distance.FOOT, 3461.0171711200005);
		assertEquals(expected, result);
	}	
	
	/**
	 * 
	 * @throws UnknownDistanceFormatException
	 */
	@Test
	public void metricDistanceCalculatorWorksWithCorrectInputReturnInch() throws UnknownDistanceFormatException{
		//given
		String s = "1km - 750m + 0.5miles + 25cm - 2mm";
		MetricDistanceCalculator calc = new MetricDistanceCalculator();
		
		//when
		Distance result = calc.computeDistance(s, Distance.INCH);
		
		//then
		Distance expected = new Distance(Distance.INCH, 41532.227151800005);
		assertEquals(expected, result);
	}	
	
	/**
	 * Test Exception for wrong input data.
	 * @throws UnknownDistanceFormatException
	 */
	@Test(expected=UnknownDistanceFormatException.class)
	public void metricDistanceCalculatorFailsIncorectInput() throws UnknownDistanceFormatException{
		//given
		String s = "1km - 750m + 0.5mi + 25cm - 2mm"; //miles != mi
		MetricDistanceCalculator calc = new MetricDistanceCalculator();
		//when
		calc.computeDistance(s, Distance.METERS);
		//then -> throw Exception
	}
	
	/**
	 * Test Exception for forgotten operator
	 * @throws UnknownDistanceFormatException
	 */
	@Test(expected=UnknownDistanceFormatException.class)
	public void metricDistanceCalculatorFailsIncorectInput2() throws UnknownDistanceFormatException{
		//given
		String s = "1km  2mm"; //no operator
		MetricDistanceCalculator calc = new MetricDistanceCalculator();
		//when
		calc.computeDistance(s, Distance.KILO_METERS);
		//then -> throw Exception
	}
}
