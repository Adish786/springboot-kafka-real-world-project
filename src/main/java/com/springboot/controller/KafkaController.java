package com.springboot.controller;

import com.springboot.producer.WikimediaChangesProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafkaaap")
public class KafkaController {

    @Autowired
    WikimediaChangesProducer producer;


}
