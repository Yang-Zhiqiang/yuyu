package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * 契約保全 契約保全共通 目標額変更DB更新Beanクラス
 */
public class MkhgkhenkouDBUpdateBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private IT_KykKihon kykKihon;

    private IT_KhHenkouUktk khHenkouUktk;

    private BizDate targetTkKykhenkoymd;

    private C_TargetTkMokuhyoutiKbn targettkMkhtkbn;

    private KhozenCommonParam khCommonParam;

    private C_HonninKakninKekkaKbn honninKakninKekkaKbn;

    private String kouteiKanriId;

    private C_HassouKbn hassouKbn;

    private BizDate syoriYmd;

    public IT_KykKihon getKykKihon() {
        return kykKihon;
    }

    public void setKykKihon(IT_KykKihon pKykKihon) {
        this.kykKihon = pKykKihon;
    }

    public IT_KhHenkouUktk getKhHenkouUktk() {
        return khHenkouUktk;
    }

    public void setKhHenkouUktk(IT_KhHenkouUktk pKhHenkouUktk) {
        this.khHenkouUktk = pKhHenkouUktk;
    }

    public BizDate getTargetTkKykhenkoymd() {
        return targetTkKykhenkoymd;
    }

    public void setTargetTkKykhenkoymd(BizDate pTargetTkKykhenkoymd) {
        this.targetTkKykhenkoymd = pTargetTkKykhenkoymd;
    }

    public C_TargetTkMokuhyoutiKbn getTargettkMkhtkbn() {
        return targettkMkhtkbn;
    }

    public void setTargettkMkhtkbn(C_TargetTkMokuhyoutiKbn pTargettkMkhtkbn) {
        this.targettkMkhtkbn = pTargettkMkhtkbn;
    }

    public KhozenCommonParam getKhCommonParam() {
        return khCommonParam;
    }

    public void setKhCommonParam(KhozenCommonParam pKhCommonParam) {
        this.khCommonParam = pKhCommonParam;
    }

    public C_HonninKakninKekkaKbn getHonninKakninKekkaKbn() {
        return honninKakninKekkaKbn;
    }

    public void setHonninKakninKekkaKbn(C_HonninKakninKekkaKbn pHonninKakninKekkaKbn) {
        this.honninKakninKekkaKbn = pHonninKakninKekkaKbn;
    }

    public String getKouteiKanriId() {
        return kouteiKanriId;
    }

    public void setKouteiKanriId(String pKouteiKanriId) {
        this.kouteiKanriId = pKouteiKanriId;
    }

    public C_HassouKbn getHassouKbn() {
        return hassouKbn;
    }

    public void setHassouKbn(C_HassouKbn pHassouKbn) {
        this.hassouKbn = pHassouKbn;
    }

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        this.syoriYmd = pSyoriYmd;
    }

}
