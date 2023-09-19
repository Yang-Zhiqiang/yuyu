package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.forceunlockprocess;


public interface WSForceUnlockProcess {

    abstract WSForceUnlockProcessResponse executeBizMain(WSForceUnlockProcessRequest request) throws Exception;
}