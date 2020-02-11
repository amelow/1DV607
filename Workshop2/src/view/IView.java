package view;

public interface IView {

	public void welcomeMessage();

	public MainMenuOptions mainMenu();

	public void addName();

	public void addPersonNum();

	public void changName();
	
	public void correctBoatInfo(String typeOfBoat, double lengthOfBoat);

	public void memberSaved();

	public void memberDeleted();

	public void deletedBoat(boolean deletedBoat);

	public void changeBoat();

	public String typeOfBoat();

	public void selectID();

	public void selectBoatToDelete();

	public ChangeMemberOptions changeMember();

	public void listMembers();

	public void noChanges();

	public void noUser();

	public void wrongFormat();

	public void userExist();

	public void listMembersBoats(int memberIndex);

	public void compactListView();

	public void verboseListView();

	public double addBoatLength();

	public void changeTheBoat(String whatToChange);

	public void changeBoatTypeLength();

	public void boatUpdated(boolean updated);
	
}
