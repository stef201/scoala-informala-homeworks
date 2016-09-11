/**
 * 
 */
package siit.homework5;

import static org.junit.Assert.*;
import org.junit.Test;

import siit.homework5.Distance;
import siit.homework5.MetricDistanceConverter;
import siit.homework5.UnknownDistanceFormatException;


/**
 * @author SN
 *
 */
public class MetricDistanceConvertorTest {

	/**
	 * 
	 * @throws UnknownDistanceFormatException
	 */
	@Test
	public void miliMetersToMetersConvertion() throws UnknownDistanceFormatException{
		//given
		Distance mm1000 = new Distance(Distance.MILI_METERS, 1000);
		MetricDistanceConverter weightConverter = new MetricDistanceConverter();
		Distance result = weightConverter.convert(mm1000, Distance.METERS);
		//when
		Distance expected = new Distance(Distance.METERS, 1);
		//then
		assertEquals("Convertion from milimeters to meters is correct.", expected,  result);
	}
	
	/**
	 * 
	 * @throws UnknownDistanceFormatException
	 */
	@Test
	public void centiMetersToMetersConvertion() throws UnknownDistanceFormatException{
		//given
		Distance cm100 = new Distance(Distance.CENTI_METERS, 100);
		MetricDistanceConverter weightConverter = new MetricDistanceConverter();
		Distance result = weightConverter.convert(cm100, Distance.METERS);
		//when
		Distance expected = new Distance(Distance.METERS, 1);
		//then
		assertEquals("Convertion from centimeters to meters is correct.", expected,  result);
	}
	
	/**
	 * 
	 * @throws UnknownDistanceFormatException
	 */
	@Test
	public void deciMetersToMetersConvertion() throws UnknownDistanceFormatException{
		//given
		Distance dm10 = new Distance(Distance.DECI_METERS, 10);
		MetricDistanceConverter weightConverter = new MetricDistanceConverter();
		Distance result = weightConverter.convert(dm10, Distance.METERS);
		//when
		Distance expected = new Distance(Distance.METERS, 1);
		//then
		assertEquals("Convertion from decimeters to meters is correct.", expected,  result);
	}
	
	/**
	 * 
	 * @throws UnknownDistanceFormatException
	 */
	@Test
	public void kiloMetersToMetersConvertion() throws UnknownDistanceFormatException{
		//given
		Distance km = new Distance(Distance.KILO_METERS, 0.001);
		MetricDistanceConverter weightConverter = new MetricDistanceConverter();
		Distance result = weightConverter.convert(km, Distance.METERS);
		//when
		Distance expected = new Distance(Distance.METERS, 1);
		//then
		assertEquals("Convertion from kilometers to meters is correct.", expected,  result);
	}
	
	/**
	 * 
	 * @throws UnknownDistanceFormatException
	 */
	@Test
	public void inchToMetersConvertion() throws UnknownDistanceFormatException{
		//given
		Distance inch = new Distance(Distance.INCH, 100);
		MetricDistanceConverter weightConverter = new MetricDistanceConverter();
		Distance result = weightConverter.convert(inch, Distance.METERS);
		//when
		Distance expected = new Distance(Distance.METERS, 2.54);
		//then
		assertEquals("Convertion from inch to meters is correct.", expected,  result);
	}
	
	/**
	 * 
	 * @throws UnknownDistanceFormatException
	 */
	@Test
	public void footToMetersConvertion() throws UnknownDistanceFormatException{
		//given
		Distance foot = new Distance(Distance.FOOT, 100);
		MetricDistanceConverter weightConverter = new MetricDistanceConverter();
		Distance result = weightConverter.convert(foot, Distance.METERS);
		//when
		Distance expected = new Distance(Distance.METERS, 30.48);
		//then
		assertEquals("Convertion from foot to meters is correct.", expected,  result);
	}
	
	/**
	 * 
	 * @throws UnknownDistanceFormatException
	 */
	@Test
	public void milesToMetersConvertion() throws UnknownDistanceFormatException{
		//given
		Distance mile = new Distance(Distance.MILES, 1);
		MetricDistanceConverter converter = new MetricDistanceConverter();
		Distance result = converter.convert(mile, Distance.METERS);
		//when
		Distance expected = new Distance(Distance.METERS, 1609.34);
		//then
		assertEquals("Convertion from decimeters to meters is correct.", expected,  result);
	}
	
	/**
	 * 
	 * @throws UnknownDistanceFormatException
	 */
	@Test(expected = UnknownDistanceFormatException.class)
	public void failConversionForUnknownFormat() throws UnknownDistanceFormatException{
		//given
		Distance mile = new Distance(Distance.MILES, 1);
		MetricDistanceConverter metersConverter = new MetricDistanceConverter();
		//when
		metersConverter.convert(mile, "km");
		//then -> throws Exception
	}
}
