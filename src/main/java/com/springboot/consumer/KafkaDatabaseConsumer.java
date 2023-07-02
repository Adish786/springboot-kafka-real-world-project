package com.springboot.consumer;

import com.springboot.repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private WikimediaRepository wikimediaRepository;

    public KafkaDatabaseConsumer(WikimediaRepository wikimediaRepository) {
        this.wikimediaRepository = wikimediaRepository;
    }

    @KafkaListener(topics = "wikimedia_recentchange", groupId = "myGroup")
    public void consumerFromTopic(String eventMessage) {
        LOGGER.info(String.format("Event Message received -> %s", eventMessage));
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        wikimediaRepository.save(wikimediaData);

    }

}
