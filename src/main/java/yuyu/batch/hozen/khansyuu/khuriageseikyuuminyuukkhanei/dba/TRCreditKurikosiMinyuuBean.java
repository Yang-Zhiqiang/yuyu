package yuyu.batch.hozen.khansyuu.khuriageseikyuuminyuukkhanei.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;

/**
 * 契約保全 案内収納 クレカ繰越未入ＴＲテーブルBeanクラスです。
 */
public class TRCreditKurikosiMinyuuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String syono;

    @Getter
    @Setter
    private C_NyknaiyouKbn nyknaiyoukbn;

    @Getter
    @Setter
    private BizDateYM jyuutouym;

    @Getter
    @Setter
    private C_Nykkeiro nykkeiro;

    @Getter
    @Setter
    private Integer jyutoukaisuuy;

    @Getter
    @Setter
    private Integer jyutoukaisuum;

    @Getter
    @Setter
    private BizCurrency rsgaku;

    @Getter
    @Setter
    private BizDate ryosyuymd;

    @Getter
    @Setter
    private C_CreditUriageNgJiyuuKbn credituriagengjiyuu;

    @Getter
    @Setter
    private String kbnkey;

    public TRCreditKurikosiMinyuuBean(
        String pSyono,
        C_NyknaiyouKbn pNyknaiyouKbn,
        BizDateYM pJyuutouYm,
        C_Nykkeiro pNykkeiro,
        Integer pJyutouKaisuuy,
        Integer pJyutouKaisuum,
        String pRsgakuTypefieldname,
        BigDecimal pRsgakuValuefieldname,
        BizDate pRyosyuYmd,
        C_CreditUriageNgJiyuuKbn pCreditUriageNgJiyuu,
        String pKbnkey) {
        syono = pSyono;
        nyknaiyoukbn = pNyknaiyouKbn;
        jyuutouym = pJyuutouYm;
        nykkeiro = pNykkeiro;
        jyutoukaisuuy = pJyutouKaisuuy;
        jyutoukaisuum = pJyutouKaisuum;
        ryosyuymd = pRyosyuYmd;
        credituriagengjiyuu = pCreditUriageNgJiyuu;
        rsgaku = new BizCurrencySum(pRsgakuTypefieldname, pRsgakuValuefieldname).toBizCurrency();
        kbnkey = pKbnkey;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
