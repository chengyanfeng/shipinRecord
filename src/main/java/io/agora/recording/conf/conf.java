package io.agora.recording.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "record")
public class conf {

    String appId = "";
    String channelKey = "";
    String channelName = "";
    String channelProfile = "1";
    String uid ="0";
    String decryptionMode = "";
    String secret = "";
    String mixResolution = "360,640,15,500";

    int idleLimitSec = 5 * 4;// 20s

    String applitePath = "";
    String recordFileRootDir = "";
    String cfgFilePath = "";
    int proxyType = 1;
    String proxyServer = "";
    String defaultVideoBgPath = "";
    String defaultUserBgPath = "";
    String subscribeVideoUids = "";
    String subscribeAudioUids = "";
    int lowUdpPort = 0;// 40000;
    int highUdpPort = 0;// 40004;
    String isMixingEnabled ="0";
    String mixedVideoAudio="2";

    public String getIsMixingEnabled() {
        return isMixingEnabled;
    }

    public void setIsMixingEnabled(String isMixingEnabled) {
        this.isMixingEnabled = isMixingEnabled;
    }

    public String getMixedVideoAudio() {
        return mixedVideoAudio;
    }

    public void setMixedVideoAudio(String mixedVideoAudio) {
        this.mixedVideoAudio = mixedVideoAudio;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getChannelKey() {
        return channelKey;
    }

    public void setChannelKey(String channelKey) {
        this.channelKey = channelKey;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelProfile() {
        return channelProfile;
    }

    public void setChannelProfile(String channelProfile) {
        this.channelProfile = channelProfile;
    }

    public String getDecryptionMode() {
        return decryptionMode;
    }

    public void setDecryptionMode(String decryptionMode) {
        this.decryptionMode = decryptionMode;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getMixResolution() {
        return mixResolution;
    }

    public void setMixResolution(String mixResolution) {
        this.mixResolution = mixResolution;
    }

    public int getIdleLimitSec() {
        return idleLimitSec;
    }

    public void setIdleLimitSec(int idleLimitSec) {
        this.idleLimitSec = idleLimitSec;
    }

    public String getApplitePath() {
        return applitePath;
    }

    public void setApplitePath(String applitePath) {
        this.applitePath = applitePath;
    }

    public String getRecordFileRootDir() {
        return recordFileRootDir;
    }

    public void setRecordFileRootDir(String recordFileRootDir) {
        this.recordFileRootDir = recordFileRootDir;
    }

    public String getCfgFilePath() {
        return cfgFilePath;
    }

    public void setCfgFilePath(String cfgFilePath) {
        this.cfgFilePath = cfgFilePath;
    }

    public int getProxyType() {
        return proxyType;
    }

    public void setProxyType(int proxyType) {
        this.proxyType = proxyType;
    }

    public String getProxyServer() {
        return proxyServer;
    }

    public void setProxyServer(String proxyServer) {
        this.proxyServer = proxyServer;
    }

    public String getDefaultVideoBgPath() {
        return defaultVideoBgPath;
    }

    public void setDefaultVideoBgPath(String defaultVideoBgPath) {
        this.defaultVideoBgPath = defaultVideoBgPath;
    }

    public String getDefaultUserBgPath() {
        return defaultUserBgPath;
    }

    public void setDefaultUserBgPath(String defaultUserBgPath) {
        this.defaultUserBgPath = defaultUserBgPath;
    }

    public String getSubscribeVideoUids() {
        return subscribeVideoUids;
    }

    public void setSubscribeVideoUids(String subscribeVideoUids) {
        this.subscribeVideoUids = subscribeVideoUids;
    }

    public String getSubscribeAudioUids() {
        return subscribeAudioUids;
    }

    public void setSubscribeAudioUids(String subscribeAudioUids) {
        this.subscribeAudioUids = subscribeAudioUids;
    }

    public int getLowUdpPort() {
        return lowUdpPort;
    }

    public void setLowUdpPort(int lowUdpPort) {
        this.lowUdpPort = lowUdpPort;
    }

    public int getHighUdpPort() {
        return highUdpPort;
    }

    public void setHighUdpPort(int highUdpPort) {
        this.highUdpPort = highUdpPort;
    }

    @Override
    public String toString() {
        return "conf{" +
                "appId='" + appId + '\'' +
                ", channelKey='" + channelKey + '\'' +
                ", channelName='" + channelName + '\'' +
                ", channelProfile='" + channelProfile + '\'' +
                ", uid='" + uid + '\'' +
                ", decryptionMode='" + decryptionMode + '\'' +
                ", secret='" + secret + '\'' +
                ", mixResolution='" + mixResolution + '\'' +
                ", idleLimitSec=" + idleLimitSec +
                ", applitePath='" + applitePath + '\'' +
                ", recordFileRootDir='" + recordFileRootDir + '\'' +
                ", cfgFilePath='" + cfgFilePath + '\'' +
                ", proxyType=" + proxyType +
                ", proxyServer='" + proxyServer + '\'' +
                ", defaultVideoBgPath='" + defaultVideoBgPath + '\'' +
                ", defaultUserBgPath='" + defaultUserBgPath + '\'' +
                ", subscribeVideoUids='" + subscribeVideoUids + '\'' +
                ", subscribeAudioUids='" + subscribeAudioUids + '\'' +
                ", lowUdpPort=" + lowUdpPort +
                ", highUdpPort=" + highUdpPort +
                ", isMixingEnabled='" + isMixingEnabled + '\'' +
                ", mixedVideoAudio='" + mixedVideoAudio + '\'' +
                '}';
    }
}
