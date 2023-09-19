package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasks;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * 実行可能タスク情報取得サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetExecutableTasksResponse extends WSCommonResponse {


    private String[] sFlowids_;

    private String[] sNodename_;

    private String[] sTaskcountkojin_;

    private String[] sTaskcountkyouyuu_;


    @JSONHint(name=IWSGetExecutableTasksIOKey.OUT.sS_FLOWIDSS)
    public String[] getFlowids() {
        return sFlowids_;
    }

    @JSONHint(name=IWSGetExecutableTasksIOKey.OUT.sS_FLOWIDSS)
    public void setFlowids(String[] psFlowids) {
        sFlowids_ = psFlowids;
    }

    @JSONHint(name=IWSGetExecutableTasksIOKey.OUT.sS_NODENAMES)
    public String[] getNodename() {
        return sNodename_;
    }

    @JSONHint(name=IWSGetExecutableTasksIOKey.OUT.sS_NODENAMES)
    public void setNodename(String[] psNodename) {
        sNodename_ = psNodename;
    }

    @JSONHint(name=IWSGetExecutableTasksIOKey.OUT.sS_TASKCOUNTKOJINS)
    public String[] getTaskcountkojin() {
        return sTaskcountkojin_;
    }

    @JSONHint(name=IWSGetExecutableTasksIOKey.OUT.sS_TASKCOUNTKOJINS)
    public void setTaskcountkojin(String[] psTaskcountkojin) {
        sTaskcountkojin_ = psTaskcountkojin;
    }

    @JSONHint(name=IWSGetExecutableTasksIOKey.OUT.sS_TASKCOUNTKYOUYUUS)
    public String[] getTaskcountkyouyuu() {
        return sTaskcountkyouyuu_;
    }

    @JSONHint(name=IWSGetExecutableTasksIOKey.OUT.sS_TASKCOUNTKYOUYUUS)
    public void setTaskcountkyouyuu(String[] psTaskcountkyouyuu) {
        sTaskcountkyouyuu_ = psTaskcountkyouyuu;
    }

}