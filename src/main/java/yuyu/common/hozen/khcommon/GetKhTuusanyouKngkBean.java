package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 契約保全共通 通算用金額取得Beanクラス
 */
public class GetKhTuusanyouKngkBean {

    private C_Tuukasyu tsnyouTuukasyu;

    private BizCurrency tsnyouSibous;

    private BizCurrency tsnyouItijip;

    private BizCurrency tsnyouNkgns;

    private BizCurrency tsnyouYennyknkgk;

    public C_Tuukasyu getTsnyouTuukasyu() {
        return tsnyouTuukasyu;
    }

    public void setTsnyouTuukasyu(C_Tuukasyu pTsnyouTuukasyu) {
        tsnyouTuukasyu = pTsnyouTuukasyu;
    }

    public BizCurrency getTsnyouSibous() {
        return tsnyouSibous;
    }

    public void setTsnyouSibous(BizCurrency pTsnyouSibous) {
        tsnyouSibous = pTsnyouSibous;
    }

    public BizCurrency getTsnyouItijip() {
        return tsnyouItijip;
    }

    public void setTsnyouItijip(BizCurrency pTsnyouItijip) {
        tsnyouItijip = pTsnyouItijip;
    }

    public BizCurrency getTsnyouNkgns() {
        return tsnyouNkgns;
    }

    public void setTsnyouNkgns(BizCurrency pTsnyouNkgns) {
        tsnyouNkgns = pTsnyouNkgns;
    }

    public BizCurrency getTsnyouYennyknkgk() {
        return tsnyouYennyknkgk;
    }

    public void setTsnyouYennyknkgk(BizCurrency pTsnyouYennyknkgk) {
        tsnyouYennyknkgk = pTsnyouYennyknkgk;
    }
}