package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createprocessrecord;


public interface WSCreateProcessRecord {

    abstract WSCreateProcessRecordResponse executeBizMain(WSCreateProcessRecordRequest request) throws Exception;
}