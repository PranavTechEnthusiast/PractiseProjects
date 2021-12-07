package com.newbieApps.bootpractise.service;

import java.util.ArrayList;
import java.util.List;

import com.newbieApps.bootpractise.model.Course;
import com.newbieApps.bootpractise.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newbieApps.bootpractise.model.Topic;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId){
        //return topics;
        List<Course> courses = new ArrayList<>();
        return courseRepository.findByTopicId(topicId);
    }

    public Course getCourse(String id){
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id).get();
    }

    public void addCourse(Course course){
        //topics.add(course);
        courseRepository.save(course);
    }

    public void updateCourse(String id, Course course){
        /*for (int i =0; i<topics.size(); i++){
            if(topics.get(i).getId().equals(id)){
                topics.set(i,course);
                return;
            }
        }*/
        courseRepository.save(course);
    }

    public void deleteCourse(String id){
        //topics.removeIf(t -> t.getId().equals(id));
        courseRepository.deleteById(id);
    }
}
