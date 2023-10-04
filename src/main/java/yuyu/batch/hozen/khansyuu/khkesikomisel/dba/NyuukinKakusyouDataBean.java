package yuyu.batch.hozen.khansyuu.khkesikomisel.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.classification.C_KrkPayEasyHrkmyousiNkKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NyuuryokuKbn;
import yuyu.def.classification.C_Syuudaikocd;

/**
 * 契約保全 案内収納 入金確証データBeanクラス<br />
 */
public class NyuukinKakusyouDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String nyuukinkakusyouno;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate nyuukinkakusyounrkymd;

    @Getter @Setter
    private C_Nykkeiro nykkeiro;

    @Getter @Setter
    private C_NyknaiyouKbn nyknaiyoukbn;

    @Getter @Setter
    private BizDateYM jyuutouym;

    @Getter @Setter
    private BizCurrency rsgaku;

    @Getter @Setter
    private BizDate ryosyuymd;

    @Getter @Setter
    private BizDate nykdenymd;

    @Getter @Setter
    private String suitoubumoncd;

    @Getter @Setter
    private String kzhurikaebankcd;

    @Getter @Setter
    private String tabakarikanjyono;

    @Getter @Setter
    private C_KrkPayEasyHrkmyousiNkKbn hrkmyousinkkbn;

    @Getter @Setter
    private String suitososhikicd;

    @Getter @Setter
    private C_NyuuryokuKbn nyuuryokukbn;

    @Getter @Setter
    private String nyuukinkakusyounrkno;

    @Getter @Setter
    private String suitono;

    @Getter @Setter
    private C_Syuudaikocd syuudaikocd;

    @Getter @Setter
    private C_CreditUriageSeikyuuKbn creditUriageSeikyuuKbn;

    public NyuukinKakusyouDataBean(String pKbnkey,
        String pNyuukinkakusyouno,
        String pSyono,
        BizDate  pNyuukinkakusyounrkymd,
        C_NyuuryokuKbn pNyuuryokukbn,
        C_Nykkeiro pNykkeiro,
        C_NyknaiyouKbn pNyknaiyoukbn,
        BizDateYM  pJyuutouym,
        String pType,
        BigDecimal pValue,
        BizDate  pRyosyuymd,
        BizDate pNykdenymd,
        String pNyuukinkakusyounrkno,
        String pSuitono,
        String pSuitoubumoncd,
        String pKzhurikaebankcd,
        String pTabakarikanjyono,
        C_KrkPayEasyHrkmyousiNkKbn pHrkmyousinkkbn,
        String pSuitososhikicd,
        C_Syuudaikocd pSyuudaikocd,
        C_CreditUriageSeikyuuKbn pCreditUriageSeikyuuKbn
        ) {
        kbnkey = pKbnkey;
        nyuukinkakusyouno = pNyuukinkakusyouno;
        syono = pSyono;
        nyuukinkakusyounrkymd = pNyuukinkakusyounrkymd;
        nyuuryokukbn = pNyuuryokukbn;
        nykkeiro = pNykkeiro;
        nyknaiyoukbn = pNyknaiyoukbn;
        jyuutouym = pJyuutouym;
        rsgaku = new BizCurrencySum(pType, pValue).toBizCurrency();
        ryosyuymd = pRyosyuymd;
        nykdenymd = pNykdenymd;
        nyuukinkakusyounrkno = pNyuukinkakusyounrkno;
        suitono = pSuitono;
        suitoubumoncd = pSuitoubumoncd;
        kzhurikaebankcd = pKzhurikaebankcd;
        tabakarikanjyono = pTabakarikanjyono;
        hrkmyousinkkbn = pHrkmyousinkkbn;
        suitososhikicd = pSuitososhikicd;
        syuudaikocd = pSyuudaikocd;
        creditUriageSeikyuuKbn = pCreditUriageSeikyuuKbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
