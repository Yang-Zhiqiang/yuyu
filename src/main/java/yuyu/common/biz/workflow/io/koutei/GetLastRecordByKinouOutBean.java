package yuyu.common.biz.workflow.io.koutei;

import java.util.Map;

import yuyu.common.biz.workflow.io.koutei.sub.ProcessRecordBean;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai.WSGetKouteiRirekiSyousaiResponse;

/**
 * 前回処理結果取得（機能指定）サービスの出力Bean
 */
@SuppressWarnings("serial")
public class GetLastRecordByKinouOutBean extends WSGetKouteiRirekiSyousaiResponse {

    private ProcessRecordBean oProcessRecordBean_ = null;


    public ProcessRecordBean getProcessRecordBean() {
        return oProcessRecordBean_;
    }

    public void setProcessRecordBean(ProcessRecordBean pProcessRecordBean) {
        oProcessRecordBean_ = pProcessRecordBean;
    }


    @Override
    @Deprecated
    public  Map<String, String>[] getRirekimaps() {
        return null;
    }
}
