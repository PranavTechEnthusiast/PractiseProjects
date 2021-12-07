package com.newbieApps.bootpractise.repository;

import com.newbieApps.bootpractise.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.newbieApps.bootpractise.model.Topic;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course,String> {
    public List<Course> findByTopicId(String topicId);
}
