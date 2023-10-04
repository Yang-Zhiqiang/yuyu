package yuyu.batch.hozen.khansyuu.khpminyuusyoumetu;

import java.io.Serializable;

import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_UmuKbn;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 契約保全 案内収納 発生時課税情報作成パラメータ
 */
public class HasseijikziInfoSksParam implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_HtsiryosyuKbn  shrtysysyuruiKbn;

    private BizCurrency shrgkkeiYen;

    private BizCurrency kaiyakuHrYen;

    private BizCurrency haitoukinYen;

    private BizCurrency yentkbthaitoukin;

    private BizCurrency mihrkmp;

    private BizDate shrkwsratekjnymd;

    private BizNumber shrkwsrate;

    private BizCurrency synykngk;

    private BizCurrency htykeihi;

    private BizCurrency yenShrkykhtykeihi;

    private Integer kykhnkKaisuu;

    private C_UmuKbn gsbunritaisyouFlg;

    public HasseijikziInfoSksParam() {
        super();
    }

    public C_HtsiryosyuKbn  getShrtysysyuruiKbn() {
        return shrtysysyuruiKbn;
    }

    public void setShrtysysyuruiKbn(C_HtsiryosyuKbn  pShrtysysyuruiKbn) {
        shrtysysyuruiKbn = pShrtysysyuruiKbn;
    }

    public BizCurrency getShrgkkeiYen() {
        return shrgkkeiYen;
    }

    public void setShrgkkeiYen(BizCurrency pShrgkkeiYen) {
        shrgkkeiYen = pShrgkkeiYen;
    }

    public BizCurrency getKaiyakuHrYen() {
        return kaiyakuHrYen;
    }

    public void setKaiyakuHrYen(BizCurrency pKaiyakuHrYen) {
        kaiyakuHrYen = pKaiyakuHrYen;
    }

    public BizCurrency getHaitoukinYen() {
        return haitoukinYen;
    }

    public void setHaitoukinYen(BizCurrency pHaitoukinYen) {
        haitoukinYen = pHaitoukinYen;
    }

    public BizCurrency getYentkbthaitoukin() {
        return yentkbthaitoukin;
    }

    public void setYentkbthaitoukin(BizCurrency pYentkbthaitoukin) {
        yentkbthaitoukin = pYentkbthaitoukin;
    }

    public BizCurrency getMihrkmp() {
        return mihrkmp;
    }

    public void setMihrkmp(BizCurrency pMihrkmp) {
        mihrkmp = pMihrkmp;
    }

    public BizDate getShrkwsratekjnymd() {
        return shrkwsratekjnymd;
    }

    public void setShrkwsratekjnymd(BizDate pShrkwsratekjnymd) {
        shrkwsratekjnymd = pShrkwsratekjnymd;
    }

    public BizNumber getShrkwsrate() {
        return shrkwsrate;
    }

    public void setShrkwsrate(BizNumber pShrkwsrate) {
        shrkwsrate = pShrkwsrate;
    }

    public BizCurrency getSynykngk() {
        return synykngk;
    }

    public void setSynykngk(BizCurrency pSynykngk) {
        synykngk = pSynykngk;
    }

    public BizCurrency getHtykeihi() {
        return htykeihi;
    }

    public void setHtykeihi(BizCurrency pHtykeihi) {
        htykeihi = pHtykeihi;
    }

    public BizCurrency getYenShrkykhtykeihi() {
        return yenShrkykhtykeihi;
    }

    public void setYenShrkykhtykeihi(BizCurrency pYenShrkykhtykeihi) {
        yenShrkykhtykeihi = pYenShrkykhtykeihi;
    }

    public Integer getKykhnkKaisuu() {
        return kykhnkKaisuu;
    }

    public void setKykhnkKaisuu(Integer pKykhnkKaisuu) {
        kykhnkKaisuu = pKykhnkKaisuu;
    }

    public C_UmuKbn getGsbunritaisyouFlg() {
        return gsbunritaisyouFlg;
    }

    public void setGsbunritaisyouFlg(C_UmuKbn pGsbunritaisyouFlg) {
        gsbunritaisyouFlg = pGsbunritaisyouFlg;
    }

}
