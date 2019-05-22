package org.study.mq.kafka.controller;

import com.sun.tools.internal.jxc.ap.Const;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.study.mq.kafka.config.Constants;
import org.study.mq.kafka.model.ReportData;

import java.util.HashMap;
import java.util.Map;

/**
 * @author unisk1123
 * @Description
 * @create 2019/5/20
 */
@Controller
@RequestMapping(("/report/pc"))
public class ReportPcController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping(value = "pageView", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> pageView(@RequestBody ReportData data) {
        kafkaTemplate.send(Constants.TOPIC_PAGE, data.toString());
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", "页面数据上传成功");
        return result;
    }

    @RequestMapping(value = "click", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> click(@RequestBody ReportData data) {
        kafkaTemplate.send(Constants.TOPIC_CLICK, data.toString());
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", "页面数据上传成功");
        return result;
    }

}
