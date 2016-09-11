/**
 * 
 */
package siit.homework5;

import static org.junit.Assert.*;
import org.junit.Test;

import siit.homework5.Distance;
import siit.homework5.MetricDistanceExpressionParser;
import siit.homework5.UnknownDistanceFormatException;

/**
 * @author stef
 *
 */
public class MetricDistanceExpressionParserTest {

	/**
	 * 
	 */
	@Test
	public void testOperator(){
		//given
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String test = "95miles-35m";
		//when
		int opPosition = parser.nextOperatorPos(test);
		//then
		assertEquals(opPosition, 7);
	}
	
	/**
	 * 
	 */
	@Test
	public void testOperatorFirstPosition(){
		//given
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String test = "+95miles-35m";
		//when
		int opPosition = parser.nextOperatorPos(test);
		//then
		assertEquals(opPosition, 0);
	}
	
	/**
	 * 
	 */
	@Test
	public void testOperatorNotFound(){
		//given
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String test = "95miles35m";
		//when
		int opPosition = parser.nextOperatorPos(test);
		//then
		assertEquals(-1, opPosition);
	}
	
	/**
	 * 
	 */
	@Test
	public void testOperatorFirstChoiceOutOfMultipleOperators(){
		//given
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String test = "5cm + 95miles-35m";
		//when
		int opPosition = parser.nextOperatorPos(test);
		//then
		assertEquals(opPosition, 4);
	}

	/**
	 * 
	 * @throws UnknownDistanceFormatException
	 */
	@Test
	public void testParserFormatIsCorrectParserWorksCorrect() throws UnknownDistanceFormatException{
		//given
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String test = "1km-50m";
		Distance[] expected = new Distance[] { new Distance(Distance.KILO_METERS, 1), new Distance(Distance.METERS, -50) };
		//when
		Distance[] actual = parser.parse(test);
		//then
		assertArrayEquals(expected, actual);	
	}
	
	/**
	 * 
	 * @throws UnknownDistanceFormatException
	 */
	@Test
	public void testParserFormatIsCorrectParserWorksCorrect2() throws UnknownDistanceFormatException{
		//given
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String test = "1km-50ft";
		Distance[] expected = new Distance[] { new Distance(Distance.KILO_METERS, 1), new Distance(Distance.FOOT, -50) };
		//when
		Distance[] actual = parser.parse(test);
		//then
		assertArrayEquals(expected, actual);	
	}
	
	/**
	 * 
	 * @throws UnknownDistanceFormatException
	 */
	@Test
	public void testParserFormatIsCorrectParserWorksCorrect3() throws UnknownDistanceFormatException{
		//given
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String test = "1miles+500inch";
		Distance[] expected = new Distance[] { new Distance(Distance.MILES, 1), new Distance(Distance.INCH, 500) };
		//when
		Distance[] actual = parser.parse(test);
		//then
		assertArrayEquals(expected, actual);	
	}
	
	/**
	 * 
	 * @throws UnknownDistanceFormatException
	 */
	@Test
	public void testParserFormatWithMultipleOperands() throws UnknownDistanceFormatException{
		//given
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String test = "1m + 10dm + 100cm + 1000mm";
		Distance[] expected = new Distance[] { new Distance(Distance.METERS, 1), new Distance(Distance.DECI_METERS, 10),
				new Distance(Distance.CENTI_METERS, 100),new Distance(Distance.MILI_METERS, 1000)};
		//when
		Distance[] actual = parser.parse(test);
		//then
		assertArrayEquals(expected, actual);	
	}
	
	/**
	 * 
	 * @throws UnknownDistanceFormatException
	 */
	@Test
	public void testParserFirstSignMinus() throws UnknownDistanceFormatException{
		//given
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String test = "-1km-50m";
		Distance[] expected = new Distance[] { new Distance(Distance.KILO_METERS, -1), new Distance(Distance.METERS, -50) };
		//when
		Distance[] actual = parser.parse(test);
		//then
		assertArrayEquals(expected, actual);	
	}
	
	/**
	 * 
	 * @throws UnknownDistanceFormatException
	 */
	@Test(expected=UnknownDistanceFormatException.class)
	public void testParserFormatNoOperator() throws UnknownDistanceFormatException{
		//given
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String test = "1km50m";
		//when
		parser.parse(test);	
		//then -> throws Exception 
	}
	
	/**
	 * 
	 * @throws UnknownDistanceFormatException
	 */
	@Test(expected=UnknownDistanceFormatException.class)
	public void testParserFormatNoOperator2() throws UnknownDistanceFormatException{
		//given
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String test = "1km";
		//when
		parser.parse(test);	
		//then -> throws Exception 
	}
	
	/**
	 * 
	 * @throws UnknownDistanceFormatException
	 */
	@Test(expected=UnknownDistanceFormatException.class)
	public void testParserFormatNotCorect() throws UnknownDistanceFormatException{
		//given
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String test = "1fts-50km";
		//when
		parser.parse(test);	
		//then -> throws Exception 
	}
	
	/**
	 * 
	 * @throws UnknownDistanceFormatException
	 */
	@Test(expected=UnknownDistanceFormatException.class)
	public void testParserFormatNotCorect2() throws UnknownDistanceFormatException{
		//given
		MetricDistanceExpressionParser parser = new MetricDistanceExpressionParser();
		String test = "1ft-50km+2mile";
		//when
		parser.parse(test);	
		//then -> throws Exception 
	}
	
}
