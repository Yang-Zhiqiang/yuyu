package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessforwardforbatch;

import net.arnx.jsonic.JSONHint;

/**
 * 工程サマリ更新用データBean
 */
public class ProcessForwardSummaryBean {

    private String summaryPreviousTasknodeLocalName;

    private String summaryCurrentTasknodeLocalName;

    private String summaryCurrentTaskname;

    private String summaryKouteikaisibi;

    private String summaryKouteikanryoubi;

    private String summarySyoristatus;


    @JSONHint(name = IWSExecProcessForwardForBatchIOKey.SUMMARY.sS_SUMMARY_PREVIOUS_TASKNODE_LOCALNAME)
    public String getSummaryPreviousTasknodeLocalName() {
        return summaryPreviousTasknodeLocalName;
    }

    public void setSummaryPreviousTasknodeLocalName(String pSummaryPreviousTasknodeLocalName) {
        this.summaryPreviousTasknodeLocalName = pSummaryPreviousTasknodeLocalName;
    }

    @JSONHint(name=IWSExecProcessForwardForBatchIOKey.SUMMARY.sS_SUMMARY_CURRENT_TASKNODE_LOCALNAME)
    public String getSummaryCurrentTasknodeLocalName() {
        return summaryCurrentTasknodeLocalName;
    }

    public void setSummaryCurrentTasknodeLocalName(String pSummaryCurrentTasknodeLocalName) {
        this.summaryCurrentTasknodeLocalName = pSummaryCurrentTasknodeLocalName;
    }

    @JSONHint(name=IWSExecProcessForwardForBatchIOKey.SUMMARY.sS_SUMMARY_CURRENT_TASKNAME)
    public String getSummaryCurrentTaskname() {
        return summaryCurrentTaskname;
    }

    public void setSummaryCurrentTaskname(String pSummaryCurrentTaskname) {
        this.summaryCurrentTaskname = pSummaryCurrentTaskname;
    }

    @JSONHint(name=IWSExecProcessForwardForBatchIOKey.SUMMARY.sS_SUMMARY_KOUTEI_KAISIBI)
    public String getSummaryKouteikaisibi() {
        return summaryKouteikaisibi;
    }

    public void setSummaryKouteikaisibi(String pSummaryKouteikaisibi) {
        this.summaryKouteikaisibi = pSummaryKouteikaisibi;
    }

    @JSONHint(name=IWSExecProcessForwardForBatchIOKey.SUMMARY.sS_SUMMARY_KOUTEI_KANRYOUBI)
    public String getSummaryKouteikanryoubi() {
        return summaryKouteikanryoubi;
    }

    public void setSummaryKouteikanryoubi(String pSummaryKouteikanryoubi) {
        this.summaryKouteikanryoubi = pSummaryKouteikanryoubi;
    }

    @JSONHint(name=IWSExecProcessForwardForBatchIOKey.SUMMARY.sS_SUMMARY_SYORISTATUS)
    public String getSummarySyoristatus() {
        return summarySyoristatus;
    }

    public void setSummarySyoristatus(String pSummarySyoristatus) {
        this.summarySyoristatus = pSummarySyoristatus;
    }
}
