package view;

import model.BoatLength;
import model.BoatTypes;

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

	public long addPersonNum();

	public BoatLength getBoatLength();

	public void deletedBoat(boolean deletedBoat);

	public int changeBoat();

	public void changeTheBoat(String whatToChange);

	public BoatTypes changeBoatType();

	public BoatLength changeBoatLength();

	public void boatUpdated(boolean updated);

	public void memberSaved();

	public void memberDeleted();

	public void boatAdded();

	public BoatTypes getBoatType();

	public int selectID();

	public int selectBoatToDelete();

	public void noChanges();

	public void noUser();

	public void wrongFormat();

	public void userExist();

}
