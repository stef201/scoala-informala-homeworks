/**
 * 
 */
package siit.homework5;

/**
 * Represents the rates of different measuring units and the conversion between them
 * @author SN
 *
 */
public class MetricDistanceConverter {
	

	/**
	 * Implemented conversions are from all requested units to meters("m") and from meters back to all units.
	 * It is done like this to reduce the Conversion[] parameters.
	 */
	private static final Convertion [] CONVERTIONS = new Convertion[]{
		new Convertion(Distance.MILI_METERS, Distance.METERS, 0.001),
		new Convertion(Distance.CENTI_METERS, Distance.METERS, 0.01),
		new Convertion(Distance.DECI_METERS, Distance.METERS, 0.1),
		new Convertion(Distance.KILO_METERS, Distance.METERS, 1000),
		new Convertion(Distance.INCH, Distance.METERS, 0.0254),
		new Convertion(Distance.FOOT, Distance.METERS, 0.3048),
		new Convertion(Distance.MILES, Distance.METERS, 1609.34),
		new Convertion(Distance.METERS, Distance.METERS, 1),
		new Convertion(Distance.METERS, Distance.MILI_METERS, 1000),
		new Convertion(Distance.METERS, Distance.CENTI_METERS, 100),
		new Convertion(Distance.METERS, Distance.DECI_METERS, 10),
		new Convertion(Distance.METERS, Distance.KILO_METERS, 0.001),
		new Convertion(Distance.METERS, Distance.INCH, 39.3701),
		new Convertion(Distance.METERS, Distance.FOOT, 3.28084),
		new Convertion(Distance.METERS, Distance.MILES, 0.000621371),
	};

	/**
	 * 
	 * @param Distance object to be converted
	 * @param toFormat format in witch the object to be returned
	 * @return a Distance object in the requested format and the value converted to the same format
	 * @throws UnknownDistanceFormatException
	 */
	public Distance convert(Distance Distance, String toFormat) throws UnknownDistanceFormatException{
		if(Distance.getFormatName().equals(toFormat)){
			return Distance;
		}
		Convertion convertion = null;
		for(Convertion c : CONVERTIONS){
			if(c.fromFormat.equals(Distance.getFormatName()) && c.toFormat.equals(toFormat)){
				convertion = c;
				break;
			}
		}
		if(convertion==null){
			throw new UnknownDistanceFormatException("No rate found for "+Distance.getFormatName()+" - "+toFormat);
		}
		return new Distance(toFormat, Distance.getValue()*convertion.rate);
	}
	
	/**
	 * Internal class that represents a conversion object that contains the format witch needs to be converted, 
	 * the format to be converted in and the rate of theese two
	 * @author SN
	 *
	 */
	private static class Convertion {
		double rate;
		String fromFormat;
		String toFormat;
		
		/**
		 * 
		 * @param fromFormat witch needs to be converted
		 * @param toFormat the format to be converted to
		 * @param rate the proportion of the first two parameters
		 */
		public Convertion(String fromFormat, String toFormat, double rate) {
			super();
			this.rate = rate;
			this.fromFormat = fromFormat;
			this.toFormat = toFormat;
		}
		
	}	

}
