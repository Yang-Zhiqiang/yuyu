package yuyu.common.workflowcore.core.webservice.provide.accountkanri.getauthinfo;

import java.io.Serializable;
import java.util.ArrayList;

import net.arnx.jsonic.JSONHint;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

/**
 * 権限情報取得サービスのレスポンスBeanです。<br/>
 */
@SuppressWarnings("serial")
public class WSGetAuthInfoResponse extends WSCommonResponse {

    private ArrayList<AuthInfoBean> oAuthinfos_;

    @JSONHint(name=IWSGetAuthInfoIOKey.OUT.sO_AUTHINFOS)
    public ArrayList<AuthInfoBean> getAuthinfos() {
        return oAuthinfos_;
    }

    public void setAuthinfos(ArrayList<AuthInfoBean> poAuthinfos) {
        oAuthinfos_ = poAuthinfos;
    }

    public static class AuthInfoBean implements Serializable {

        private String sAuthid_;

        private String sAuthname_;

        private String[] sFlowids_;

        private String[] sNodeids_;

        private String[] sTorikomisyoruicds_;

        @JSONHint(name=IWSGetAuthInfoIOKey.OUT.sS_AUTHID)
        public String getAuthid() {
            return sAuthid_;
        }

        public void setAuthid(String psAuthid) {
            sAuthid_ = psAuthid;
        }

        @JSONHint(name=IWSGetAuthInfoIOKey.OUT.sS_AUTHNAME)
        public String getAuthname() {
            return sAuthname_;
        }

        public void setAuthname(String psAuthname) {
            sAuthname_ = psAuthname;
        }

        @JSONHint(name=IWSGetAuthInfoIOKey.OUT.sS_FLOWIDSS)
        public String[] getFlowids() {
            return sFlowids_;
        }

        public void setFlowids(String[] psFlowids) {
            sFlowids_ = psFlowids;
        }

        @JSONHint(name=IWSGetAuthInfoIOKey.OUT.sS_NODEIDSS)
        public String[] getNodeids() {
            return sNodeids_;
        }

        public void setNodeids(String[] psNodeids) {
            sNodeids_ = psNodeids;
        }

        @JSONHint(name=IWSGetAuthInfoIOKey.OUT.sS_TORIKOMISYORUICDSS)
        public String[] getTorikomisyoruicds() {
            return sTorikomisyoruicds_;
        }

        public void setTorikomisyoruicds(String[] psTorikomisyoruicds) {
            sTorikomisyoruicds_ = psTorikomisyoruicds;
        }
    }
}