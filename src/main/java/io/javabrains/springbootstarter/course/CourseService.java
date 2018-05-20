package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepo;
	
	
	/*private List<Course> topics = new ArrayList<>(Arrays.asList(
			new Course("001","Spring","This is spring"),
			new Course("002","Summer","This is summner"),
			new Course("003","Autumn","This is autumn"),
			new Course("004","Winter","This is winter")
			));*/
	
	public List<Course> getAllCourse(String topicId){
		//return topics;
		List<Course> courses = new ArrayList<>();
	
		courseRepo.findByTopicId(topicId).forEach(courses::add);
		/*for (Course course : courses) {
			if(course.getTopic().getId() != topicId)
				courses.remove(course);
		}*/
		return courses;
	}
	
	public Optional<Course> getCourse(String id) {
		//return topics.stream().filter(t -> t.getName().equals(id)).findFirst().get();
		return courseRepo.findById(id);
	}
	
	public void addCourse(Course course){
		//topics.add(topic);
		courseRepo.save(course);
	}

	public void updateCourse(String id, Course course) {
		/*for(int i=0;i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getName().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}*/
		
		courseRepo.save(course);
	}

	public String deleteCourse(String id) {
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
		
		courseRepo.deleteById(id);
		return "success";
	}
	
	
	
}
