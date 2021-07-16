package pojo;

import java.util.HashMap;
import java.util.Map;

public class Event {
	
	private String name;
	private Map<Member, Double> scores = new HashMap<Member, Double>();

	public Event(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Member, Double> getScores() {
		return scores;
	}

	public void setScores(Map<Member, Double> scores) {
		this.scores = scores;
	}
	
	public void addScore(Member member, double score) {
		this.scores.put(member,Double.valueOf(score));
	}
}
