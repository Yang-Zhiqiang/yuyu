package yuyu.common.direct.dscommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Kyksei;

/**
 * ダイレクトサービス ダイレクトサービス共通 契約者情報Bean<br/>
 */
public class KeiyakusyaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_ErrorKbn errorKbn;

    private String kykNmKn;

    private String kykNmKj;

    private BizDate kykseiYmd;

    private C_Kyksei kyksei;

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public void setErrorKbn(C_ErrorKbn pErrorKbn) {
        errorKbn = pErrorKbn;
    }

    public String getKykNmKn() {
        return kykNmKn;
    }

    public void setKykNmKn(String pKykNmKn) {
        kykNmKn = pKykNmKn;
    }

    public String getKykNmKj() {
        return kykNmKj;
    }

    public void setKykNmKj(String pKykNmKj) {
        kykNmKj = pKykNmKj;
    }

    public BizDate getKykseiYmd() {
        return kykseiYmd;
    }

    public void setKykseiYmd(BizDate pKykseiYmd) {
        kykseiYmd = pKykseiYmd;
    }

    public C_Kyksei getKyksei() {
        return kyksei;
    }

    public void setKyksei(C_Kyksei pKyksei) {
        kyksei = pKyksei;
    }

}
