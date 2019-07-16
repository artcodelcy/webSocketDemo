package com.websocket.push;

import com.alibaba.fastjson.JSON;
import com.websocket.model.Message;
import com.websocket.webSocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 后端定时任务推送消息
 * @author LiChangyuan
 * @Date 2019-07-12 16:37
 */
@Slf4j
@Service
public class push {
    @Scheduled(cron = "0/3 * * * * ?")
    public void buildMessage() {
        Long staffId = 20L;
        Message message = new Message("来自后端推送的消息");
        String jsonData = JSON.toJSONString(message);
        log.info("推送数据开始...");
        try {
            WebSocketServer.sendInfo(jsonData, String.valueOf(staffId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("推送数据完成...");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}