package yuyu.def.biz.result.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KanjyoukmkgroupKbn;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TekiyouKbn;

/**
 * 新契約本社用伝票データ集計Beanです。<br />
 */
public class BzSkHonsyaDenpyousByDenymdTaisyakukbnBean implements Serializable {

    public BzSkHonsyaDenpyousByDenymdTaisyakukbnBean(
        C_KanjyoukmkgroupKbn pKanjyoukmkgroupkbn, String pKanjyoukmknm, C_Kanjyoukmkcd pKanjyoukmkcd,
        C_NaibuKeiyakuKbn pNaibukeiyakukbn, C_TekiyouKbn pTekiyoukbn, C_TaisyakuKbn pTaisyakukbn,
        String pDenyenkagkSumType, BigDecimal pDenyenkagkSumValue, Long pDenyenkagkCount) {

        kanjyoukmkgroupkbn = pKanjyoukmkgroupkbn;
        kanjyoukmknm = pKanjyoukmknm;
        kanjyoukmkcd = pKanjyoukmkcd;
        naibukeiyakukbn = pNaibukeiyakukbn;
        tekiyoukbn = pTekiyoukbn;
        taisyakukbn = pTaisyakukbn;
        denyenkagkSum = new BizCurrencySum(pDenyenkagkSumType, pDenyenkagkSumValue).toBizCurrency();
        denyenkagkCount = pDenyenkagkCount;

    }

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private C_KanjyoukmkgroupKbn kanjyoukmkgroupkbn;

    @Getter @Setter
    private String kanjyoukmknm;

    @Getter @Setter
    private C_Kanjyoukmkcd kanjyoukmkcd;

    @Getter @Setter
    private C_NaibuKeiyakuKbn naibukeiyakukbn;

    @Getter @Setter
    private C_TekiyouKbn tekiyoukbn;

    @Getter @Setter
    private C_TaisyakuKbn taisyakukbn;

    @Getter @Setter
    private BizCurrency denyenkagkSum;

    @Getter @Setter
    private Long denyenkagkCount;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
