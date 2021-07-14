package games;

import java.util.Scanner;

import fixtures.Room;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in).useDelimiter("\\n");
		//get player
		System.out.print("Enter Player Name:");
		String name = in.next();
		
		//print starting room info
		Player player = new Player(name);
		
		RoomManager rm = new RoomManager();
		rm.init();
				
		
		player.setCurrentRoom(rm.getStartingRoom());
		printRoom(player);
				
		
		while(player.getCurrentRoom().hasExists()) {
			String[] command = collectInput(in);
			parse(command,player);
		}
		
		in.close();
	}
	
	private static String[] collectInput(Scanner in) {
		String input = in.next(); // "go east"
		String[] command = input.split(" "); //TODO: should fetch from user
		return command;
	}
	
	private static void printRoom(Player p) {
		Room room = p.getCurrentRoom();
		System.out.println("You are in "+room.getName()+" room now.");
		System.out.println(room.getLongDescription());
		System.out.println();
		
		if(room.hasExists()) {
			Room[] exits = room.getExits();
			for(int i = 0; i < exits.length; i++) {
				
				String direction = switch (i) {
					case 0: {
						yield "north";
					}
					case 1: {
						yield "east";
					}
					case 2: {
						yield "south";
					}
					case 3: {
						yield "west";
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + i);
					};
					
				if(exits[i] != null) {
					System.out.println(direction+": "+exits[i].getShortDescription());
				}
			}
		}
		
	}
	
	private static void parse(String[] command, Player player) throws Exception {
		if (command[0].equals("go")) {
			Room[] exits = player.getCurrentRoom().getExits();
			Room nextRoom = null;
			
			switch (command[1]) {
			case "east":
				nextRoom = exits[1];
				break;
			case "west":
				nextRoom = exits[3];
				break;
			default:
				break;
			}
			
			player.setCurrentRoom(nextRoom);
		}
		else {
			throw new Exception("Invalid command");
		}
		
		printRoom(player);
	}

}
