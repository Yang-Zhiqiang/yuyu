package yuyu.batch.hozen.khinterf.khkesikomisks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_CreditcardHrKskmKbn;
import yuyu.def.classification.C_KrkPayEasyHrkmyousiNkKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NyuuryokuKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TaisyakuKbn;

/**
 * 契約保全 インターフェイス 消込データテーブルエンティティBeanクラスです。<br />
 */
public class ItKhKesikomiDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String nyuukinkakusyouno;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private C_NyknaiyouKbn nyknaiyoukbn;

    @Getter @Setter
    private C_NyuuryokuKbn nyuuryokukbn;

    @Getter @Setter
    private C_Nykkeiro nykkeiro;

    @Getter @Setter
    private BizDateYM jyuutouym;

    @Getter @Setter
    private BizDate nyuukinkakusyounrkymd;

    @Getter @Setter
    private BizDate ryosyuymd;

    @Getter @Setter
    private BizCurrency rsgaku;

    @Getter @Setter
    private BizDate nykdenymd;

    @Getter @Setter
    private String nyuukinkakusyounrkno;

    @Getter @Setter
    private C_TaisyakuKbn taisyakukbn;

    @Getter @Setter
    private String suitono;

    @Getter @Setter
    private String suitoubumoncd;

    @Getter @Setter
    private String kzhurikaebankcd;

    @Getter @Setter
    private String karikanjyono;

    @Getter @Setter
    private C_KrkPayEasyHrkmyousiNkKbn hrkmyousinkkbn;

    @Getter @Setter
    private String suitososhikicd;

    @Getter @Setter
    private C_CreditcardHrKskmKbn creditcardhrkskmKbn;

    @Getter @Setter
    private C_Syuudaikocd syuudaikocd;

    public ItKhKesikomiDataBean(String pKbnkey,
        String pNyuukinkakusyouno,
        String pSyono,
        C_NyknaiyouKbn pNyknaiyoukbn,
        C_NyuuryokuKbn pNyuuryokukbn,
        C_Nykkeiro pNykkeiro,
        BizDateYM pJyuutouym,
        BizDate pNyuukinkakusyounrkymd,
        BizDate pRyosyuymd,
        String pType,
        BigDecimal pValue,
        BizDate pNykdenymd,
        String pNyuukinkakusyounrkno,
        C_TaisyakuKbn pTaisyakukbn,
        String pSuitono,
        String pSuitoubumoncd,
        String pKzhurikaebankcd,
        String pKarikanjyono,
        C_KrkPayEasyHrkmyousiNkKbn pHrkmyousinkkbn,
        String pSuitososhikicd,
        C_CreditcardHrKskmKbn pCreditcardhrkskmKbn,
        C_Syuudaikocd pSyuudaikocd) {
        kbnkey = pKbnkey;
        nyuukinkakusyouno = pNyuukinkakusyouno;
        syono = pSyono;
        nyknaiyoukbn = pNyknaiyoukbn;
        nyuuryokukbn = pNyuuryokukbn;
        nykkeiro = pNykkeiro;
        jyuutouym = pJyuutouym;
        nyuukinkakusyounrkymd = pNyuukinkakusyounrkymd;
        ryosyuymd = pRyosyuymd;
        rsgaku = new BizCurrencySum(pType, pValue).toBizCurrency();
        nykdenymd = pNykdenymd;
        nyuukinkakusyounrkno = pNyuukinkakusyounrkno;
        taisyakukbn = pTaisyakukbn;
        suitono = pSuitono;
        suitoubumoncd = pSuitoubumoncd;
        kzhurikaebankcd = pKzhurikaebankcd;
        karikanjyono = pKarikanjyono;
        hrkmyousinkkbn = pHrkmyousinkkbn;
        suitososhikicd = pSuitososhikicd;
        creditcardhrkskmKbn = pCreditcardhrkskmKbn;
        syuudaikocd = pSyuudaikocd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
