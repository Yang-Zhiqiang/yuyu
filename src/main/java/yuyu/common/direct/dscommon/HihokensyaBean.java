package yuyu.common.direct.dscommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_ErrorKbn;

/**
 * ダイレクトサービス ダイレクトサービス共通  被保険者情報Bean<br/>
 */
public class HihokensyaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_ErrorKbn errorKbn;

    private String hhknNmKn;

    private BizDate hhknseiYmd;

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public void setErrorKbn(C_ErrorKbn pErrorKbn) {
        errorKbn = pErrorKbn;
    }

    public String getHhknNmKn() {
        return hhknNmKn;
    }

    public void setHhknNmKn(String pHhknNmKn) {
        hhknNmKn = pHhknNmKn;
    }

    public BizDate getHhknseiYmd() {
        return hhknseiYmd;
    }

    public void setHhknseiYmd(BizDate pHhknseiYmd) {
        hhknseiYmd = pHhknseiYmd;
    }

}
