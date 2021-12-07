package com.newbieApps.bootpractise.repository;

import com.newbieApps.bootpractise.model.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends CrudRepository<Topic,String> {
}
