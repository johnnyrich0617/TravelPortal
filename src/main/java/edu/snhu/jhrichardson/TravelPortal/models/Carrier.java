/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.models;

/**
 * @author john.richardson3
 *
 */
public enum Carrier {

	AMERICAN("American"),
	UNITED("United"),
	SOUTHWEST("SouthWest"),
	JETBLUE("JetBlue");
	
	public static final Carrier[] ALL = { AMERICAN, UNITED, SOUTHWEST, JETBLUE };
	
	private final String name;
	
	public static Carrier forName(final String name) {

        if (name == null) {

            throw new IllegalArgumentException("Name cannot be null for type");

        }
        
        switch(name.toUpperCase()) {
        case "AMERICAN":
        	return AMERICAN;
        case "UNITED":
        	return UNITED;
        case "SOUTHWEST":
        	return SOUTHWEST;
        case "JETBLUE":
        	return JETBLUE;
        default :
        	throw new IllegalArgumentException("Name \"" + name + "\" does not correspond to any Type");
        
        }
    }
	
	private Carrier(final String name) {
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
