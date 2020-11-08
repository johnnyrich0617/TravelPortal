/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.models;

/**
 * @author john.richardson3
 *
 */
public enum FlightType {
	DEPARTURE("Departure"),
	RETURN("Return");
	
	public static final FlightType[] ALL = { DEPARTURE, RETURN };
	
	private final String name;
	
	public static FlightType forName(final String name) {

        if (name == null) {

            throw new IllegalArgumentException("Name cannot be null for type");

        }
        
        switch(name.toUpperCase()) {
        case "DEPARTURE":
        	return DEPARTURE;
        case "RETURN":
        	return RETURN;
        default :
        	throw new IllegalArgumentException("Name \"" + name + "\" does not correspond to any Type");
        
        }
    }
	
	private FlightType(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
