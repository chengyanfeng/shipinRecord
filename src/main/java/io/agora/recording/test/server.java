package io.agora.recording.test;

import io.agora.recording.RecordingSDK;
import io.agora.recording.conf.conf;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class server {
    @Async
    public void recording(RecordingSample ars ,conf confdemo,String doctorId,String patientId) {

        String[] args = new String[]{
                "--appId", confdemo.getAppId(), "--uid", confdemo.getUid(), "--appliteDir", confdemo.getApplitePath(),
                "--channel", confdemo.getChannelName(),
                "--channelProfile", confdemo.getChannelProfile(),
                "--idle", Integer.toString(confdemo.getIdleLimitSec()),
                "--channelKey", confdemo.getChannelKey(),
                "--recordFileRootDir", confdemo.getRecordFileRootDir()+doctorId+"/"+patientId

        };
        System.out.println("------------------------------start recording --------------------------");
        ars.createChannel(args);
        ars.unRegister();

    }
}
