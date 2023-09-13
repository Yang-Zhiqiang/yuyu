package yuyu.def.hozen.result.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KoujyosyoumeipKbn;

/**
 * 控除証明内容View情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class KoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbnBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public KoujyoSymNaiyouNyknJissekiRirekisBySyonoKoujyosyoumeinndHrkkaisuuKjsmsyoriKbnBean (String pSyouhncd,
        Integer pRenno3keta, C_KoujyosyoumeipKbn pKoujyosyoumeipkbn, String pKoujyosyoumeigkType,
        BigDecimal pKoujyosyoumeigkValue, BizDateYM pSyoumeistartym, BizDateYM pSyoumeiendym, C_Hrkkaisuu pHrkkaisuu) {

        syouhncd = pSyouhncd;
        renno3keta = pRenno3keta;
        koujyosyoumeipkbn = pKoujyosyoumeipkbn;
        koujyosyoumeigk = new BizCurrencySum(pKoujyosyoumeigkType, pKoujyosyoumeigkValue).toBizCurrency();
        syoumeistartym = pSyoumeistartym;
        syoumeiendym = pSyoumeiendym;
        hrkkaisuu = pHrkkaisuu;

    }

    @Getter @Setter
    private String syouhncd;

    @Getter @Setter
    private Integer renno3keta;

    @Getter @Setter
    private C_KoujyosyoumeipKbn koujyosyoumeipkbn;

    @Getter @Setter
    private BizCurrency koujyosyoumeigk;

    @Getter @Setter
    private BizDateYM syoumeistartym;

    @Getter @Setter
    private BizDateYM syoumeiendym;

    @Getter @Setter
    private C_Hrkkaisuu hrkkaisuu;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
