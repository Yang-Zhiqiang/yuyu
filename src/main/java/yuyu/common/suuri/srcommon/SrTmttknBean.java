package yuyu.common.suuri.srcommon;

import java.io.Serializable;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 数理 数理共通 数理用積立金Bean
 */
public class SrTmttknBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDateYM tumitateYM;

    private BizCurrency tmttKngk;

    private BizCurrency vTyouseimae;

    private BizCurrency kiharaikomiP;

    private BizNumber yoteiSinkeiyakuhiritu;

    private BizNumber yoteiIjihirituPhirei;

    private BizNumber yoteiIjihirituVhirei;

    private BizNumber yoteiSyuukinhiritu;

    private BizNumber kogakuWaribikiritu;

    private BizNumber zettaiSibouritu;

    private BizNumber soutaiSibouritu;

    private BizNumber soutaiKaiyakuritu;

    private BizNumber yoteiriritu;

    private BizNumber kawaserate;

    private BizCurrency hokenryou;

    public SrTmttknBean() {

    }

    public BizDateYM getTumitateYM() {
        return tumitateYM;
    }

    public void setTumitateYM(BizDateYM pTumitateYM) {
        this.tumitateYM = pTumitateYM;
    }

    public BizCurrency getTmttKngk() {
        return tmttKngk;
    }

    public void setTmttKngk(BizCurrency pTmttKngk) {
        this.tmttKngk = pTmttKngk;
    }

    public BizCurrency getvTyouseimae() {
        return vTyouseimae;
    }

    public void setvTyouseimae(BizCurrency pvTyouseimae) {
        this.vTyouseimae = pvTyouseimae;
    }

    public BizCurrency getKiharaikomiP() {
        return kiharaikomiP;
    }

    public void setKiharaikomiP(BizCurrency pKiharaikomiP) {
        this.kiharaikomiP = pKiharaikomiP;
    }

    public BizNumber getYoteiSinkeiyakuhiritu() {
        return yoteiSinkeiyakuhiritu;
    }

    public void setYoteiSinkeiyakuhiritu(BizNumber pYoteiSinkeiyakuhiritu) {
        this.yoteiSinkeiyakuhiritu = pYoteiSinkeiyakuhiritu;
    }

    public BizNumber getYoteiIjihirituPhirei() {
        return yoteiIjihirituPhirei;
    }

    public void setYoteiIjihirituPhirei(BizNumber pYoteiIjihirituPhirei) {
        this.yoteiIjihirituPhirei = pYoteiIjihirituPhirei;
    }

    public BizNumber getYoteiIjihirituVhirei() {
        return yoteiIjihirituVhirei;
    }

    public void setYoteiIjihirituVhirei(BizNumber pYoteiIjihirituVhirei) {
        this.yoteiIjihirituVhirei = pYoteiIjihirituVhirei;
    }

    public BizNumber getYoteiSyuukinhiritu() {
        return yoteiSyuukinhiritu;
    }

    public void setYoteiSyuukinhiritu(BizNumber pYoteiSyuukinhiritu) {
        this.yoteiSyuukinhiritu = pYoteiSyuukinhiritu;
    }

    public BizNumber getKogakuWaribikiritu() {
        return kogakuWaribikiritu;
    }

    public void setKogakuWaribikiritu(BizNumber pKogakuWaribikiritu) {
        this.kogakuWaribikiritu = pKogakuWaribikiritu;
    }

    public BizNumber getZettaiSibouritu() {
        return zettaiSibouritu;
    }

    public void setZettaiSibouritu(BizNumber pZettaiSibouritu) {
        this.zettaiSibouritu = pZettaiSibouritu;
    }

    public BizNumber getSoutaiSibouritu() {
        return soutaiSibouritu;
    }

    public void setSoutaiSibouritu(BizNumber pSoutaiSibouritu) {
        this.soutaiSibouritu = pSoutaiSibouritu;
    }

    public BizNumber getSoutaiKaiyakuritu() {
        return soutaiKaiyakuritu;
    }

    public void setSoutaiKaiyakuritu(BizNumber pSoutaiKaiyakuritu) {
        this.soutaiKaiyakuritu = pSoutaiKaiyakuritu;
    }

    public BizNumber getYoteiriritu() {
        return yoteiriritu;
    }

    public void setYoteiriritu(BizNumber pYoteiriritu) {
        this.yoteiriritu = pYoteiriritu;
    }

    public BizNumber getKawaserate() {
        return kawaserate;
    }

    public void setKawaserate(BizNumber pKawaserate) {
        this.kawaserate = pKawaserate;
    }

    public BizCurrency getHokenryou() {
        return hokenryou;
    }

    public void setHokenryou(BizCurrency pHokenryou) {
        this.hokenryou = pHokenryou;
    }

}
