package org.study.mq.kafka.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author unisk1123
 * @Description
 * @create 2019/5/20
 */
public class ReportMetaData implements Serializable {

    private String title;
    private List<ReportClickData> clickData = new ArrayList<ReportClickData>();

    @Override
    public String toString() {
        return "ReportMetaData{" +
                "title='" + title + '\'' +
                ", clickData=" + clickData +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ReportClickData> getClickData() {
        return clickData;
    }

    public void setClickData(List<ReportClickData> clickData) {
        this.clickData = clickData;
    }
}
