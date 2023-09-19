package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasks;


public interface WSGetTasks {

    abstract WSGetTasksResponse executeBizMain(WSGetTasksRequest request) throws Exception;
}