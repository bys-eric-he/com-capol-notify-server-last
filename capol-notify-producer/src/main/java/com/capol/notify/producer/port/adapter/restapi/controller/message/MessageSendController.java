package com.capol.notify.producer.port.adapter.restapi.controller.message;

import com.capol.notify.producer.application.message.SendMessageService;
import com.capol.notify.producer.application.message.command.DingDingMsgCommand;
import com.capol.notify.producer.port.adapter.restapi.controller.message.parameter.MessageRequestParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1.0/service/message")
@Api(tags = "消息发送API")
public class MessageSendController {

    private SendMessageService applyForOTMessageService;

    public MessageSendController(SendMessageService applyForOTMessageService) {
        this.applyForOTMessageService = applyForOTMessageService;
    }

    @PostMapping("/send-request")
    @ApiOperation("消息发送请求")
    public void messageSendRequest(@Valid @RequestBody MessageRequestParam request) {
        applyForOTMessageService.sentApplyNoticeMsg(DingDingMsgCommand.builder()
                .msgType(request.getMsgType())
                .priority(request.getPriority())
                .content(request.getContent())
                .userIds(request.getUserIds())
                .agentId(request.getAgentId())
                .businessType(request.getBusinessType())
                .build());
    }
}
