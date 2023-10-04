package yuyu.batch.hozen.khansyuu.khuriageseikyuusel.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Yuukoukakkekka;

/**
 * 案内収納情報Beanクラス<br />
 * @author  張　延超
 * @version 2019/10/23 張　延超 : 新規作成<br />
 */
public class AnnaiSyuunouDataBean implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 証券番号 */
    @Getter @Setter
    private String syono;

    /** 区分キー */
    @Getter @Setter
    private String kbnkey;

    /** 次回Ｐ充当年月 */
    @Getter @Setter
    private BizDateYM jkipjytym;

    /** 主契約払満日 */
    @Getter @Setter
    private BizDate syuharaimanymd;

    /** 払込回数 */
    @Getter @Setter
    private C_Hrkkaisuu hrkkaisuu;

    /** 払込保険料 */
    @Getter @Setter
    private BizCurrency hrkp;

    /** 払込経路 */
    @Getter @Setter
    private C_Hrkkeiro hrkkeiro;

    /** 定期一括払種類区分 */
    @Getter @Setter
    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    /** 商品コード */
    @Getter @Setter
    private String syouhncd;

    /** クレジットカード決済用番号 */
    @Getter @Setter
    private String creditkessaiyouno;

    /** クレジットカード有効確認年月 */
    @Getter @Setter
    private BizDateYM credityuukoukakym;

    /** クレジットカード有効確認結果 */
    @Getter @Setter
    private C_Yuukoukakkekka credityuukoukakkekka;

    /**
     * 案内収納情報を保持するBeanコンストラクタ
     * @param pSyono                証券番号
     * @param pKbnkey               区分キー
     * @param pJkipjytym            次回Ｐ充当年月
     * @param pSyuharaimanymd       主契約払満日
     * @param pHrkkaisuu            払込回数
     * @param pHrkpType             払込保険料の通貨単位
     * @param pHrkpValue            払込保険料の金額
     * @param pHrkkeiro             払込経路
     * @param pTikiktbrisyuruikbn   定期一括払種類区分
     * @param pSyouhncd             商品コード
     * @param pCreditkessaiyouno    クレジットカード決済用番号
     * @param pCredityuukoukakym    クレジットカード有効確認年月
     * @param pCredityuukoukakkekka クレジットカード有効確認結果
     */
    public AnnaiSyuunouDataBean(String pSyono,
        String pKbnkey,
        BizDateYM pJkipjytym,
        BizDate pSyuharaimanymd,
        C_Hrkkaisuu pHrkkaisuu,
        String pHrkpType,
        BigDecimal pHrkpValue,
        C_Hrkkeiro pHrkkeiro,
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn,
        String pSyouhncd,
        String pCreditkessaiyouno,
        BizDateYM pCredityuukoukakym,
        C_Yuukoukakkekka pCredityuukoukakkekka) {

        syono = pSyono;
        kbnkey = pKbnkey;
        jkipjytym = pJkipjytym;
        syuharaimanymd = pSyuharaimanymd;
        hrkkaisuu = pHrkkaisuu;
        hrkp = new BizCurrencySum(pHrkpType, pHrkpValue).toBizCurrency();
        hrkkeiro = pHrkkeiro;
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
        syouhncd = pSyouhncd;
        creditkessaiyouno = pCreditkessaiyouno;
        credityuukoukakym = pCredityuukoukakym;
        credityuukoukakkekka = pCredityuukoukakkekka;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}