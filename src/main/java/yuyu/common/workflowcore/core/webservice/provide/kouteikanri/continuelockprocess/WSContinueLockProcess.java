package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.continuelockprocess;


public interface WSContinueLockProcess {

    abstract WSContinueLockProcessResponse executeBizMain(WSContinueLockProcessRequest request) throws Exception;
}