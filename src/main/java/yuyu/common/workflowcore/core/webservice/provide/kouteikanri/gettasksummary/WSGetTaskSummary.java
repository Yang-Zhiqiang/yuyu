package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.gettasksummary;


public interface WSGetTaskSummary {

    abstract WSGetTaskSummaryResponse executeBizMain(WSGetTaskSummaryRequest request) throws Exception;
}