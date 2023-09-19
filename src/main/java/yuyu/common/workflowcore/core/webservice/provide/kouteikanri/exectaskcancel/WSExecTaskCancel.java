package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskcancel;



public interface WSExecTaskCancel {

    abstract WSExecTaskCancelResponse executeBizMain(WSExecTaskCancelRequest request) throws Exception;
}