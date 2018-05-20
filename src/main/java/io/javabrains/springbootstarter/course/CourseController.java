package io.javabrains.springbootstarter.course;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourse(@PathVariable String topicId) {
		return courseService.getAllCourse(topicId);
	}
	
	/*
	 *In case variable name differs
	@RequestMapping("/topics/{foo}")
	public Topic getTopic(@PathVariable("foo") String id) {
		return courseService.getTopic(id);
	}*/
	
	@RequestMapping("/topics/{topicId}/course/{id}")
	public Optional<Course> getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/course")
	public void addCourse(@RequestBody Course course,@PathVariable String topicId){
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/course/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String id,@PathVariable String topicId){
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(id,course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/course/{id}")
	public String deleteTopic(@PathVariable String id) {
		return courseService.deleteCourse(id);
	}
}
