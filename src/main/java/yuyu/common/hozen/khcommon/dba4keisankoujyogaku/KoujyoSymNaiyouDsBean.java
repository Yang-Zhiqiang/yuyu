package yuyu.common.hozen.khcommon.dba4keisankoujyogaku;

import java.io.Serializable;
import java.math.BigDecimal;

import yuyu.def.classification.C_NaiteiKakuteiKbn;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 控除証明内容Ｄ情報Beanクラスです。<br />
 */
public class KoujyoSymNaiyouDsBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizCurrency koujyosyoumeid;

    @Getter @Setter
    private C_NaiteiKakuteiKbn naiteikakuteikbn;

    public KoujyoSymNaiyouDsBean (
        String pKoujyosyoumeidType,
        BigDecimal pKoujyosyoumeidValue,
        C_NaiteiKakuteiKbn pNaiteikakuteikbn) {

        koujyosyoumeid = new BizCurrencySum(pKoujyosyoumeidType, pKoujyosyoumeidValue).toBizCurrency();
        naiteikakuteikbn = pNaiteikakuteikbn;

    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
