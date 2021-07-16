package manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import pojo.Event;
import pojo.Group;
import pojo.Member;

public class ScoreManager {
	
	private List<Event> events = new ArrayList<Event>();

	public void addScores(Event event){
		this.events.add(event);
	}
	
	public void getScoresByGroup(List<Group> groups, boolean sortDesc){
		//iterate for each group
		for(Group g : groups) {
			double groupScore = 0;
			//get score for members from each group and average it
			for(Member m : g.getMembers()) {
				
				double eventScore = 0;
				
				for(Event e : this.events) {
					Map<Member,Double> scores = e.getScores();
					if(scores.containsKey(m)) {
						Double score = scores.get(m);
						eventScore += score.doubleValue();
					}
				}
				
				double aveScore = eventScore / this.events.size();
				m.setScore(aveScore);
				
				groupScore += aveScore;
			}
			
			double groupAveScore = groupScore / g.getMembers().size();

			//set the score to the group
			g.setScore(groupAveScore);
		}
		
		
		Collections.sort(groups, new Comparator<Group>() {

			@Override
			public int compare(Group o1, Group o2) {
				int value = o1.getScore() > o2.getScore() ? 1 : (o1.getScore() == o2.getScore() ? 0 : -1);
				return sortDesc ? -1 * value : value;
			}
			
		});
	}
}


