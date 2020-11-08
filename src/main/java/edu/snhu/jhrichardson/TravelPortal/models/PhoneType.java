/**
 * 
 */
package edu.snhu.jhrichardson.TravelPortal.models;

/**
 * @author john.richardson3
 *
 */
public enum PhoneType {
	CELL("CELL"),
	HOME("HOME"),
	WORK("WORK");
	
	
	public static final PhoneType[] ALL = { CELL, HOME, WORK };
	
	private final String name;
	
	public static PhoneType forName(final String name) {

        if (name == null) {

            throw new IllegalArgumentException("Name cannot be null for type");

        }
        
        switch(name.toUpperCase()) {
        case "CELL":
        	return CELL;
        case "HOME":
        	return HOME;
        case "WORK":
        	return WORK;
        default :
        	throw new IllegalArgumentException("Name \"" + name + "\" does not correspond to any Type");
        
        }
    }
	
	private PhoneType(final String name) {
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
