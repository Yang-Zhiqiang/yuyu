package yuyu.batch.siharai.sisatei.simakesisyahokensyuukei;

import java.io.Serializable;
import java.util.List;

import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_Tuukasyu;


/**
 * 前月支払分Beanクラスです。<br />
 */
public class ZengetuSiharaiBunBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sisyaCd;

    private String sisyaNm;

    private String syoNo;

    private String skNo;

    private C_SeikyuuSyubetu  seikyuuSyubetu;

    private C_Tuukasyu  shrTuukaSyu;

    private C_Tuukasyu  kykTuukaSyu;

    private List<ShrGkMeisaiBean> shrGkMeisaiBeanList;

    public ZengetuSiharaiBunBean() {
        super();
    }

    public String getSisyaCd() {
        return sisyaCd;
    }

    public void setSisyaCd(String pSisyaCd) {
        sisyaCd = pSisyaCd;
    }

    public String getSisyaNm() {
        return sisyaNm;
    }

    public void setSisyaNm(String pSisyaNm) {
        sisyaNm = pSisyaNm;
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        syoNo = pSyoNo;
    }

    public String getSkNo() {
        return skNo;
    }

    public void setSkNo(String pSkNo) {
        skNo = pSkNo;
    }

    public C_SeikyuuSyubetu  getSeikyuuSyubetu() {
        return seikyuuSyubetu;
    }

    public void setSeikyuuSyubetu(C_SeikyuuSyubetu  pSeikyuuSyubetu) {
        seikyuuSyubetu = pSeikyuuSyubetu;
    }

    public C_Tuukasyu  getShrTuukaSyu() {
        return shrTuukaSyu;
    }

    public void setShrTuukaSyu(C_Tuukasyu  pShrTuukaSyu) {
        shrTuukaSyu = pShrTuukaSyu;
    }

    public C_Tuukasyu  getKykTuukaSyu() {
        return kykTuukaSyu;
    }

    public void setKykTuukaSyu(C_Tuukasyu pKykTuukaSyu) {
        kykTuukaSyu = pKykTuukaSyu;
    }

    public List<ShrGkMeisaiBean> getShrGkMeisaiBeanList() {
        return shrGkMeisaiBeanList;
    }

    public void setShrGkMeisaiBeanList(List<ShrGkMeisaiBean> pShrGkMeisaiBeanList) {
        shrGkMeisaiBeanList = pShrGkMeisaiBeanList;
    }

}
