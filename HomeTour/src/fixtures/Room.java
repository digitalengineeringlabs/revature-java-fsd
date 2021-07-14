package fixtures;

public class Room extends Fixture {

	private Room[] exits;

	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
	}

	public Room[] getExits() {
		return exits;
	}

	public void setExits(Room[] exits) {
		this.exits = exits;
	}

	public Room getExit(String direction) {
		//TODO:
		return null;
	}
	
	public boolean hasExists() {
		return ! (this.exits == null || this.exits.length == 0);
	}
}
