package io.javabrains.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopic() {
		return Arrays.asList(
				new Topic("001","Spring","This is spring"),
				new Topic("002","Summer","This is summner"),
				new Topic("003","Autumn","This is autumn"),
				new Topic("004","Winter","This is winter")
				);
	}
	
}
