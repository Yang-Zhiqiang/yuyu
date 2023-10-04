package yuyu.batch.hozen.khansyuu.khminyuu.dba;

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
 * 未入ＴＲ情報を保持するBeanクラスです。<br />
 */
public class MinyuuTRBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String syono;

    @Getter
    @Setter
    private BizDate syoriYmd;

    @Getter
    @Setter
    private String minyuutrrenno;

    @Getter
    @Setter
    private C_Nykkeiro nykkeiro;

    @Getter
    @Setter
    private C_NyknaiyouKbn nyknaiyoukbn;

    @Getter
    @Setter
    private BizDateYM jyuutouym;

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
    private C_HurihunoKbn hurihunokbn;

    @Getter
    @Setter
    private C_Hrkkaisuu hrkkaisuu;

    @Getter
    @Setter
    private String bankCd;

    @Getter
    @Setter
    private String sitenCd;

    @Getter
    @Setter
    private C_YokinKbn yokinKbn;

    @Getter
    @Setter
    private String kouzaNo;

    @Getter
    @Setter
    private String kbnkey;

    @Getter
    @Setter
    private String dantaiKobetuKbn;

    @Getter
    @Setter
    private String kzhurikaeTkbtannaiHyj;

    @Getter
    @Setter
    private C_TkiktbrisyuruiKbn tikiktbrisyuruiKbn;

    @Getter
    @Setter
    private String creditkessaiyouno;

    @Getter
    @Setter
    private C_CreditUriageNgJiyuuKbn creditUriageNgJiyuuKbn;

    public MinyuuTRBean(String pSyono,
        BizDate pSyoriYmd,
        String pMinyuutrrenno,
        C_Nykkeiro pNykkeiro,
        C_NyknaiyouKbn pNyknaiyoukbn,
        BizDateYM pJyuutouym,
        Integer pJyutoukaisuuy,
        Integer pJyutoukaisuum,
        String pType,
        BigDecimal pValue,
        BizDate pRyosyuymd,
        C_HurihunoKbn pHurihunokbn,
        C_Hrkkaisuu pHrkkaisuu,
        String pBankCd,
        String pSitenCd,
        C_YokinKbn pYokinKbn,
        String pKouzaNo,
        String pKbnkey,
        String pDantaiKobetuKbn,
        String pKzhurikaeTkbtannaiHyj,
        C_TkiktbrisyuruiKbn pTikiktbrisyuruiKbn,
        String pCreditkessaiyouno,
        C_CreditUriageNgJiyuuKbn pCreditUriageNgJiyuuKbn) {
        syono = pSyono;
        syoriYmd = pSyoriYmd;
        minyuutrrenno = pMinyuutrrenno;
        nykkeiro = pNykkeiro;
        nyknaiyoukbn = pNyknaiyoukbn;
        jyuutouym = pJyuutouym;
        jyutoukaisuuy = pJyutoukaisuuy;
        jyutoukaisuum = pJyutoukaisuum;
        rsgaku = new BizCurrencySum(pType, pValue).toBizCurrency();
        ryosyuymd = pRyosyuymd;
        hurihunokbn = pHurihunokbn;
        hrkkaisuu = pHrkkaisuu;
        bankCd = pBankCd;
        sitenCd = pSitenCd;
        yokinKbn = pYokinKbn;
        kouzaNo = pKouzaNo;
        kbnkey = pKbnkey;
        dantaiKobetuKbn = pDantaiKobetuKbn;
        kzhurikaeTkbtannaiHyj = pKzhurikaeTkbtannaiHyj;
        tikiktbrisyuruiKbn = pTikiktbrisyuruiKbn;
        creditkessaiyouno = pCreditkessaiyouno;
        creditUriageNgJiyuuKbn = pCreditUriageNgJiyuuKbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
