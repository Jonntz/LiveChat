package com.jonatas.LiveChat.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.jonatas.LiveChat.domain.ChatInput;
import com.jonatas.LiveChat.domain.ChatOutput;

@Controller
public class LiveChatController {

  @MessageMapping("/new-message")
  @SendTo("/topics/livechat")
  public ChatOutput newMessage(ChatInput input){
    return new ChatOutput(HtmlUtils.htmlEscape(input.user() + ": " + input.message()));
  }
}