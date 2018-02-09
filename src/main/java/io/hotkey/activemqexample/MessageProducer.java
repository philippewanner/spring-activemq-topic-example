package io.hotkey.activemqexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

@Component
@EnableScheduling
public class MessageProducer {

   private static Logger LOGGER = LoggerFactory.getLogger(MessageProducer.class);

   @Autowired
   private JmsMessagingTemplate jmsMessagingTemplate;

   @Autowired
   private Topic textTopic;

   @Scheduled(fixedRate = 2000L)
   public void scheduler() {
      final String msg = "A dummy message";
      sendText(msg);
      LOGGER.info("Message {} was sent to the topic: {}", msg);

   }

   public void sendText(String msg) {
      this.jmsMessagingTemplate.convertAndSend(textTopic, msg);
   }
}
