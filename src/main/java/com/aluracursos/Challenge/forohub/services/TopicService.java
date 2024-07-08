package com.aluracursos.Challenge.forohub.services;

import com.aluracursos.Challenge.forohub.models.Topic;
import com.aluracursos.Challenge.forohub.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }

    public Topic updateTopic(Long id, Topic topicDetails) {
        Topic topic = topicRepository.findById(id).orElseThrow(() -> new RuntimeException("Topic not found"));
        topic.setTitulo(topicDetails.getTitulo());
        topic.setMensaje(topicDetails.getMensaje());
        topic.setNombreCurso(topicDetails.getNombreCurso());
        return topicRepository.save(topic);
    }


}
