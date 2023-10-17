package yuyu.batch.biz.bzkaikei.bzkbtkarikanjyouzndksykilstsks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_TaisyakuKbn;

/**
 * 業務共通 経理・会計 個別仮勘定データBeanクラス
 */
public class KbtKarikanjyouDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String huridenatesakicd;

    @Getter
    @Setter
    private C_Kanjyoukmkcd kanjyoukmkcd;

    @Getter
    @Setter
    private BizDate denymd;

    @Getter
    @Setter
    private C_TaisyakuKbn taisyakuKbn;

    @Getter
    @Setter
    private BizCurrency denyenkagk;

    @Getter
    @Setter
    private long kensuu;

    public KbtKarikanjyouDataBean(String pHuridenatesakicd,
        C_Kanjyoukmkcd pKanjyoukmkcd,
        BizDate pHenymd,
        C_TaisyakuKbn pTaisyakuKbn,
        String pDenyenkagkType,
        BigDecimal pDenyenkagkValue,
        long pKensuu) {
        huridenatesakicd = pHuridenatesakicd;
        kanjyoukmkcd = pKanjyoukmkcd;
        denymd = pHenymd;
        taisyakuKbn = pTaisyakuKbn;
        denyenkagk = new BizCurrencySum(pDenyenkagkType, pDenyenkagkValue).toBizCurrency();
        kensuu = pKensuu;
    }

    public KbtKarikanjyouDataBean(String pHuridenatesakicd,
        C_Kanjyoukmkcd pKanjyoukmkcd,
        C_TaisyakuKbn pTaisyakuKbn,
        String pDenyenkagkType,
        BigDecimal pDenyenkagkValue,
        long pKensuu) {
        huridenatesakicd = pHuridenatesakicd;
        kanjyoukmkcd = pKanjyoukmkcd;
        taisyakuKbn = pTaisyakuKbn;
        denyenkagk = new BizCurrencySum(pDenyenkagkType, pDenyenkagkValue).toBizCurrency();
        kensuu = pKensuu;
    }

    public KbtKarikanjyouDataBean(C_Kanjyoukmkcd pKanjyoukmkcd,
        C_TaisyakuKbn pTaisyakuKbn,
        String pDenyenkagkType,
        BigDecimal pDenyenkagkValue,
        long pKensuu) {
        kanjyoukmkcd = pKanjyoukmkcd;
        taisyakuKbn = pTaisyakuKbn;
        denyenkagk = new BizCurrencySum(pDenyenkagkType, pDenyenkagkValue).toBizCurrency();
        kensuu = pKensuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
