/**
 * 
 */
package siit.homework5;

/**
 * 
 * @author SN
 *
 */
public class MetricDistanceExpressionParser {

	private static final String MINUS = "-";
	private static final String PLUS = "\\+";

	/**
	 * Parses an input string of format "operand", "operator" and returns a Distance[] object with all operands and operators, 
	 * if the input String is of valid format. 
	 * @param expression the input String 
	 * @return Distance[] object that is parsed form the input string
	 * @throws UnknownDistanceFormatException
	 */
	public Distance [] parse(String expression) throws UnknownDistanceFormatException{
		// count the operands
		int operandCount = countSubStringOccurrences(expression, PLUS)+countSubStringOccurrences(expression, MINUS)+1;
		if (operandCount == 1){
			throw new UnknownDistanceFormatException("No operator detected in the expression!");
		}
		if(expression.startsWith("-")){
			operandCount--;
		}
		Distance Distances[] = new Distance[operandCount];
		int index = 0;
		expression = expression.trim().replaceAll(" ", "").replaceAll("\t", "").replaceAll("\n", "");
		while(expression.length()>0){
			int sign = 1;
			if(expression.startsWith(MINUS)){
				expression = expression.replaceFirst(MINUS, "");
				sign = -1;
			} else if (expression.startsWith("+")){
				expression = expression.replaceFirst(PLUS, "");
			}
			int nextOpPos = nextOperatorPos(expression);
			String operand = null;
			if(nextOpPos==-1){// last operand
				operand = expression;
			} else {
				operand = expression.substring(0, nextOpPos);
			}
			expression = expression.replaceFirst(operand, "");
			Distances[index++] = convertToDistance(operand, sign);
		}
		return Distances;
	}
	
	/**
	 * Check's a string for the location of +/- sign
	 * @param expression the input string
	 * @return position of the first sign (+/-)
	 */
	int nextOperatorPos(String expression) {
		int plusPos = expression.indexOf("+");
		int minusPos = expression.indexOf("-");
		if(plusPos==-1){
			return minusPos;
		}
		if(minusPos==-1){
			return plusPos;
		}
		return plusPos<minusPos?plusPos:minusPos;
	}

	/**
	 * Identifies the measuring unit from a given string and returns a Distance object
	 * @param e string to be converted into a Distance object
	 * @param sign +/- sign of the numerical value inside the string
	 * @return Distance object
	 * @throws UnknownDistanceFormatException
	 */
	private Distance convertToDistance(String e, int sign) throws UnknownDistanceFormatException {
		if(e.endsWith(Distance.MILI_METERS)){
			return convertToDistance(e, sign, Distance.MILI_METERS);
		} else if (e.endsWith(Distance.CENTI_METERS)){
			return convertToDistance(e, sign, Distance.CENTI_METERS);
		} else if(e.endsWith(Distance.DECI_METERS)){
			return convertToDistance(e, sign, Distance.DECI_METERS);
		}else if(e.endsWith(Distance.DECI_METERS)){
			return convertToDistance(e, sign, Distance.DECI_METERS);
		}else if(e.endsWith(Distance.KILO_METERS)){
			return convertToDistance(e, sign, Distance.KILO_METERS);
		}else if(e.endsWith(Distance.INCH)){
			return convertToDistance(e, sign, Distance.INCH);
		}else if(e.endsWith(Distance.FOOT)){
			return convertToDistance(e, sign, Distance.FOOT);
		}else if(e.endsWith(Distance.MILES)){
			return convertToDistance(e, sign, Distance.MILES);
		}else if(e.endsWith(Distance.METERS)){
			return convertToDistance(e, sign, Distance.METERS);
		}
		throw new UnknownDistanceFormatException("Can not parse ["+e+"] as a valid Distance.");
	}
	
	/**
	 * 
	 * @param e distance format(measuring units)
	 * @param sign +/-
	 * @param DistanceFormat measuring units
	 * @return Distance object
	 */
	private Distance convertToDistance(String e, int sign, String DistanceFormat){
		return new Distance(DistanceFormat, sign * Double.parseDouble(e.replace(DistanceFormat, "")));
	}

	/**
	 * Returns the number of characters of type "sub"
	 * @param s the string to be checked
	 * @param sub the string to be found in "s" string
	 * @return the number of occurrences of "sub" in "s"
	 */
	private int countSubStringOccurrences(String s, String sub){
		return s.length() - s.replaceAll(sub, "").length();
	}

	
}
