package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisummary;


public interface WSGetKouteiRirekiSummary {

    abstract WSGetKouteiRirekiSummaryResponse executeBizMain(WSGetKouteiRirekiSummaryRequest request) throws Exception;

    abstract String execTest() throws Exception;
}