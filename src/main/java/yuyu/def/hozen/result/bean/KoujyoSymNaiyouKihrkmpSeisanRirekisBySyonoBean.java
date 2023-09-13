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
import yuyu.def.classification.C_KoujyosymnaiyourecKbn;
import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * 控除証明内容View（既払込Ｐ精算履歴TBLと結合）情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class KoujyoSymNaiyouKihrkmpSeisanRirekisBySyonoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public KoujyoSymNaiyouKihrkmpSeisanRirekisBySyonoBean (C_KoujyosyoumeipKbn pKoujyosyoumeipkbn,
        C_KoujyosymnaiyourecKbn pKoujyosymnaiyoureckbn, String pKoujyosyoumeigkType,
        BigDecimal pKoujyosyoumeigkValue, BizDateYM pJyuutouym, Integer pSeijyutoukaisuum,
        Integer pSeijyutoukaisuuy, String pGyoumuKousinKinou, C_YuukousyoumetuKbn pYuukousyoumetukbn) {

        koujyosyoumeipkbn = pKoujyosyoumeipkbn;
        koujyosymnaiyoureckbn = pKoujyosymnaiyoureckbn;
        koujyosyoumeigk = new BizCurrencySum(pKoujyosyoumeigkType, pKoujyosyoumeigkValue).toBizCurrency();
        jyuutouym = pJyuutouym;
        seijyutoukaisuum = pSeijyutoukaisuum;
        seijyutoukaisuuy = pSeijyutoukaisuuy;
        gyoumuKousinKinou = pGyoumuKousinKinou;
        yuukousyoumetukbn = pYuukousyoumetukbn;

    }

    @Getter @Setter
    private C_KoujyosyoumeipKbn koujyosyoumeipkbn;

    @Getter @Setter
    private C_KoujyosymnaiyourecKbn koujyosymnaiyoureckbn;

    @Getter @Setter
    private BizCurrency koujyosyoumeigk;

    @Getter @Setter
    private BizDateYM jyuutouym;

    @Getter @Setter
    private Integer seijyutoukaisuum;

    @Getter @Setter
    private Integer seijyutoukaisuuy;

    @Getter @Setter
    private String gyoumuKousinKinou;

    @Getter @Setter
    private C_YuukousyoumetuKbn yuukousyoumetukbn;


    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
