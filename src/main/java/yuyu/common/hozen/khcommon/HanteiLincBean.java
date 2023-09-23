package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * 契約保全 契約保全共通 ＬＩＮＣ該当判定Beanクラス
 */
public class HanteiLincBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate syoriYmd;

    private IT_BAK_KykKihon bakKykKihon;

    private IT_KykKihon kykKihon;

    private Long kanyuusyaNo;

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    public IT_BAK_KykKihon getBakKykKihon() {
        return bakKykKihon;
    }

    public void setBakKykKihon(IT_BAK_KykKihon pBakKykKihon) {
        bakKykKihon = pBakKykKihon;
    }

    public IT_KykKihon getKykKihon() {
        return kykKihon;
    }

    public void setKykKihon(IT_KykKihon pKykKihon) {
        kykKihon = pKykKihon;
    }

    public Long getKanyuusyaNo() {
        return kanyuusyaNo;
    }

    public void setKanyuusyaNo(Long pKanyuusyaNo) {
        kanyuusyaNo = pKanyuusyaNo;
    }
}
