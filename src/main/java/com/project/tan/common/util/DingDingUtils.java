package com.project.tan.common.util;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @DESC DingDingUtils
 * @Author tzq
 * @Date 2020-02-11 16:05
 **/
@Slf4j
public class DingDingUtils {
    public static void send(String msg, String mobiles) {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=xx");
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("text");

        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent(msg);
        request.setText(text);

        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setIsAtAll("false");
        at.setAtMobiles(transformList(mobiles));
        request.setAt(at);

        try {
            client.execute(request);
        } catch (ApiException e) {
            log.error("钉钉告警异常:{}", e.getErrMsg());

        }
    }

    private static List<String> transformList(String alarmReceiver) {
        List<String> alarmList = Lists.newArrayList();
        final Iterable<String> iterable = Splitter.on(",").trimResults().split(alarmReceiver);
        iterable.forEach(x -> alarmList.add(x));
        return alarmList;
    }
}
