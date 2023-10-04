package yuyu.batch.hozen.khansyuu.khkoujyosyoumeisks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * 控除証明書作成対象データを保持するBeanクラスです。<br />
 */
@AllArgsConstructor
public class KoujyoSymSakuseiTaisyouDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private C_Kykjyoutai kykjyoutai;

    @Getter @Setter
    private BizDateYM jkipjytym;

    @Getter @Setter
    private C_YuukousyoumetuKbn yuukousyoumetukbn;

    @Getter @Setter
    private BizCurrency hokenryou;

    public KoujyoSymSakuseiTaisyouDataBean (String pSyono,
        String pKbnkey,
        C_Kykjyoutai pKykjyoutai,
        BizDateYM pJkipjytym,
        C_YuukousyoumetuKbn pYuukousyoumetukbn,
        String pHokenryouType,
        BigDecimal pHokenryouValue) {

        syono = pSyono;
        kbnkey = pKbnkey;
        kykjyoutai = pKykjyoutai;
        jkipjytym = pJkipjytym;
        yuukousyoumetukbn = pYuukousyoumetukbn;
        hokenryou = new BizCurrencySum(pHokenryouType, pHokenryouValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
