package org.study.mq.kafka.model;

import java.io.Serializable;

/**
 * @author unisk1123
 * @Description
 * @create 2019/5/20
 */
public class ReportClickData implements Serializable {

    private String tagType;
    private String content;

    @Override
    public String toString() {
        return "ReportClickData{" +
                "tagType='" + tagType + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getTagType() {
        return tagType;
    }

    public void setTagType(String tagType) {
        this.tagType = tagType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
