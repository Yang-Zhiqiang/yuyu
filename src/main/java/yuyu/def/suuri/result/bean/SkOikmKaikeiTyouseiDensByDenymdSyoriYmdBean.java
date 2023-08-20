
package yuyu.def.suuri.result.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;

/**
 * 新契約追込会計取引データ（調整伝票用）Beanクラスです。<br />
 */
public class SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean implements Serializable {

    public SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean(){

    }

    public SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean(String pMosno,
        C_Kanjyoukmkcd pPanjyoukmkcd,
        C_TaisyakuKbn pTaisyakukbn,
        C_NaibuKeiyakuKbn pNaibukeiyakukbn,
        C_TekiyouKbn pTekiyoukbn,
        C_Segcd pSeg1cd,
        String pHuridenatesakicd,
        C_TantouCdKbn pTantocd,
        String pSuitoubumoncd,
        String pDenyenkagkType,
        BigDecimal pDenyenkagkValue,
        String pDenkanjokamokucd) {

        mosno = pMosno;
        kanjyoukmkcd = pPanjyoukmkcd;
        taisyakukbn = pTaisyakukbn;
        naibukeiyakukbn = pNaibukeiyakukbn;
        tekiyoukbn = pTekiyoukbn;
        seg1cd = pSeg1cd;
        huridenatesakicd = pHuridenatesakicd;
        tantocd = pTantocd;
        suitoubumoncd = pSuitoubumoncd;
        denyenkagk = new BizCurrencySum(pDenyenkagkType, pDenyenkagkValue).toBizCurrency();
        denkanjokamokucd = pDenkanjokamokucd;
    }

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String mosno;

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
    private String huridenatesakicd;

    @Getter @Setter
    private C_TantouCdKbn tantocd;

    @Getter @Setter
    private String suitoubumoncd;

    @Getter @Setter
    private BizCurrency denyenkagk;

    @Getter @Setter
    private String denkanjokamokucd;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
