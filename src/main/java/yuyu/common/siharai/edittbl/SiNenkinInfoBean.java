package yuyu.common.siharai.edittbl;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Bnshrkaisuu;
import yuyu.def.classification.C_NkHaitoukinuketorihouKbn;
import yuyu.def.classification.C_Nstknsyu;

/**
 * 保険金給付金支払 保険金給付金支払共通 年金情報パラメータBean
 */
public class SiNenkinInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate nkkknsetymd;

    private BizDate nkshrstartymd;

    private C_Nstknsyu nkshrtkyknksyukbn;

    private Integer nkshrtkyknksyukkn;

    private C_Bnshrkaisuu bnshrkaisuu;

    private C_NkHaitoukinuketorihouKbn nkhaitoukinuketorihoukbn;

    private BizCurrency teinkkikingkgaika;

    private BizCurrency teinkkikingken;

    private BizCurrency htykeihi;

    private BizCurrency yenhtykeihi;

    private BizCurrency nknengk;

    private BizCurrency bnktnkgk;

    public SiNenkinInfoBean() {
        nkkknsetymd = null;
        nkshrstartymd = null;
        nkshrtkyknksyukbn = C_Nstknsyu.BLNK;
        nkshrtkyknksyukkn = 0;
        bnshrkaisuu = C_Bnshrkaisuu.BLNK;
        nkhaitoukinuketorihoukbn = C_NkHaitoukinuketorihouKbn.NONE;
        teinkkikingkgaika = BizCurrency.valueOf(0);
        teinkkikingken = BizCurrency.valueOf(0);
        htykeihi = BizCurrency.valueOf(0);
        yenhtykeihi = BizCurrency.valueOf(0);
        nknengk = BizCurrency.valueOf(0);
        bnktnkgk = BizCurrency.valueOf(0);
    }

    public BizDate getNkkknsetymd() {
        return nkkknsetymd;
    }

    public void setNkkknsetymd(BizDate pNkkknsetymd) {
        nkkknsetymd = pNkkknsetymd;
    }

    public BizDate getNkshrstartymd() {
        return nkshrstartymd;
    }

    public void setNkshrstartymd(BizDate pNkshrstartymd) {
        nkshrstartymd = pNkshrstartymd;
    }

    public C_Nstknsyu getNkshrtkyknksyukbn() {
        return nkshrtkyknksyukbn;
    }

    public void setNkshrtkyknksyukbn(C_Nstknsyu pNkshrtkyknksyukbn) {
        nkshrtkyknksyukbn = pNkshrtkyknksyukbn;
    }

    public Integer getNkshrtkyknksyukkn() {
        return nkshrtkyknksyukkn;
    }

    public void setNkshrtkyknksyukkn(Integer pNkshrtkyknksyukkn) {
        nkshrtkyknksyukkn = pNkshrtkyknksyukkn;
    }

    public C_Bnshrkaisuu getBnshrkaisuu() {
        return bnshrkaisuu;
    }

    public void setBnshrkaisuu(C_Bnshrkaisuu pBnshrkaisuu) {
        bnshrkaisuu = pBnshrkaisuu;
    }

    public C_NkHaitoukinuketorihouKbn getNkhaitoukinuketorihoukbn() {
        return nkhaitoukinuketorihoukbn;
    }

    public void setNkhaitoukinuketorihoukbn(C_NkHaitoukinuketorihouKbn pNkhaitoukinuketorihoukbn) {
        nkhaitoukinuketorihoukbn = pNkhaitoukinuketorihoukbn;
    }

    public BizCurrency getTeinkkikingkgaika() {
        return teinkkikingkgaika;
    }

    public void setTeinkkikingkgaika(BizCurrency pTeinkkikingkgaika) {
        teinkkikingkgaika = pTeinkkikingkgaika;
    }

    public BizCurrency getTeinkkikingken() {
        return teinkkikingken;
    }

    public void setTeinkkikingken(BizCurrency pTeinkkikingken) {
        teinkkikingken = pTeinkkikingken;
    }

    public BizCurrency getHtykeihi() {
        return htykeihi;
    }

    public void setHtykeihi(BizCurrency pHtykeihi) {
        htykeihi = pHtykeihi;
    }

    public BizCurrency getYenhtykeihi() {
        return yenhtykeihi;
    }

    public void setYenhtykeihi(BizCurrency pYenhtykeihi) {
        yenhtykeihi = pYenhtykeihi;
    }

    public BizCurrency getNknengk() {
        return nknengk;
    }

    public void setNknengk(BizCurrency pNknengk) {
        nknengk = pNknengk;
    }

    public BizCurrency getBnktnkgk() {
        return bnktnkgk;
    }

    public void setBnktnkgk(BizCurrency pBnktnkgk) {
        bnktnkgk = pBnktnkgk;
    }

}
