package yuyu.common.direct.dscommon;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * ダイレクトサービス ダイレクトサービス共通 保障情報Bean<br/>
 */
public class HosyouBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_ErrorKbn errorKbn;

    private C_UmuKbn sbHsyUmuKbn;

    private C_UmuKbn kgHsyUmukbn;

    private C_UmuKbn iryHsyUmukbn;

    private C_UmuKbn rougoHsyUmukbn;

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public void setErrorKbn(C_ErrorKbn pErrorKbn) {
        this.errorKbn = pErrorKbn;
    }

    public C_UmuKbn getSbHsyUmuKbn() {
        return sbHsyUmuKbn;
    }

    public void setSbHsyUmuKbn(C_UmuKbn pSbHsyUmuKbn) {
        this.sbHsyUmuKbn = pSbHsyUmuKbn;
    }

    public C_UmuKbn getKgHsyUmukbn() {
        return kgHsyUmukbn;
    }

    public void setKgHsyUmukbn(C_UmuKbn pKgHsyUmukbn) {
        this.kgHsyUmukbn = pKgHsyUmukbn;
    }

    public C_UmuKbn getIryHsyUmukbn() {
        return iryHsyUmukbn;
    }

    public void setIryHsyUmukbn(C_UmuKbn pIryHsyUmukbn) {
        this.iryHsyUmukbn = pIryHsyUmukbn;
    }

    public C_UmuKbn getRougoHsyUmukbn() {
        return rougoHsyUmukbn;
    }

    public void setRougoHsyUmukbn(C_UmuKbn pRougoHsyUmukbn) {
        this.rougoHsyUmukbn = pRougoHsyUmukbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
