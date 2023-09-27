package yuyu.common.direct.dscommon;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * ダイレクトサービス ダイレクトサービス共通 画面制御情報Bean<br/>
 */
public class GamenSeigyoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_ErrorKbn errorKbn;

    private C_UmuKbn tutakinUmuKbn;

    private C_UmuKbn kaiyakuHrsuiiUmuKbn;

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public void setErrorKbn(C_ErrorKbn pErrorKbn) {
        this.errorKbn = pErrorKbn;
    }

    public C_UmuKbn getTutakinUmukbn() {
        return tutakinUmuKbn;
    }

    public void setTutakinUmukbn(C_UmuKbn pTutakinUmuKbn) {
        this.tutakinUmuKbn = pTutakinUmuKbn;
    }

    public C_UmuKbn getKaiyakuHrsuiiUmuKbn() {
        return kaiyakuHrsuiiUmuKbn;
    }

    public void setKaiyakuHrsuiiUmuKbn(C_UmuKbn pKaiyakuHrsuiiUmuKbn) {
        this.kaiyakuHrsuiiUmuKbn = pKaiyakuHrsuiiUmuKbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
