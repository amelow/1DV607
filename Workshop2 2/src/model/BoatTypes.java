package model;

public enum BoatTypes {
	Sailboat, Motorsailer, Kayak, Canoe, Other;

	/*
	 * A static class that checks if the user chose a boattype and if not correct
	 * spelling/ no real boat type it changes the input to Other
	 */
	public static BoatTypes getBoatType(String type) {
		BoatTypes[] types = BoatTypes.values();
		BoatTypes returnType = Other;
		for (int i = 0; i < types.length; i++) {
			if (type.equalsIgnoreCase("canoe")) {
				returnType = Canoe;
			} else if (type.equalsIgnoreCase("sailboat")) {
				returnType = Sailboat;
			} else if (type.equalsIgnoreCase("motorsailer")) {
				returnType = Motorsailer;
			} else if (type.equalsIgnoreCase("kayak")) {
				returnType = Kayak;
			} else {
				returnType = Other;
			}
		}

		return returnType;
	}
}