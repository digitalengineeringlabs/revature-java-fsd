import java.util.ArrayList;
import java.util.List;

import manager.ScoreManager;
import pojo.Event;
import pojo.Group;
import pojo.Member;

public class Main {
	
	public static void main(String[] args) {
		
		//1. Configure Group & Member
		//A*A1|A2|A3#B*B1|B2|B3
		Group g1 = new Group("A");
		g1.addMember(new Member("A1"));
		g1.addMember(new Member("A2"));
		g1.addMember(new Member("A3"));
		Group g2 = new Group("B");
		g2.addMember(new Member("B1"));
		g2.addMember(new Member("B2"));
		g2.addMember(new Member("B3"));
		
		//2. Add scores of each member for a given event
		//Event1>A1*90|A2*56|...
		//Event2>A1*40|A2*56|...
		//Event3>A1*60|A2*56|...
		Event e1 = new Event("Event 1");
		e1.addScore(new Member("A1"), 16);
		e1.addScore(new Member("A2"), 30);
		e1.addScore(new Member("A3"), 45);
		e1.addScore(new Member("B1"), 96);
		e1.addScore(new Member("B2"), 80);
		e1.addScore(new Member("B3"), 45);
		Event e2 = new Event("Event 2");
		e2.addScore(new Member("A1"), 96);
		e2.addScore(new Member("A2"), 50);
		e2.addScore(new Member("A3"), 25);
		e2.addScore(new Member("B1"), 46);
		e2.addScore(new Member("B2"), 50);
		e2.addScore(new Member("B3"), 35);

		ScoreManager manager = new ScoreManager();
		manager.addScores(e1);
		manager.addScores(e2);


		//3. Show the groups with scores descending
		//A - 89
		//B - 86
		//C - 78		
		
		List<Group> groups = new ArrayList<Group>();
		groups.add(g1);
		groups.add(g2);
		
		manager.getScoresByGroup(groups, false);
		
		System.out.println(groups);
		for(Group g : groups) {
			System.out.println(g.getName()+" : "+g.getScore());
		}
	}

}
