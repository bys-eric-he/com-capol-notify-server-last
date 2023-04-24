package com.capol.notify.manage.domain.model.message;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.capol.notify.manage.domain.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;

/**
 * 业务系统用户消息队列
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user_queue_message")
@NoArgsConstructor
public class UserQueueMessageDO extends BaseEntity {
    /**
     * 消息所属业务系统ID
     */
    private String serviceId;

    /**
     * 消息所属队列ID
     */
    private Long queueId;

    /**
     * 消息优先级
     */
    private Integer priority;

    /**
     * 消息类型
     */
    private String businessType;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 消息发送响应内容
     */
    private String sendResponse;

    /**
     * 消息处理状态(0-待处理 1-处理成功 2-处理失败)
     */
    private Integer processStatus;

    /**
     * 消息处理失败重试次数
     */
    private Integer retryCount;

    /**
     * 消费端开始消费时间
     */
    private DateTime consumerStartTime;

    /**
     * 消费端消费结束时间
     */
    private DateTime consumerEndTime;

    public UserQueueMessageDO(String serviceId, Long queueId, Integer priority, String businessType, String content,
                              String sendResponse, Integer processStatus, Integer retryCount) {
        Validate.notNull(serviceId, "ServiceId must be provided.");
        Validate.notNull(queueId, "QueueId must not be null.");
        Validate.notNull(businessType, "Business type must not be null.");
        Validate.notBlank(content, "Content must not be null.");
        this.serviceId = serviceId;
        this.queueId = queueId;
        this.priority = priority;
        this.businessType = businessType;
        this.content = content;
        this.sendResponse = sendResponse;
        this.processStatus = processStatus;
        this.retryCount = retryCount;
    }
}
