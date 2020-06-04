package io.agora.recording.test;

import io.agora.recording.RecordingSDK;
import io.agora.recording.conf.conf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


@RestController
@EnableAsync
public class RecordController {

    @Autowired
    conf confdemo;
    @Autowired
    server ser;

    @GetMapping(value="/record",produces="application/json;charset=UTF-8")
    public Map record(@RequestParam(name = "appId", required = true) String appId, @RequestParam(name = "channelKey", required = false) String channelKey,
                      @RequestParam(name = "channlName", required = true) String channlName, @RequestParam(name = "uid", required = false) String uid,
                      @RequestParam(name = "channelProfile", required = false) String channelProfile,
                      @RequestParam(name = "doctorId", required = true) String doctorId,
                      @RequestParam(name = "patientId", required = true) String patientId
    ) throws UnsupportedEncodingException {
        Map<String, Object> returnMap = new HashMap<>();

        if (appId != null && !"".equals(appId)) {
            confdemo.setAppId(appId);
        }
        if (channelKey != null && !"".equals(channelKey)) {
            confdemo.setChannelKey(channelKey);
        }
        if (channlName != null && !"".equals(channlName)) {
            confdemo.setChannelName(channlName);
        }
        if (uid != null && !"".equals(uid)) {
            confdemo.setUid(uid);
        }
        if (channelProfile != null && !"".equals(channelProfile)) {
            confdemo.setChannelProfile(channelProfile);
        }
        if (patientId == null) {
            patientId = "patient";
        }
        if (doctorId == null) {
            doctorId = "doctor";
        }
        System.out.println("---------------doctorId:" + doctorId + "-------patient:" + patientId + "-------------");
        System.out.println(confdemo.toString());
        RecordingSDK recordingSdk = new RecordingSDK();
        RecordingSample ars = new RecordingSample(recordingSdk);
        //执行异步方法
        ser.recording(ars, confdemo, doctorId, patientId);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e);
        }
        Map<String, Boolean> flagMap = ars.getFlagMap();
        Boolean aBoolean = flagMap.get(confdemo.getChannelName());

        if (null == aBoolean) {
            returnMap.put("code", 500);
            returnMap.put("message", "server is Exception please check The  Path of AgoraCoreService or NetWork Exception");
            return returnMap;
        } else {
            if (aBoolean) {
                flagMap.remove(confdemo.getChannelName());
                returnMap.put("code", 200);
                returnMap.put("message", "Recording has been start");
                return returnMap;
            } else {
                flagMap.remove(confdemo.getChannelName());
                returnMap.put("code", 502);
                returnMap.put("message", "Recording is false,please check the server");
                return returnMap;
            }
        }
    }


}
