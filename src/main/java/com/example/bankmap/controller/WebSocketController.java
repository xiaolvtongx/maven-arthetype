package com.example.bankmap.controller;


import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * WebSocket控制器类，它使用@RestController注解标记为一个RESTful Web服务。在其中，我们定义了一个名为notifyClients()的请求处理方法，并使用@RequestMapping注解将其映射到“/notify”路径上。
 *
 * 该方法接受一个必需的message参数，用于指定要发送的通知消息。我们使用SimpMessagingTemplate类的convertAndSend()方法将消息发送到“/topic/notifications”目的地，并返回一个“Message sent！”的字符串作为响应。
 */
@RestController
public class WebSocketController {


    private SimpMessagingTemplate template;

    @RequestMapping("/notify")
    public String notifyClients(@RequestParam(value = "message", required = true) String message) {
        template.convertAndSend("/topic/notifications", message);
        return "Message sent!";
    }

}