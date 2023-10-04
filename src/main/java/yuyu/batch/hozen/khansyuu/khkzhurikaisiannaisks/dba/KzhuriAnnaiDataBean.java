package yuyu.batch.hozen.khansyuu.khkzhurikaisiannaisks.dba;

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
import yuyu.def.classification.C_TkiktbrisyuruiKbn;

/**
 * 口座振替開始案内作成Beanクラスです。<br />
 */
public class KzhuriAnnaiDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private BizDateYM jkipjytym;

    @Getter @Setter
    private C_Hrkkaisuu hrkkaisuu;

    @Getter @Setter
    private BizCurrency hrkp;

    @Getter @Setter
    private C_TkiktbrisyuruiKbn tkiktbrisyuruiKbn;

    @Getter @Setter
    private BizDate kykymd;

    @Getter @Setter
    private String syouhncd;

    @Getter @Setter
    private Integer syouhnsdno;

    @Getter @Setter
    private BizCurrency hokenryou;

    public KzhuriAnnaiDataBean (String pSyono,
        String pKbnkey,
        BizDateYM pJkipjytym,
        C_Hrkkaisuu pHrkkaisuu,
        String pType,
        BigDecimal pValue,
        C_TkiktbrisyuruiKbn pTkiktbrisyuruiKbn,
        BizDate pKykymd,
        String pSyouhncd,
        Integer pSyouhnsdno,
        String pHokenryouType,
        BigDecimal pHokenryouValue) {

        syono = pSyono;
        kbnkey = pKbnkey;
        jkipjytym = pJkipjytym;
        hrkkaisuu = pHrkkaisuu;
        hrkp = new BizCurrencySum(pType, pValue).toBizCurrency();
        tkiktbrisyuruiKbn =pTkiktbrisyuruiKbn;
        kykymd = pKykymd;
        syouhncd = pSyouhncd;
        syouhnsdno = pSyouhnsdno;
        hokenryou = new BizCurrencySum(pHokenryouType, pHokenryouValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
