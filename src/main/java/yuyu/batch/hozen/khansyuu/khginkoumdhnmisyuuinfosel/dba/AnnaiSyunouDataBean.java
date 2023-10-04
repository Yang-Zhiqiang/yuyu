package yuyu.batch.hozen.khansyuu.khginkoumdhnmisyuuinfosel.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;

/**
 * 契約保全 案内収納 案内収納基本情報を保持するBeanクラス
 * @author  陳 東奇
 * @version 2017/11/01 陳 東奇 : 新規作成<br />
 */
public class AnnaiSyunouDataBean implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 証券番号 */
    @Getter @Setter
    private String syono;

    /** 区分キー */
    @Getter @Setter
    private String kbnkey;

    /** 払込回数 */
    @Getter @Setter
    private C_Hrkkaisuu hrkkaisuu;

    /** 払込保険料 */
    @Getter @Setter
    private BizCurrency hrkp;

    /** 払込経路 */
    @Getter @Setter
    private C_Hrkkeiro hrkkeiro;

    /** 商品コード */
    @Getter @Setter
    private String syouhncd;

    /** 商品世代番号 */
    @Getter @Setter
    private Integer syouhnsdno;

    /** 次回Ｐ充当年月 */
    @Getter
    @Setter
    private BizDateYM jkipjytym;

    /** 定期一括払種類区分 */
    @Getter
    @Setter
    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    /** 料率世代番号 */
    @Getter
    @Setter
    private String ryouritusdno;

    /** 保険料 */
    @Getter
    @Setter
    private BizCurrency hokenryou;

    /**
     * コンストラクタ
     * @param pSyono        証券番号
     * @param pKbnkey       区分キー
     * @param pHrkkaisuu    払込回数
     * @param pHrkpType     払込保険料の通貨単位フィールド名
     * @param pHrkpValue    払込保険料の金額フィールド名
     * @param pHrkkeiro     払込経路
     * @param pSyouhncd     商品コード
     * @param pSyouhnsdno   商品世代番号
     * @param pJkipjytym    次回Ｐ充当年月
     * @param pTikiktbrisyuruikbn 定期一括払種類区分
     * @param pRyouritusdno   料率世代番号
     * @param pHokenryouType  保険料の通貨単位フィールド名
     * @param pHokenryouValue 保険料の金額フィールド名
     */
    public AnnaiSyunouDataBean(String pSyono, String pKbnkey, C_Hrkkaisuu pHrkkaisuu, String pHrkpType,
        BigDecimal pHrkpValue, C_Hrkkeiro pHrkkeiro, String pSyouhncd, Integer pSyouhnsdno, BizDateYM pJkipjytym,
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn, String pRyouritusdno, String pHokenryouType, BigDecimal pHokenryouValue) {
        // 証券番号
        this.syono = pSyono;
        // 区分キー
        this.kbnkey = pKbnkey;
        // 払込回数
        this.hrkkaisuu = pHrkkaisuu;
        // 払込保険料
        this.hrkp = new BizCurrencySum(pHrkpType, pHrkpValue).toBizCurrency();
        // 払込経路
        this.hrkkeiro = pHrkkeiro;
        // 商品コード
        this.syouhncd = pSyouhncd;
        // 商品世代番号
        this.syouhnsdno = pSyouhnsdno;
        // 次回Ｐ充当年月
        this.jkipjytym = pJkipjytym;
        // 定期一括払種類区分
        this.tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
        // 料率世代番号
        this.ryouritusdno = pRyouritusdno;
        // 保険料
        this.hokenryou = new BizCurrencySum(pHokenryouType, pHokenryouValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
