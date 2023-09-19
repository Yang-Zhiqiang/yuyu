package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettransitions;


public interface WSGetTransitions {

    abstract WSGetTransitionsResponse executeBizMain(WSGetTransitionsRequest request) throws Exception;
}