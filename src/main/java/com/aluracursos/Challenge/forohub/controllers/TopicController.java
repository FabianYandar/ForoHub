package com.aluracursos.Challenge.forohub.controllers;

import com.aluracursos.Challenge.forohub.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")

public class TopicController {
    @Autowired
    private TopicService topicService;

    @PostMapping("/create")
    public ResponseEntity<Topic> createTopic(@RequestBody TopicRequest topicRequest) {
        Topic topic = new Topic();
        topic.setIdUsuario(topicRequest.getIdUsuario());
        topic.setNombreCurso(topicRequest.getNombreCurso());
        topic.setMensaje(topicRequest.getMensaje());
        topic.setTitulo(topicRequest.getTitulo());
        return ResponseEntity.ok(topicService.saveTopic(topic));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Topic>> listTopics() {
        return ResponseEntity.ok(topicService.getAllTopics());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Long id, @RequestBody TopicRequest topicRequest) {
        Topic topicDetails = new Topic();
        topicDetails.setNombreCurso(topicRequest.getNombreCurso());
        topicDetails.setMensaje(topicRequest.getMensaje());
        topicDetails.setTitulo(topicRequest.getTitulo());
        return ResponseEntity.ok(topicService.updateTopic(id, topicDetails));
    }

}
