package yuyu.common.workflowcore.core.webservice.common;

import java.io.Serializable;
import java.util.Map;

import lombok.ToString;
import net.arnx.jsonic.JSONHint;

/**
 * Webサービスレスポンス 共通項目<br/>
 * 全Webサービスのレスポンスに共通する項目を定義します。
 */
@SuppressWarnings("serial")
@ToString
public class WSCommonResponse implements Serializable {

    private String sKekkastatus_;

    private String sSyousaimsgcd_;

    private String sSyousaimsg_;

    private Map<String, String>[] oValidationerrmsgs_;


    @JSONHint(name=WSCommonIOKey.OUT.sS_KEKKASTATUS)
    public String getKekkastatus() {
        return sKekkastatus_;
    }

    public void setKekkastatus(String psKekkastatus) {
        sKekkastatus_ = psKekkastatus;
    }


    @JSONHint(name=WSCommonIOKey.OUT.sS_SYOUSAIMSGCD)
    public String getSyousaimsgcd() {
        return sSyousaimsgcd_;
    }

    public void setSyousaimsgcd(String psSyousaimsgcd) {
        sSyousaimsgcd_ = psSyousaimsgcd;
    }

    @JSONHint(name=WSCommonIOKey.OUT.sS_SYOUSAIMSG)
    public String getSyousaimsg() {
        return sSyousaimsg_;
    }

    public void setSyousaimsg(String psSyousaimsg) {
        sSyousaimsg_ = psSyousaimsg;
    }

    @JSONHint(name = WSCommonIOKey.OUT.sO_SYOUSAIMSGMAPS)
    public Map<String, String>[] getValidationErrMsgs() {
        return oValidationerrmsgs_;
    }

    public void setValidationErrMsgs(Map<String, String>[] poMsgmaps) {
        oValidationerrmsgs_ = poMsgmaps;
    }

}
