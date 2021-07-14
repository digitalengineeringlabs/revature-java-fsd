package games;

import fixtures.Room;

public class RoomManager {
	
	private Room[] rooms = new Room[2];
	private Room startingRoom;
	
	public void init() {
		
		Room foyer = new Room("Foyer","first room to enter house", "The small entryway of a neo-colonial house");
		Room hall = new Room("Hall","other room in the house", "gathering space");

		Room[] foyerExits = {null,hall,null,null};
		Room[] hallExits = {null,null,null,foyer};
		
		//TODO: should add exits 
		foyer.setExits(foyerExits);
		hall.setExits(hallExits);
		//add more rooms
		
		rooms[0] = foyer;
		rooms[1] = hall;
		
		
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
