package view;

public interface IView {

	public void welcomeMessage();

	public MainMenuOptions mainMenu();

	public ChangeMemberOptions changeMember();

	public void listMembers();

	public void listMembersBoats(int memberIndex);

	public void compactListView();

	public void verboseListView();

	public void addName();

	public void changeName();

	public void addPersonNum();

	public double addBoatLength();

	public void deletedBoat(boolean deletedBoat);

	public void changeBoat();

	public void changeTheBoat(String whatToChange);

	public void changeBoatTypeLength();

	public void boatUpdated(boolean updated);

	// public void correctBoatInfo(String typeOfBoat, double lengthOfBoat);

	public void memberSaved();

	public void memberDeleted();

	public String typeOfBoat();

	public void selectID();

	public void selectBoatToDelete();

	public void noChanges();

	public void noUser();

	public void wrongFormat();

	public void userExist();

}
