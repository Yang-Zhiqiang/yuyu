package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getexecutabletasksbyprocess;

import javax.ws.rs.FormParam;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;

/**
 * 実行可能タスク情報取得サービスのリクエストBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetExecutableTasksByProcessRequest extends WSCommonRequest {

    public static final String sSERVICE_NAME = "GetExecutableTasksByProcess";

    @FormParam(IWSGetExecutableTasksByProcessIOKey.IN.sS_ACCOUNTID)
    private String sAccountid_;

    @FormParam(IWSGetExecutableTasksByProcessIOKey.IN.sS_SYORISTATUS)
    private String[] sSyoriStatus_;

    @FormParam(IWSGetExecutableTasksByProcessIOKey.IN.sS_FLOWIDS)
    private String[] sFlowIds_;

    @FormParam(IWSGetExecutableTasksByProcessIOKey.IN.sS_KOUTEIKAISIYMD_FROM)
    private String sKouteikaisiYmdFrom_;

    @FormParam(IWSGetExecutableTasksByProcessIOKey.IN.sS_KOUTEIKAISIYMD_TO)
    private String sKouteikaisiYmdTo_;

    @FormParam(IWSGetExecutableTasksByProcessIOKey.IN.sS_KOUTEIKANRYOUYMD_FROM)
    private String sKouteikanryouYmdFrom_;

    @FormParam(IWSGetExecutableTasksByProcessIOKey.IN.sS_KOUTEIKANRYOUYMD_TO)
    private String sKouteikanryouYmdTo_;

    @JSONHint(name = IWSGetExecutableTasksByProcessIOKey.IN.sS_ACCOUNTID)
    public String getAccountid() {
        return sAccountid_;
    }

    public void setAccountid(String psAccountid) {
        sAccountid_ = psAccountid;
    }

    @JSONHint(name = IWSGetExecutableTasksByProcessIOKey.IN.sS_SYORISTATUS)
    public String[] getSyoriStatus() {
        return sSyoriStatus_;
    }

    public void setSyoriStatus(String[] psSyoriStatus) {
        sSyoriStatus_ = psSyoriStatus;
    }

    @JSONHint(name = IWSGetExecutableTasksByProcessIOKey.IN.sS_FLOWIDS)
    public String[] getFlowIds() {
        return sFlowIds_;
    }

    public void setFlowIds(String[] psFlowIds) {
        sFlowIds_ = psFlowIds;
    }

    @JSONHint(name = IWSGetExecutableTasksByProcessIOKey.IN.sS_KOUTEIKAISIYMD_FROM)
    public String getKouteikaisiYmdFrom() {
        return sKouteikaisiYmdFrom_;
    }

    public void setKouteikaisiYmdFrom(String psKouteikaisiYmdFrom) {
        sKouteikaisiYmdFrom_ = psKouteikaisiYmdFrom;
    }

    @JSONHint(name = IWSGetExecutableTasksByProcessIOKey.IN.sS_KOUTEIKAISIYMD_TO)
    public String getKouteikaisiYmdTo() {
        return sKouteikaisiYmdTo_;
    }

    public void setKouteikaisiYmdTo(String psKouteikaisiYmdTo) {
        sKouteikaisiYmdTo_ = psKouteikaisiYmdTo;
    }

    @JSONHint(name = IWSGetExecutableTasksByProcessIOKey.IN.sS_KOUTEIKANRYOUYMD_FROM)
    public String getKouteikanryouYmdFrom() {
        return sKouteikanryouYmdFrom_;
    }

    public void setKouteikanryouYmdFrom(String psKouteikanryouYmdFrom) {
        sKouteikanryouYmdFrom_ = psKouteikanryouYmdFrom;
    }

    @JSONHint(name = IWSGetExecutableTasksByProcessIOKey.IN.sS_KOUTEIKANRYOUYMD_TO)
    public String getKouteikanryouYmdTo() {
        return sKouteikanryouYmdTo_;
    }

    public void setKouteikanryouYmdTo(String psKouteikanryouYmdTo) {
        sKouteikanryouYmdTo_ = psKouteikanryouYmdTo;
    }
}
