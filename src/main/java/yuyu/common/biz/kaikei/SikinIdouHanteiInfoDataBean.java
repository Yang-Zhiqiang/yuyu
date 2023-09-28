package yuyu.common.biz.kaikei;

import java.io.Serializable;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_GkhnkzidourtKbn;
import yuyu.def.classification.C_HijynnykzndkkouzaKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_UmuKbn;

/**
 * 業務共通 経理・会計 資金移動判定情報Beanクラス
 */
public class SikinIdouHanteiInfoDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public SikinIdouHanteiInfoDataBean() {
        super();
    }

    private C_ErrorKbn errorKbn;

    private C_Segcd segCd;

    private C_HijynnykzndkkouzaKbn hijynnykZndkkouzaKbn;

    private C_GkhnkzidourtKbn fstpGkhnkzidouRt;

    private C_GkhnkzidourtKbn zenkiZennouGkhnkzidouRt;

    private C_GkhnkzidourtKbn keizokupGkhnkzidouRt;

    private C_UmuKbn seiymdSeitstuityouhnknUmu;

    private C_UmuKbn zeiseiTekikakuUmu;

    private C_UmuKbn itijibrUmu;

    private C_UmuKbn sbHkuktUmu;

    private C_UmuKbn sbKyuuhukinuktUmu;

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public void setErrorKbn(C_ErrorKbn pErrorKbn) {
        errorKbn = pErrorKbn;
    }

    public C_Segcd getSegCd() {
        return segCd;
    }

    public void setSegCd(C_Segcd pSegCd) {
        segCd = pSegCd;
    }

    public C_HijynnykzndkkouzaKbn getHijynnykZndkkouzaKbn() {
        return hijynnykZndkkouzaKbn;
    }

    public void setHijynnykZndkkouzaKbn(C_HijynnykzndkkouzaKbn pHijynnykZndkkouzaKbn) {
        hijynnykZndkkouzaKbn = pHijynnykZndkkouzaKbn;
    }

    public C_GkhnkzidourtKbn getFstpGkhnkzidouRt() {
        return fstpGkhnkzidouRt;
    }

    public void setFstpGkhnkzidouRt(C_GkhnkzidourtKbn pFstpGkhnkzidouRt) {
        fstpGkhnkzidouRt = pFstpGkhnkzidouRt;
    }

    public C_GkhnkzidourtKbn getZenkiZennouGkhnkzidouRt() {
        return zenkiZennouGkhnkzidouRt;
    }

    public void setZenkiZennouGkhnkzidouRt(C_GkhnkzidourtKbn pZenkiZennouGkhnkzidouRt) {
        zenkiZennouGkhnkzidouRt = pZenkiZennouGkhnkzidouRt;
    }

    public C_GkhnkzidourtKbn getKeizokupGkhnkzidouRt() {
        return keizokupGkhnkzidouRt;
    }

    public void setKeizokupGkhnkzidouRt(C_GkhnkzidourtKbn pKeizokupGkhnkzidouRt) {
        keizokupGkhnkzidouRt = pKeizokupGkhnkzidouRt;
    }

    public C_UmuKbn getSeiymdSeitstuityouhnknUmu() {
        return seiymdSeitstuityouhnknUmu;
    }

    public void setSeiymdSeitstuityouhnknUmu(C_UmuKbn pSeiymdSeitstuityouhnknUmu) {
        seiymdSeitstuityouhnknUmu = pSeiymdSeitstuityouhnknUmu;
    }

    public C_UmuKbn getZeiseiTekikakuUmu() {
        return zeiseiTekikakuUmu;
    }

    public void setZeiseiTekikakuUmu(C_UmuKbn pZeiseiTekikakuUmu) {
        zeiseiTekikakuUmu = pZeiseiTekikakuUmu;
    }

    public C_UmuKbn getItijibrUmu() {
        return itijibrUmu;
    }

    public void setItijibrUmu(C_UmuKbn pItijibrUmu) {
        itijibrUmu = pItijibrUmu;
    }

    public C_UmuKbn getSbHkuktUmu() {
        return sbHkuktUmu;
    }

    public void setSbHkuktUmu(C_UmuKbn pSbHkuktUmu) {
        sbHkuktUmu = pSbHkuktUmu;
    }

    public C_UmuKbn getSbKyuuhukinuktUmu() {
        return sbKyuuhukinuktUmu;
    }

    public void setSbKyuuhukinuktUmu(C_UmuKbn pSbKyuuhukinuktUmu) {
        sbKyuuhukinuktUmu = pSbKyuuhukinuktUmu;
    }
}
