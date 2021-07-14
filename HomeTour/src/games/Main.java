package games;

import java.util.Scanner;

import fixtures.Room;

public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//get player
		System.out.print("Enter Player Name:");
		String name = in.next();
		//print starting room info
		Player player = new Player(name);
		RoomManager rm = new RoomManager();
		rm.init();
		
		player.setCurrentRoom(rm.getStartingRoom());
		printRoom(player);
		
		boolean quit = false;
		while(player.getCurrentRoom().hasExists() || !quit) {
			String[] command = collectInput(in);
			if(command[0].equals("quit")) {
				quit = true;
				System.out.println("Tour Over!!!");
				continue;
			}
			
			parse(command, player);
		}
		
		in.close();
	}
	
	private static String[] collectInput(Scanner in) {
		String[] command = {"quit"}; //TODO: should fetch from user
		return command;
	}
	
	private static void printRoom(Player p) {
		Room room = p.getCurrentRoom();
		System.out.println("You are in "+room.getName()+" room now.");
		System.out.println(room.getLongDescription());
		System.out.println();
		Room[] exits = room.getExits();
		if(exits != null) {
			for(int i = 0; i < exits.length; i++) {
				String direction = switch (i) {
					case 0: {
						yield "north";
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + i);
					};
				System.out.println(direction+": "+exits[i].getShortDescription());
			}
		}
		
	}
	
	private static void parse(String[] input, Player p) {
		
	}

}
