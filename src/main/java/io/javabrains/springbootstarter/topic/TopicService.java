package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("001","Spring","This is spring"),
			new Topic("002","Summer","This is summner"),
			new Topic("003","Autumn","This is autumn"),
			new Topic("004","Winter","This is winter")
			));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getName().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic){
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for(int i=0;i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getName().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public String deleteTopic(String id) {
		//topics.removeIf(t->t.getName().equals(id));
		System.out.println(id);
		for(int i=0;i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getName().equals(id)) {
				topics.remove(i);
				return "Deleted";
			}
			
		}
		return "Not deleted";
	}
	
	
	
}
