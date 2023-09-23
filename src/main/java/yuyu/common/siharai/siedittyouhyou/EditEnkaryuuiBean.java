package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.siharai.edittbl.SiSiDetailParamBean;
import yuyu.common.siharai.sicommon.SiHkkingakuSisanParamBean;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 円貨支払留意事項説明文書編集Bean<br />
 */
public class EditEnkaryuuiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean;

    private String syoNo;

    private String kyknmKj;

    private String hhknnmKj;

    private String uktnmKj;

    private C_SUketoriHouhouKbn ukthouKbn;

    private BizDate calckijyunYmd;

    private String uktbnWari;

    private BizCurrency hkgkGaika;

    private BizCurrency hkgkYen;

    private C_Tuukasyu tuukasyu;

    private SiHkkingakuSisanParamBean siHkkingakuSisanParamBean;

    private List<SiSiDetailParamBean> siSiDetailParamBeanList;

    public EditEnkaryuuiBean() {
        super();
    }

    public SiTyouhyouHensyuuCommonBean getSiTyouhyouHensyuuCommonBean() {
        return siTyouhyouHensyuuCommonBean;
    }

    public void setSiTyouhyouHensyuuCommonBean(SiTyouhyouHensyuuCommonBean pSiTyouhyouHensyuuCommonBean) {
        siTyouhyouHensyuuCommonBean = pSiTyouhyouHensyuuCommonBean;
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        syoNo = pSyoNo;
    }

    public String getKyknmKj() {
        return kyknmKj;
    }

    public void setKyknmKj(String pKyknmKj) {
        kyknmKj = pKyknmKj;
    }

    public String getHhknnmKj() {
        return hhknnmKj;
    }

    public void setHhknnmKj(String pHhknnmKj) {
        hhknnmKj = pHhknnmKj;
    }

    public String getUktnmKj() {
        return uktnmKj;
    }

    public void setUktnmKj(String pUktnmKj) {
        uktnmKj = pUktnmKj;
    }

    public C_SUketoriHouhouKbn getUkthouKbn() {
        return ukthouKbn;
    }

    public void setUkthouKbn(C_SUketoriHouhouKbn pUkthouKbn) {
        ukthouKbn = pUkthouKbn;
    }

    public BizDate getCalckijyunYmd() {
        return calckijyunYmd;
    }

    public void setCalckijyunYmd(BizDate pCalckijyunYmd) {
        calckijyunYmd = pCalckijyunYmd;
    }

    public String getUktbnWari() {
        return uktbnWari;
    }

    public void setUktbnWari(String pUktbnWari) {
        uktbnWari = pUktbnWari;
    }

    public BizCurrency getHkgkGaika() {
        return hkgkGaika;
    }

    public void setHkgkGaika(BizCurrency pHkgkGaika) {
        hkgkGaika = pHkgkGaika;
    }

    public BizCurrency getHkgkYen() {
        return hkgkYen;
    }

    public void setHkgkYen(BizCurrency pHkgkYen) {
        hkgkYen = pHkgkYen;
    }

    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }

    public SiHkkingakuSisanParamBean getSiHkkingakuSisanParamBean() {
        return siHkkingakuSisanParamBean;
    }

    public void setSiHkkingakuSisanParamBean(SiHkkingakuSisanParamBean siHkkingakuSisanParamBean) {
        this.siHkkingakuSisanParamBean = siHkkingakuSisanParamBean;
    }

    public List<SiSiDetailParamBean> getSiSiDetailParamBeanList() {
        return siSiDetailParamBeanList;
    }

    public void setSiSiDetailParamBeanList(List<SiSiDetailParamBean> siSiDetailParamBeanList) {
        this.siSiDetailParamBeanList = siSiDetailParamBeanList;
    }
}
