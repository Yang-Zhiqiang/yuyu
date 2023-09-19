package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.lockprocess;


public interface WSLockProcess {

    abstract WSLockProcessResponse executeBizMain(WSLockProcessRequest request) throws Exception;
}