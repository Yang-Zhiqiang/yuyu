package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getsometask;


public interface WSGetSomeTask {

    abstract WSGetSomeTaskResponse executeBizMain(WSGetSomeTaskRequest request) throws Exception;
}