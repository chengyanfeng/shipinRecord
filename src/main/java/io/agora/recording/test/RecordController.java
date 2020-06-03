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
import java.util.Map;


@RestController
@EnableAsync
public class RecordController {

    @Autowired
    conf confdemo;
    @Autowired
    server ser;

    @GetMapping("/record")
    public String record(@RequestParam(name = "appId", required = true) String appId, @RequestParam(name = "channelKey", required = false) String channelKey,
                         @RequestParam(name = "channlName", required = true) String channlName, @RequestParam(name = "uid", required = false) String uid,
                         @RequestParam(name = "channelProfile", required = false) String channelProfile,
                         @RequestParam(name = "doctorId", required = true) String doctorId,
                         @RequestParam(name = "patientId", required = true) String patientId
    ) {

        if (appId != null&&!"".equals(appId)) {
            confdemo.setAppId(appId);
        }
        if (channelKey != null&&!"".equals(channelKey)) {
            confdemo.setChannelKey(channelKey);
        }
        if (channlName != null&&!"".equals(channlName)) {
            confdemo.setChannelName(channlName);
        }
        if (uid != null&&!"".equals(uid)) {
            confdemo.setUid(uid);
        }
        if (channelProfile != null&&!"".equals(channelProfile)) {
            confdemo.setChannelProfile(channelProfile);
        }
        if(patientId ==null){
            patientId="patient";
        }
        if(doctorId ==null){
            doctorId="doctor";
        }
        System.out.println("---------------doctorId:"+doctorId+"-------patient:"+patientId+"-------------");
        System.out.println(confdemo.toString());
        System.out.println("------------------------------start recording --------------------------");
        RecordingSDK recordingSdk = new RecordingSDK();
        RecordingSample ars = new RecordingSample(recordingSdk);
        //执行异步方法
        ser.recording(ars,confdemo, doctorId, patientId);
        try {
            Thread.sleep(2000);
        } catch (Exception e){
            System.out.println(e);
        }
        Map<String, Boolean> flagMap = ars.getFlagMap();
        Boolean aBoolean = flagMap.get(confdemo.getChannelName());

       if(null==aBoolean){
           return "{code:500,message:server is Exception please check The  Path of AgoraCoreService or NetWork Exception}";
       }else{
           if (aBoolean){
               flagMap.remove(confdemo.getChannelName());
               return "{code:200,message:Recording has been start}";
           }else {
               return  "{code:502,message:Recording is false,please check the server}";
           }
       }
    }


}
