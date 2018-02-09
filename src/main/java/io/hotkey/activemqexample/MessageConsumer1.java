package io.hotkey.activemqexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageConsumer1 {

   @JmsListener(destination = "${event.topic.name}")
   public void receiveFromTopic(String text) {
      log.info("Consumer1 received msg: {}", text);
   }
}
