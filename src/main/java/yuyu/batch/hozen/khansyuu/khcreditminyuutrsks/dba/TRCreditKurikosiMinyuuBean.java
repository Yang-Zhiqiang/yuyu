package yuyu.batch.hozen.khansyuu.khcreditminyuutrsks.dba;

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
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * クレカ繰越未入ＴＲBeanクラス<br />
 */
public class TRCreditKurikosiMinyuuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate syoriYmd;

    @Getter @Setter
    private String minyuutrrenno;

    @Getter @Setter
    private C_Nykkeiro nykkeiro;

    @Getter @Setter
    private C_NyknaiyouKbn nyknaiyoukbn;

    @Getter @Setter
    private BizDateYM jyuutouym;

    @Getter @Setter
    private Integer jyutoukaisuuy;

    @Getter @Setter
    private Integer jyutoukaisuum;

    @Getter @Setter
    private BizCurrency rsgaku;

    @Getter @Setter
    private BizDate ryosyuymd;

    @Getter @Setter
    private C_HurihunoKbn hurihunokbn;

    @Getter @Setter
    private String bankcd;

    @Getter @Setter
    private String sitencd;

    @Getter @Setter
    private C_YokinKbn yokinkbn;

    @Getter @Setter
    private String kouzano;

    @Getter @Setter
    private String dantaikobetukbn;

    @Getter @Setter
    private C_Hrkkaisuu hrkkaisuu;

    @Getter @Setter
    private String kzhurikaetkbtannaihyj;

    @Getter @Setter
    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Getter @Setter
    private String creditkessaiyouno;

    @Getter @Setter
    private C_CreditUriageNgJiyuuKbn credituriagengjiyuu;

    public TRCreditKurikosiMinyuuBean(String pSyono,
        BizDate pSyoriYmd,
        String pMinyuutrrenno,
        C_Nykkeiro pNykkeiro,
        C_NyknaiyouKbn pNyknaiyoukbn,
        BizDateYM pJyuutouym,
        Integer pJyutoukaisuuy,
        Integer pJyutoukaisuum,
        String pRsgakuType,
        BigDecimal pRsgakuValue,
        BizDate pRyosyuymd,
        C_HurihunoKbn pHurihunokbn,
        String pBankcd,
        String pSitencd,
        C_YokinKbn pYokinkbn,
        String pKouzano,
        String pDantaikobetukbn,
        C_Hrkkaisuu pHrkkaisuu,
        String pKzhurikaetkbtannaihyj,
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn,
        String pCreditkessaiyouno,
        C_CreditUriageNgJiyuuKbn pCredituriagengjiyuu) {

        syono = pSyono;
        syoriYmd = pSyoriYmd;
        minyuutrrenno = pMinyuutrrenno;
        nykkeiro = pNykkeiro;
        nyknaiyoukbn = pNyknaiyoukbn;
        jyuutouym = pJyuutouym;
        jyutoukaisuuy = pJyutoukaisuuy;
        jyutoukaisuum = pJyutoukaisuum;
        rsgaku = new BizCurrencySum(pRsgakuType, pRsgakuValue).toBizCurrency();
        ryosyuymd = pRyosyuymd;
        hurihunokbn = pHurihunokbn;
        bankcd = pBankcd;
        sitencd = pSitencd;
        yokinkbn = pYokinkbn;
        kouzano = pKouzano;
        dantaikobetukbn = pDantaikobetukbn;
        hrkkaisuu = pHrkkaisuu;
        kzhurikaetkbtannaihyj = pKzhurikaetkbtannaihyj;
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
        creditkessaiyouno = pCreditkessaiyouno;
        credituriagengjiyuu = pCredituriagengjiyuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
