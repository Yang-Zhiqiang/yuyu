package yuyu.common.suuri.srcommon;

import java.io.Serializable;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SuuriKbnHenkanErrorKbn;

/**
 * 数理統計 数理共通 数理用区分変換Beanクラス
 */
public class SrSuuriKbnHenkanBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_ErrorKbn kekkaKbn;

    private C_SuuriKbnHenkanErrorKbn suuriKbnHenkanErrorKbn;

    private String henkanAtoKbn;

    public C_ErrorKbn getKekkaKbn() {
        return kekkaKbn;
    }

    public void setKekkaKbn(C_ErrorKbn kekkaKbn) {
        this.kekkaKbn = kekkaKbn;
    }

    public C_SuuriKbnHenkanErrorKbn getSuuriKbnHenkanErrorKbn() {
        return suuriKbnHenkanErrorKbn;
    }

    public void setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn suuriKbnHenkanErrorKbn) {
        this.suuriKbnHenkanErrorKbn = suuriKbnHenkanErrorKbn;
    }

    public String getHenkanAtoKbn() {
        return henkanAtoKbn;
    }

    public void setHenkanAtoKbn(String henkanAtoKbn) {
        this.henkanAtoKbn = henkanAtoKbn;
    }
}
