package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.unlockprocess;


public interface WSUnlockProcess {

    abstract WSUnlockProcessResponse executeBizMain(WSUnlockProcessRequest request) throws Exception;
}