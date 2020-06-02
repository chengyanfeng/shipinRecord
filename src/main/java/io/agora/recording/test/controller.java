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


@RestController
@EnableAsync
public class controller {

    @Autowired
    conf confdemo;
    @Autowired
    server ser;
    @GetMapping("/record")
    public String record(@RequestParam(name = "appId",required = false) String appId, @RequestParam(name = "channelKey",required = false) String channelKey,
                         @RequestParam(name = "channlName",required = false) String channlName, @RequestParam(name = "uid",required = false) String uid,
                         @RequestParam(name = "channelProfile",required = false) String channelProfile
                         ) {
        if (appId != null) {
            confdemo.setAppId(appId);
        }
        if (channelKey != null) {
            confdemo.setChannelKey(channelKey);
        }
        if (channlName != null) {
            confdemo.setChannelName(channlName);
        }
        if (uid != null) {
            confdemo.setUid(uid);
        }
        if (channelProfile != null) {
            confdemo.setChannelProfile(channelProfile);
        }
        System.out.println(confdemo.toString());

        //执行异步方法
        ser.recording(confdemo);
        return "{code:0}";
    }



}
