package yuyu.common.workflowcore.core.webservice.provide.datakanri.deleteprocessandjbpmrecord;

import java.util.List;

import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 工程履歴・JBPMデータ削除サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSDeleteProcessAndJBPMRecordRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "DeleteProcessAndJBPMRecord";

    private List<DeleteProcessAndJBPMRecordBean> deleteProcessAndJBPMRecordBeanList;

    public List<DeleteProcessAndJBPMRecordBean> getDeleteProcessAndJBPMRecordBeanList() {
        return deleteProcessAndJBPMRecordBeanList;
    }

    public void setDeleteProcessAndJBPMRecordBeanList(List<DeleteProcessAndJBPMRecordBean> _deleteProcessAndJBPMRecordBeanList) {
        deleteProcessAndJBPMRecordBeanList = _deleteProcessAndJBPMRecordBeanList;
    }
}
