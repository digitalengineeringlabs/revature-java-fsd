package games;

import fixtures.Room;

public class Player {
	
	private String name;
	private Room currentRoom;

	public Player(String name) {
		super();
		this.name = name;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
