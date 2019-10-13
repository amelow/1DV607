package Model;

/*
 * The Boat Interface class with all of its classes 
 */
public interface BoatInterface {

	public void setLength(double Length); // Setter for the boat length

	public double getLength(); // Getter for the boat length

	public void setType(BoatTypes Type); // Setter for the BoatTypes(enum class)

	public BoatTypes getType();// Getter for the BoatTypes(enum class)

}
