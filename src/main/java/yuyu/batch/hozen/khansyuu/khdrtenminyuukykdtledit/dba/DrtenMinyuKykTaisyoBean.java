package yuyu.batch.hozen.khansyuu.khdrtenminyuukykdtledit.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 案内収納 代理店未入契約明細対象Beanクラス
 * @author  朱　紅妍
 * @version 2018/11/26 朱　紅妍 : 新規作成<br />
 */
public class DrtenMinyuKykTaisyoBean implements Serializable{

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 区分キー */
    @Getter @Setter
    private String kbnkey;

    /** 証券番号 */
    @Getter @Setter
    private String syono;

    /** 処理年月日 */
    @Getter @Setter
    private BizDate syoriYmd;

    /** 充当年月 */
    @Getter @Setter
    private BizDateYM jyuutouym;

    /** 領収日 */
    @Getter @Setter
    private BizDate ryousyuuymd;

    /** 振替不能理由区分 */
    @Getter @Setter
    private C_HurihunoKbn hurihunoKbn;

    /** 払込回数 */
    @Getter @Setter
    private C_Hrkkaisuu hrkkaisuu;

    /** 定期一括払種類区分 */
    @Getter @Setter
    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    /** 次回Ｐ充当年月 */
    @Getter @Setter
    private BizDateYM jkipjytym;

    /** 次回案内金額 */
    @Getter @Setter
    private BizCurrency jkiannaikg;

    /** 入金経路 */
    @Getter @Setter
    private C_Nykkeiro nykkeiro;

    /** 入金内容区分 */
    @Getter @Setter
    private C_NyknaiyouKbn nyknaiyouKbn;

    /** 領収金額 */
    @Getter @Setter
    private BizCurrency rsgakuYen;

    /**
     * Beanコンストラクタ
     * @param pKbnkey             区分キー
     * @param pSyono              証券番号
     * @param pSyoriymd           処理年月日
     * @param pJyuutouym          充当年月
     * @param pRyousyuuymd        領収日
     * @param pHurihunoKbn        振替不能理由区分
     * @param pHrkkaisuu          払込回数
     * @param pTikiktbrisyuruikbn 定期一括払種類区分
     * @param pJkipjytym          次回Ｐ充当年月
     * @param pTypefieldname      次回案内金額の通貨単位フィールド名
     * @param pValuefieldname     次回案内金額の金額フィールド名
     * @param pNykkeiro           入金経路
     * @param pNyknaiyouKbn       入金内容区分
     * @param pRsgakuType         領収金額の通貨単位フィールド名
     * @param pRsgakuValue        領収金額の金額フィールド名
     */
    public DrtenMinyuKykTaisyoBean (String pKbnkey,
        String pSyono,
        BizDate pSyoriymd,
        BizDateYM pJyuutouym,
        BizDate pRyousyuuymd,
        C_HurihunoKbn pHurihunoKbn,
        C_Hrkkaisuu pHrkkaisuu,
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn,
        BizDateYM pJkipjytym,
        String pTypefieldname,
        BigDecimal pValuefieldname,
        C_Nykkeiro pNykkeiro,
        C_NyknaiyouKbn pNyknaiyouKbn,
        String pRsgakuType,
        BigDecimal pRsgakuValue) {

        kbnkey = pKbnkey;
        syono = pSyono;
        syoriYmd = pSyoriymd;
        jyuutouym = pJyuutouym;
        ryousyuuymd = pRyousyuuymd;
        hurihunoKbn = pHurihunoKbn;
        hrkkaisuu = pHrkkaisuu;
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
        jkipjytym = pJkipjytym;
        jkiannaikg = new BizCurrencySum(pTypefieldname, pValuefieldname).toBizCurrency();
        nykkeiro = pNykkeiro;
        nyknaiyouKbn = pNyknaiyouKbn;
        rsgakuYen = new BizCurrencySum(pRsgakuType, pRsgakuValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
