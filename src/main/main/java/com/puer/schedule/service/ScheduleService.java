package com.puer.schedule.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class ScheduleService {
    private static String URL = "http://localhost:8081/puer/open/schedule/";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 每分钟执行一次，强行关闭没有关闭的订单
     */
    @Scheduled(cron = "0 */1 * * * ?")
    public void closeFittingOrder() {
        try {
            log.info("closeFittingOrder start");
            restTemplate.postForObject(URL + "closeFittingOrder",
                    new HttpEntity(new HashMap<>(), new HttpHeaders()),
                    Map.class);
            log.info("closeFittingOrder end");
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }

    }

    /**
     * 每分钟执行一次，满6小时未结算的订单做一次推送
     */
    @Scheduled(cron = "0 */1 * * * ?")
    public void pushFittingTemplateMessage() {
        try {
            log.info("pushFittingTemplateMessage start");
            restTemplate.postForObject(URL + "pushFittingTemplateMessage",
                    new HttpEntity(new HashMap<>(), new HttpHeaders()),
                    Map.class);
            log.info("pushFittingTemplateMessage end");
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

}
