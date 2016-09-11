/**
 * 
 */
package siit.homework5;

/**
 * @author SN
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws UnknownDistanceFormatException 
	 */
	
	public static void main(String[] args) throws UnknownDistanceFormatException {
		// mm, cm, dm, m, km, inch, ft, miles
		String s = "1km - 750m + 0.5miles + 25cm - 2mm";

		MetricDistanceCalculator calc = new MetricDistanceCalculator();
		System.out.println(calc.computeDistance(s, Distance.MILES));
	}

}
