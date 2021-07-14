package games;

import fixtures.Room;

public class RoomManager {
	
	private Room[] rooms;
	private Room startingRoom;
	
	public void init() {
		
		Room foyer = new Room("Foyer","first room to enter house", "The small entryway of a neo-colonial house");
		//TODO: should add exits 
		
		//add more rooms
		
		this.startingRoom = foyer;

	}

	public Room[] getRooms() {
		return rooms;
	}

	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}

	public Room getStartingRoom() {
		return startingRoom;
	}

	public void setStartingRoom(Room startingRoom) {
		this.startingRoom = startingRoom;
	}
	
}
