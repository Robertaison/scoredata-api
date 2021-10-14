package com.dataprovider.scoredataapi.listener;

import com.dataprovider.scoredataapi.model.dto.ScoreDataDto;
import com.dataprovider.scoredataapi.service.ScoreDataService;
import com.dataprovider.scoredataapi.util.ObjectConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ScoreDataListener {

  @Autowired
  private ScoreDataService service;

  @Autowired
  private ObjectConverter converter;

  @RabbitListener(queues = "score-data-queue")
  public void scoreDataQueueListener(@Payload String payload){
    log.info("M=scoreDataQueueListener, payload={}", payload);
    ScoreDataDto dto = converter.toObject(payload, ScoreDataDto.class);

    service.saveUpdateDataFromCustomer(dto);
  }
}
