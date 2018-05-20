package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepo;
	
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("001","Spring","This is spring"),
			new Topic("002","Summer","This is summner"),
			new Topic("003","Autumn","This is autumn"),
			new Topic("004","Winter","This is winter")
			));
	
	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepo.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<Topic> getTopic(String id) {
		//return topics.stream().filter(t -> t.getName().equals(id)).findFirst().get();
		return topicRepo.findById(id);
	}
	
	public void addTopic(Topic topic){
		//topics.add(topic);
		topicRepo.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		/*for(int i=0;i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getName().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}*/
		
		topicRepo.save(topic);
	}

	public String deleteTopic(String id) {
		//topics.removeIf(t->t.getName().equals(id));
		/*System.out.println(id);
		for(int i=0;i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getName().equals(id)) {
				topics.remove(i);
				return "Deleted";
			}
			
		}
		return "Not deleted";*/
		
		topicRepo.deleteById(id);
		return "success";
	}
	
	
	
}
