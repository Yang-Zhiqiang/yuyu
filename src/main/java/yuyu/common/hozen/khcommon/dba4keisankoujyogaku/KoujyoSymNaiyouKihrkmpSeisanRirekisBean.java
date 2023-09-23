package yuyu.common.hozen.khcommon.dba4keisankoujyogaku;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_DispKbn;
import yuyu.def.classification.C_KoujyosymnaiyourecKbn;
import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * 控除証明内容View（既払込Ｐ精算履歴TBLと結合）情報Beanクラスです。<br />
 */
public class KoujyoSymNaiyouKihrkmpSeisanRirekisBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizDateYM syoumeistartym;

    @Getter @Setter
    private BizDateYM syoumeiendym;

    @Getter @Setter
    private C_KoujyosyoumeipKbn koujyosyoumeipkbn;

    @Getter @Setter
    private C_KoujyosymnaiyourecKbn koujyosymnaiyoureckbn;

    @Getter @Setter
    private BizCurrency koujyosyoumeigk;

    @Getter @Setter
    private C_DispKbn keisanhukahyoujikbn;

    @Getter @Setter
    private String keisanhukariyuucd;

    @Getter @Setter
    private String henkousikibetukey;

    @Getter @Setter
    private String gyoumuKousinKinou;

    @Getter @Setter
    private C_YuukousyoumetuKbn yuukousyoumetukbn;

    @Getter @Setter
    private C_Kykjyoutai kykjyoutai;


    public KoujyoSymNaiyouKihrkmpSeisanRirekisBean (
        BizDateYM pSyoumeistartym,
        BizDateYM pSyoumeiendym,
        C_KoujyosyoumeipKbn pKoujyosyoumeipkbn,
        C_KoujyosymnaiyourecKbn pKoujyosymnaiyoureckbn,
        String pKoujyosyoumeigkType,
        BigDecimal pKoujyosyoumeigkValue,
        C_DispKbn pKeisanhukahyoujikbn,
        String pKeisanhukariyuucd,
        String pHenkousikibetukey,
        String pGyoumuKousinKinou,
        C_YuukousyoumetuKbn pYuukousyoumetukbn,
        C_Kykjyoutai pKykjyoutai) {

        syoumeistartym = pSyoumeistartym;
        syoumeiendym = pSyoumeiendym;
        koujyosyoumeipkbn = pKoujyosyoumeipkbn;
        koujyosymnaiyoureckbn = pKoujyosymnaiyoureckbn;
        koujyosyoumeigk = new BizCurrencySum(pKoujyosyoumeigkType, pKoujyosyoumeigkValue).toBizCurrency();
        keisanhukahyoujikbn = pKeisanhukahyoujikbn;
        keisanhukariyuucd = pKeisanhukariyuucd;
        henkousikibetukey = pHenkousikibetukey;
        gyoumuKousinKinou = pGyoumuKousinKinou;
        yuukousyoumetukbn = pYuukousyoumetukbn;
        kykjyoutai = pKykjyoutai;

    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
