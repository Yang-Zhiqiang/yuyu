package yuyu.common.siharai.sicommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 保険金給付金支払 保険金給付金支払共通 端数月未収Ｐ編集入力Bean
 */
public class HasuuMsyPHensyuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer misyuupjyuutoukaisuuy;

    private Integer misyuupjyuutoukaisuum;

    private BizDateYM misyuupjyuutouym;

    private BizCurrency misyuup;

    private BizCurrency yenkamisyuup;

    private Integer mikeikapjyuutoukaisuuy;

    private Integer mikeikapjyuutoukaisuum;

    private BizDateYM mikeikapjyuutouym;

    private BizCurrency mikeikap;

    private BizCurrency yenkamikeikap;

    private C_Tuukasyu kyktuukasyu;

    private  BizNumber kwsrate;

    public HasuuMsyPHensyuBean() {
        super();
    }

    public Integer getMisyuupjyuutoukaisuuy() {
        return misyuupjyuutoukaisuuy;
    }

    public void setMisyuupjyuutoukaisuuy(Integer pMisyuupjyuutoukaisuuy) {
        misyuupjyuutoukaisuuy = pMisyuupjyuutoukaisuuy;
    }

    public Integer getMisyuupjyuutoukaisuum() {
        return misyuupjyuutoukaisuum;
    }

    public void setMisyuupjyuutoukaisuum(Integer pMisyuupjyuutoukaisuum) {
        misyuupjyuutoukaisuum = pMisyuupjyuutoukaisuum;
    }

    public BizDateYM getMisyuupjyuutouym() {
        return misyuupjyuutouym;
    }

    public void setMisyuupjyuutouym(BizDateYM pMisyuupjyuutouym) {
        misyuupjyuutouym = pMisyuupjyuutouym;
    }

    public BizCurrency getMisyuup() {
        return misyuup;
    }

    public void setMisyuup(BizCurrency pMisyuup) {
        misyuup = pMisyuup;
    }

    public BizCurrency getYenkamisyuup() {
        return yenkamisyuup;
    }

    public void setYenkamisyuup(BizCurrency pYenkamisyuup) {
        yenkamisyuup = pYenkamisyuup;
    }

    public Integer getMikeikapjyuutoukaisuuy() {
        return mikeikapjyuutoukaisuuy;
    }

    public void setMikeikapjyuutoukaisuuy(Integer pMikeikapjyuutoukaisuuy) {
        mikeikapjyuutoukaisuuy = pMikeikapjyuutoukaisuuy;
    }

    public Integer getMikeikapjyuutoukaisuum() {
        return mikeikapjyuutoukaisuum;
    }

    public void setMikeikapjyuutoukaisuum(Integer pMikeikapjyuutoukaisuum) {
        mikeikapjyuutoukaisuum = pMikeikapjyuutoukaisuum;
    }

    public BizDateYM getMikeikapjyuutouym() {
        return mikeikapjyuutouym;
    }

    public void setMikeikapjyuutouym(BizDateYM pMikeikapjyuutouym) {
        mikeikapjyuutouym = pMikeikapjyuutouym;
    }

    public BizCurrency getMikeikap() {
        return mikeikap;
    }

    public void setMikeikap(BizCurrency pMikeikap) {
        mikeikap = pMikeikap;
    }

    public BizCurrency getYenkamikeikap() {
        return yenkamikeikap;
    }

    public void setYenkamikeikap(BizCurrency pYenkamikeikap) {
        yenkamikeikap = pYenkamikeikap;
    }

    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    public BizNumber getKwsrate() {
        return kwsrate;
    }

    public void setKwsrate(BizNumber pKwsrate) {
        kwsrate = pKwsrate;
    }
}