package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforward;


public interface WSExecProcessForward {

    abstract WSExecProcessForwardResponse executeBizMain(WSExecProcessForwardRequest request) throws Exception;
}