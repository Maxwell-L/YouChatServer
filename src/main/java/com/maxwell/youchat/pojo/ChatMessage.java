package com.maxwell.youchat.pojo;

public class ChatMessage {
    private Long id;
    private Long sendUserId;
    private Long receiveUserId;
    private Long groupId;
    private Long createTime;
    private String content;

    public ChatMessage(Long id, Long sendUserId, Long receiveUserId, Long groupId, Long createTime, String content) {
        this.id = id;
        this.sendUserId = sendUserId;
        this.receiveUserId = receiveUserId;
        this.groupId = groupId;
        this.createTime = createTime;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(Long sendUserId) {
        this.sendUserId = sendUserId;
    }

    public Long getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(Long receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"sendUserId\":")
                .append(sendUserId);
        sb.append(",\"receiveUserId\":")
                .append(receiveUserId);
        sb.append(",\"groupId\":")
                .append(groupId);
        sb.append(",\"createTime\":")
                .append(createTime);
        sb.append(",\"content\":\"")
                .append(content).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
