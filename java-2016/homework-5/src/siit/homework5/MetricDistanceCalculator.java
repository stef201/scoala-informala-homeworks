/**
 * 
 */
package siit.homework5;

/**
 * Represents the calculated distance of the request
 * @author SN
 *
 */
public class MetricDistanceCalculator {
	private MetricDistanceExpressionParser parser;
	private MetricDistanceConverter converter;
	public MetricDistanceCalculator() {
		this(new MetricDistanceExpressionParser(), new MetricDistanceConverter());
	}
	
	/**
	 * Creates a new calculator for distance with a parser and a converter
	 * @param parser object of type {@link MetricDistanceExpressionParser}
	 * @param converter object of type {@link MetricDistanceConverter}
	 */
	MetricDistanceCalculator(MetricDistanceExpressionParser parser, MetricDistanceConverter converter) {
		this.parser = parser;
		this.converter = converter;
	}

	/**
	 * The computeDistance method works like this: converts from any unit(mm, cm, dm, km, inch, foot, miles) to meters.
	 * Addition all "m" converted values. And then it does the conversion from "m" to the requested unit.
	 * 
	 * @param expression to be computed
	 * @param resultDistanceFormat the measure units to be converted in
	 * @return Distance object that contains the measuring units requested and the sum of all parameters given.
	 * @throws UnknownDistanceFormatException
	 */
	public Distance computeDistance(String expression, String resultDistanceFormat) throws UnknownDistanceFormatException{
		Distance[] Distances = parser.parse(expression);
		Distance resultM = new Distance("m", 0);
		for(Distance Distance :  Distances){
			Distance convertedM = converter.convert(Distance, "m");
			resultM.add(convertedM.getValue());
		}
		Distance converted = converter.convert(resultM, resultDistanceFormat);
		Distance result = new Distance(resultDistanceFormat, converted.getValue());
		return result;
	}

}
