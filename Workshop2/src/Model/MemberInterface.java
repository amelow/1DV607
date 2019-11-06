package Model;

/*The member interface class, 
 *used to add methods in the memberclass
 */
public interface MemberInterface {
	// Getters and setters for the member info
	public void setName(String name);

	public String getName();

	public void setPersonNum(String personNum);

	public String getPersonNum();

//	public void setID(int memberID);
//
	public int getID();

	// A getter and a Setter for the amount of boats the member has
	public int getAmountOfBoats();

}
