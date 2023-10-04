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
 * @author  李　霖蛟
 * @version 2017/01/03  李　霖蛟 : 新規作成<br />
 *          2017/03/23  馮　超   : S社ナポレオン先行１次追加対応<br />
 *          2017/12/01  張　磊   : 平準払商品対応<br />
 *          2018/11/29  成　陽   : 2019年3月25日対応<br />
 *          2019/10/29  呉　士琦 : 2020年3月24日対応<br />
 *          2020/11/03  李　洪曇 : 2020年3月15日対応<br />
 */
public class MinyuuTRBean implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 証券番号 */
    @Getter
    @Setter
    private String syono;

    /** 処理年月日 */
    @Getter
    @Setter
    private BizDate syoriYmd;

    /** 未入TR連番 */
    @Getter
    @Setter
    private String minyuutrrenno;

    /** 入金経路 */
    @Getter
    @Setter
    private C_Nykkeiro nykkeiro;

    /** 入金内容区分 */
    @Getter
    @Setter
    private C_NyknaiyouKbn nyknaiyoukbn;

    /** 充当年月 */
    @Getter
    @Setter
    private BizDateYM jyuutouym;

    /** 充当回数（年） */
    @Getter
    @Setter
    private Integer jyutoukaisuuy;

    /** 充当回数（月） */
    @Getter
    @Setter
    private Integer jyutoukaisuum;

    /** 領収金額 */
    @Getter
    @Setter
    private BizCurrency rsgaku;

    /** 領収日 */
    @Getter
    @Setter
    private BizDate ryosyuymd;

    /** 振替不能理由区分 */
    @Getter
    @Setter
    private C_HurihunoKbn hurihunokbn;

    /** 払込回数 */
    @Getter
    @Setter
    private C_Hrkkaisuu hrkkaisuu;

    /** 銀行コード */
    @Getter
    @Setter
    private String bankCd;

    /** 支店コード */
    @Getter
    @Setter
    private String sitenCd;

    /** 預金種目区分 */
    @Getter
    @Setter
    private C_YokinKbn yokinKbn;

    /** 口座番号 */
    @Getter
    @Setter
    private String kouzaNo;

    /** 区分キー */
    @Getter
    @Setter
    private String kbnkey;

    /** 団体個別区分 */
    @Getter
    @Setter
    private String dantaiKobetuKbn;

    /** 口座振替特別案内表示 */
    @Getter
    @Setter
    private String kzhurikaeTkbtannaiHyj;

    /** 定期一括払種類区分 */
    @Getter
    @Setter
    private C_TkiktbrisyuruiKbn tikiktbrisyuruiKbn;

    /** クレジットカード決済用番号 */
    @Getter
    @Setter
    private String creditkessaiyouno;

    /** クレジットカード売上請求ＮＧ事由 */
    @Getter
    @Setter
    private C_CreditUriageNgJiyuuKbn creditUriageNgJiyuuKbn;

    /**
     * コンストラクタ
     * @param pSyono                   証券番号
     * @param pSyoriYmd                処理年月日
     * @param pMinyuutrrenno           未入TR連番
     * @param pNykkeiro                入金経路
     * @param pNyknaiyoukbn            入金内容区分
     * @param pJyuutouym               充当年月
     * @param pJyutoukaisuuy           充当回数（年）
     * @param pJyutoukaisuum           充当回数（月）
     * @param pType                    領収金額の通貨単位フィールド名
     * @param pValue                   領収金額の金額フィールド名
     * @param pRyosyuymd               領収日
     * @param pHurihunokbn             振替不能理由区分
     * @param pHrkkaisuu               払込回数
     * @param pBankCd                  銀行コード
     * @param pSitenCd                 支店コード
     * @param pYokinKbn                預金種目区分
     * @param pKouzaNo                 口座番号
     * @param pKbnkey                  区分キー
     * @param pDantaiKobetuKbn         団体個別区分
     * @param pKzhurikaeTkbtannaiHyj   口座振替特別案内表示
     * @param pTikiktbrisyuruiKbn      定期一括払種類区分
     * @param pCreditkessaiyouno       クレジットカード決済用番号
     * @param pCreditUriageNgJiyuuKbn  クレジットカード売上請求ＮＧ事由
     */
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
