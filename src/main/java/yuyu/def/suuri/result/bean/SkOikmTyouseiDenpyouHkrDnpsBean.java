
package yuyu.def.suuri.result.bean;

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
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;

/**
 * 新契約追込保険料伝票データ（保険料伝票用）Beanクラスです。<br />
 */
public class SkOikmTyouseiDenpyouHkrDnpsBean implements Serializable {
    public SkOikmTyouseiDenpyouHkrDnpsBean() {
    }

    public SkOikmTyouseiDenpyouHkrDnpsBean(C_Kanjyoukmkcd pKanjyoukmkcd,
        C_TaisyakuKbn pTaisyakukbn,
        C_NaibuKeiyakuKbn pNaibukeiyakukbn,
        C_TekiyouKbn pTekiyoukbn,
        C_Segcd pSeg1cd,
        String denyenkagkType,
        BigDecimal denyenkagkValue,
        String pHuridenatesakicd,
        C_TantouCdKbn pTantocd,
        String pTekiyoucd,
        C_KanjyoukmkgroupKbn pKanjyoukmkgroupkbn,
        String pKanjyoukmknm,
        String pSegnm
        ){
        kanjyoukmkcd = pKanjyoukmkcd;
        taisyakukbn = pTaisyakukbn;
        naibukeiyakukbn = pNaibukeiyakukbn;
        tekiyoukbn = pTekiyoukbn;
        seg1cd = pSeg1cd;
        denyenkagk = new BizCurrencySum(denyenkagkType,denyenkagkValue).toBizCurrency();
        huridenatesakicd = pHuridenatesakicd;
        tantocd = pTantocd;
        tekiyoucd = pTekiyoucd;
        kanjyoukmkgroupkbn = pKanjyoukmkgroupkbn;
        kanjyoukmknm = pKanjyoukmknm;
        segnm = pSegnm;
    }

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private C_Kanjyoukmkcd kanjyoukmkcd;

    @Getter @Setter
    private C_TaisyakuKbn taisyakukbn;

    @Getter @Setter
    private C_NaibuKeiyakuKbn naibukeiyakukbn;

    @Getter @Setter
    private C_TekiyouKbn tekiyoukbn;

    @Getter @Setter
    private C_Segcd seg1cd;

    @Getter @Setter
    private BizCurrency denyenkagk;

    @Getter @Setter
    private String huridenatesakicd;

    @Getter @Setter
    private C_TantouCdKbn tantocd;

    @Getter @Setter
    private String tekiyoucd;

    @Getter @Setter
    private C_KanjyoukmkgroupKbn kanjyoukmkgroupkbn;

    @Getter @Setter
    private String kanjyoukmknm;

    @Getter @Setter
    private String segnm;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
