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
 * @author  張　龍
 * @version 2019/10/24 張　龍 : 新規作成<br />
 */
public class TRCreditKurikosiMinyuuBean implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 証券番号 */
    @Getter @Setter
    private String syono;

    /** 処理年月日 */
    @Getter @Setter
    private BizDate syoriYmd;

    /** 未入TR連番 */
    @Getter @Setter
    private String minyuutrrenno;

    /** 入金経路 */
    @Getter @Setter
    private C_Nykkeiro nykkeiro;

    /** 入金内容区分 */
    @Getter @Setter
    private C_NyknaiyouKbn nyknaiyoukbn;

    /** 充当年月 */
    @Getter @Setter
    private BizDateYM jyuutouym;

    /** 充当回数（年） */
    @Getter @Setter
    private Integer jyutoukaisuuy;

    /** 充当回数（月） */
    @Getter @Setter
    private Integer jyutoukaisuum;

    /** 領収金額 */
    @Getter @Setter
    private BizCurrency rsgaku;

    /** 領収日 */
    @Getter @Setter
    private BizDate ryosyuymd;

    /** 振替不能理由区分 */
    @Getter @Setter
    private C_HurihunoKbn hurihunokbn;

    /** 銀行コード */
    @Getter @Setter
    private String bankcd;

    /** 支店コード */
    @Getter @Setter
    private String sitencd;

    /** 預金種目区分 */
    @Getter @Setter
    private C_YokinKbn yokinkbn;

    /** 口座番号 */
    @Getter @Setter
    private String kouzano;

    /** 団体個別区分 */
    @Getter @Setter
    private String dantaikobetukbn;

    /** 払込回数 */
    @Getter @Setter
    private C_Hrkkaisuu hrkkaisuu;

    /** 口座振替特別案内表示 */
    @Getter @Setter
    private String kzhurikaetkbtannaihyj;

    /** 定期一括払種類区分 */
    @Getter @Setter
    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    /** クレジットカード決済用番号 */
    @Getter @Setter
    private String creditkessaiyouno;

    /** クレジットカード売上請求ＮＧ事由 */
    @Getter @Setter
    private C_CreditUriageNgJiyuuKbn credituriagengjiyuu;

    /**
     * コンストラクタ
     * @param pSyono                 証券番号
     * @param pSyoriYmd              処理年月日
     * @param pMinyuutrrenno         未入TR連番
     * @param pNykkeiro              入金経路
     * @param pNyknaiyoukbn          入金内容区分
     * @param pJyuutouym             充当年月
     * @param pJyutoukaisuuy         充当回数（年）
     * @param pJyutoukaisuum         充当回数（月）
     * @param pRsgakuType            領収金額の通貨単位フィールド名
     * @param pRsgakuValue           領収金額の金額フィールド名
     * @param pRyosyuymd             領収日
     * @param pHurihunokbn           振替不能理由区分
     * @param pBankcd                銀行コード
     * @param pSitencd               支店コード
     * @param pYokinkbn              預金種目区分
     * @param pKouzano               口座番号
     * @param pDantaikobetukbn       団体個別区分
     * @param pHrkkaisuu             払込回数
     * @param pKzhurikaetkbtannaihyj 口座振替特別案内表示
     * @param pTikiktbrisyuruikbn    定期一括払種類区分
     * @param pCreditkessaiyouno     クレジットカード決済用番号
     * @param pCredituriagengjiyuu   クレジットカード売上請求ＮＧ事由
     */
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
