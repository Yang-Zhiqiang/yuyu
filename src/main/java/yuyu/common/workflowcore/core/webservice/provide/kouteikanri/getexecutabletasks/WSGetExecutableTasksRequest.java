package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasks;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 実行可能タスク情報取得サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetExecutableTasksRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME= "GetExecutableTasks";

    @FormParam(IWSGetExecutableTasksIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSGetExecutableTasksIOKey.IN.sS_KENSUU_SYUTOKU_YOUHI)
    private String kensuuSyutokuYouhi_;

    @JSONHint(name=IWSGetExecutableTasksIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name=IWSGetExecutableTasksIOKey.IN.sS_KENSUU_SYUTOKU_YOUHI)
    public String getKensuuSyutokuYouhi() {
        return kensuuSyutokuYouhi_;
    }

    public void seKensuuSyutokuYouhi(String pKensuuSyutokuYouhi) {
        kensuuSyutokuYouhi_ = pKensuuSyutokuYouhi;
    }

}
