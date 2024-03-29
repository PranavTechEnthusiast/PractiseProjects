package com.newbieApps.bootpractise.service;

import com.newbieApps.bootpractise.model.Topic;
import com.newbieApps.bootpractise.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("Spring","Spring Framework", "Spring frame description"),
                new Topic("Java","Java", "Java description"),
                new Topic("Javascript","Javascript ", " Javascript description")));

    public List<Topic> getAllTopics(){
        //return topics;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id){
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id).get();
    }

    public void addTopic(Topic topic){
        //topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic){
        /*for (int i =0; i<topics.size(); i++){
            if(topics.get(i).getId().equals(id)){
                topics.set(i,topic);
                return;
            }
        }*/
        topicRepository.save(topic);
    }

    public void deleteTopic(String id){
        //topics.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
