package yuyu.common.direct.dscommon;

import java.io.Serializable;

import yuyu.def.classification.C_DsKaiyakuchkkekkaKbn;
import yuyu.def.classification.C_ErrorKbn;

/**
 * ダイレクトサービス ダイレクトサービス共通  ＤＳ解約共通チェックBean<br />
 */
public class CheckDsKaiyakuResultBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private C_ErrorKbn errorKbn;

    private C_DsKaiyakuchkkekkaKbn dsKaiyakuchkkekkaKbn;

    private String msgPam;

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public void setErrorKbn(C_ErrorKbn pErrorKbn) {
        this.errorKbn = pErrorKbn;
    }

    public C_DsKaiyakuchkkekkaKbn getDsKaiyakuchkkekkaKbn() {
        return dsKaiyakuchkkekkaKbn;
    }

    public void setDsKaiyakuchkkekkaKbn(C_DsKaiyakuchkkekkaKbn pDsKaiyakuchkkekkaKbn) {
        this.dsKaiyakuchkkekkaKbn = pDsKaiyakuchkkekkaKbn;
    }

    public String getMsgPam() {
        return msgPam;
    }

    public void setMsgPam(String pMsgPam) {
        this.msgPam = pMsgPam;
    }

}
