package io.javabrains.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId){
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public Course getCourse(String id){
        return courseRepository.findById(id).orElse(null);
    }

    public void updateCourse(String id, Course course) {
        courseRepository.save(course);
    }
    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
/* without JPA
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework","Spring Framework Description"),
            new Topic("java", "Core Java","Core Java Description"),
            new Topic("javascript", "JavaScript","JavaScript Description")
    ));

    public List<Topic> getAllTopics(){
        return topics;
    }
 public Topic getTopic(String id){
        return topics.stream().filter(t ->t.getId().equals(id)).findFirst().get();
    }


    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {
        for(int i=0;i< topics.size();i++){
            Topic t = topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }
    }


    public void deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
    }
*/


}
