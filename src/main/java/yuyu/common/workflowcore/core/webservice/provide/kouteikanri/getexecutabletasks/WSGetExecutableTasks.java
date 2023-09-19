package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasks;


public interface WSGetExecutableTasks {

    abstract WSGetExecutableTasksResponse executeBizMain(WSGetExecutableTasksRequest request) throws Exception;
}