package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_KoujyosyoumeimsgKbn;
import yuyu.def.classification.C_KoujyosyoumeisakuseisyoriKbn;
import yuyu.def.classification.C_KoujyosyoumeisentakuKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SaihkHyjKbn;
import yuyu.def.classification.C_TekiyouseidoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KoujyoSym;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_HaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HknkknsmnKbn;
import yuyu.def.db.type.UserType_C_KoujyosyoumeimsgKbn;
import yuyu.def.db.type.UserType_C_KoujyosyoumeisakuseisyoriKbn;
import yuyu.def.db.type.UserType_C_KoujyosyoumeisentakuKbn;
import yuyu.def.db.type.UserType_C_Kykjyoutai;
import yuyu.def.db.type.UserType_C_SaihkHyjKbn;
import yuyu.def.db.type.UserType_C_TekiyouseidoKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YuukousyoumetuKbn;

/**
 * 控除証明書テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KoujyoSym extends AbstractExDBTable<IT_KoujyoSym> {

    public GenQIT_KoujyoSym() {
        this("IT_KoujyoSym");
    }

    public GenQIT_KoujyoSym(String pAlias) {
        super("IT_KoujyoSym", IT_KoujyoSym.class, pAlias);
    }

    public String IT_KoujyoSym() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KoujyoSym, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KoujyoSym, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KoujyoSym, String> nendo = new ExDBFieldString<>("nendo", this);

    public final ExDBFieldString<IT_KoujyoSym, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_KoujyoSym, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<IT_KoujyoSym, C_KoujyosyoumeisakuseisyoriKbn> kjsmsakuseisyorikbn = new ExDBFieldString<>("kjsmsakuseisyorikbn", this, UserType_C_KoujyosyoumeisakuseisyoriKbn.class);

    public final ExDBFieldString<IT_KoujyoSym, C_TekiyouseidoKbn> tekiyouseidokbn = new ExDBFieldString<>("tekiyouseidokbn", this, UserType_C_TekiyouseidoKbn.class);

    public final ExDBFieldString<IT_KoujyoSym, String> syoumeiymd = new ExDBFieldString<>("syoumeiymd", this);

    public final ExDBFieldString<IT_KoujyoSym, BizDateYM> syoumeistartym = new ExDBFieldString<>("syoumeistartym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_KoujyoSym, BizDateYM> syoumeiendym = new ExDBFieldString<>("syoumeiendym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_KoujyoSym, Integer> syoumeikkntukisuu = new ExDBFieldNumber<>("syoumeikkntukisuu", this);

    public final ExDBFieldNumber<IT_KoujyoSym, Integer> syoumeikknnensuu = new ExDBFieldNumber<>("syoumeikknnensuu", this);

    public final ExDBFieldString<IT_KoujyoSym, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_KoujyoSym, String> uktnmkjaddsama = new ExDBFieldString<>("uktnmkjaddsama", this);

    public final ExDBFieldString<IT_KoujyoSym, BizDate> nenkinuktseiymd = new ExDBFieldString<>("nenkinuktseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KoujyoSym, String> hknsyuruinmrykkj = new ExDBFieldString<>("hknsyuruinmrykkj", this);

    public final ExDBFieldString<IT_KoujyoSym, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KoujyoSym, C_HknkknsmnKbn> hknkknsmnkbnsyu = new ExDBFieldString<>("hknkknsmnkbnsyu", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldString<IT_KoujyoSym, BizNumber> hknkknsyu = new ExDBFieldString<>("hknkknsyu", this, BizNumberType.class);

    public final ExDBFieldNumber<IT_KoujyoSym, Integer> nenkanhrkkaisuu = new ExDBFieldNumber<>("nenkanhrkkaisuu", this);

    public final ExDBFieldNumber<IT_KoujyoSym, Integer> phrkkkn = new ExDBFieldNumber<>("phrkkkn", this);

    public final ExDBFieldString<IT_KoujyoSym, BizDate> nkshrstartymd = new ExDBFieldString<>("nkshrstartymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KoujyoSym, String> nknshry = new ExDBFieldString<>("nknshry", this);

    public final ExDBFieldString<IT_KoujyoSym, C_Kykjyoutai> kykjyoutai = new ExDBFieldString<>("kykjyoutai", this, UserType_C_Kykjyoutai.class);

    public final ExDBFieldString<IT_KoujyoSym, C_YuukousyoumetuKbn> yuukousyoumetukbn = new ExDBFieldString<>("yuukousyoumetukbn", this, UserType_C_YuukousyoumetuKbn.class);

    public final ExDBFieldString<IT_KoujyoSym, C_HaitoukinuketorihouKbn> haitoukinuketorihoukbn = new ExDBFieldString<>("haitoukinuketorihoukbn", this, UserType_C_HaitoukinuketorihouKbn.class);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> oldippanjissekip = new ExDBFieldBizCurrency<>("oldippanjissekip", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> oldippannenkanp = new ExDBFieldBizCurrency<>("oldippannenkanp", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> oldippanjissekihaitoukin = new ExDBFieldBizCurrency<>("oldippanjissekihaitoukin", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> oldippannenkanhaitoukin = new ExDBFieldBizCurrency<>("oldippannenkanhaitoukin", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> oldippanjissekisyoumeigk = new ExDBFieldBizCurrency<>("oldippanjissekisyoumeigk", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> oldippannenkansyoumeigk = new ExDBFieldBizCurrency<>("oldippannenkansyoumeigk", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> newippanjissekip = new ExDBFieldBizCurrency<>("newippanjissekip", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> newippannenkanp = new ExDBFieldBizCurrency<>("newippannenkanp", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> newippanjissekihaitoukin = new ExDBFieldBizCurrency<>("newippanjissekihaitoukin", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> newippannenkanhaitoukin = new ExDBFieldBizCurrency<>("newippannenkanhaitoukin", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> newippanjissekisyoumeigk = new ExDBFieldBizCurrency<>("newippanjissekisyoumeigk", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> newippannenkansyoumeigk = new ExDBFieldBizCurrency<>("newippannenkansyoumeigk", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> newiryoujissekip = new ExDBFieldBizCurrency<>("newiryoujissekip", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> newiryounenkanp = new ExDBFieldBizCurrency<>("newiryounenkanp", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> newiryoujissekihaitoukin = new ExDBFieldBizCurrency<>("newiryoujissekihaitoukin", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> newiryounenkanhaitoukin = new ExDBFieldBizCurrency<>("newiryounenkanhaitoukin", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> newiryoujissekisyoumeigk = new ExDBFieldBizCurrency<>("newiryoujissekisyoumeigk", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> newiryounenkansyoumeigk = new ExDBFieldBizCurrency<>("newiryounenkansyoumeigk", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> newnkjissekip = new ExDBFieldBizCurrency<>("newnkjissekip", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> newnknenkanp = new ExDBFieldBizCurrency<>("newnknenkanp", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> newnkjissekihaitoukin = new ExDBFieldBizCurrency<>("newnkjissekihaitoukin", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> newnknenkanhaitoukin = new ExDBFieldBizCurrency<>("newnknenkanhaitoukin", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> newnkjissekisyoumeigk = new ExDBFieldBizCurrency<>("newnkjissekisyoumeigk", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSym> newnknenkansyoumeigk = new ExDBFieldBizCurrency<>("newnknenkansyoumeigk", this);

    public final ExDBFieldString<IT_KoujyoSym, C_UmuKbn> kjnnkkoujyum = new ExDBFieldString<>("kjnnkkoujyum", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KoujyoSym, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<IT_KoujyoSym, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<IT_KoujyoSym, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<IT_KoujyoSym, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<IT_KoujyoSym, String> toiawasesosikinmkj = new ExDBFieldString<>("toiawasesosikinmkj", this);

    public final ExDBFieldString<IT_KoujyoSym, String> toiawaseyno = new ExDBFieldString<>("toiawaseyno", this);

    public final ExDBFieldString<IT_KoujyoSym, String> toiawaseadr1kj = new ExDBFieldString<>("toiawaseadr1kj", this);

    public final ExDBFieldString<IT_KoujyoSym, String> toiawaseadr2kj = new ExDBFieldString<>("toiawaseadr2kj", this);

    public final ExDBFieldString<IT_KoujyoSym, String> toiawaseadr3kj = new ExDBFieldString<>("toiawaseadr3kj", this);

    public final ExDBFieldString<IT_KoujyoSym, String> toiawasetelno = new ExDBFieldString<>("toiawasetelno", this);

    public final ExDBFieldString<IT_KoujyoSym, String> toiawaseteluktkkanou1 = new ExDBFieldString<>("toiawaseteluktkkanou1", this);

    public final ExDBFieldString<IT_KoujyoSym, String> toiawaseteluktkkanou2 = new ExDBFieldString<>("toiawaseteluktkkanou2", this);

    public final ExDBFieldString<IT_KoujyoSym, String> toiawasesosikinmkj2 = new ExDBFieldString<>("toiawasesosikinmkj2", this);

    public final ExDBFieldString<IT_KoujyoSym, String> toiawasetelno2 = new ExDBFieldString<>("toiawasetelno2", this);

    public final ExDBFieldString<IT_KoujyoSym, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IT_KoujyoSym, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<IT_KoujyoSym, String> drtennmkj = new ExDBFieldString<>("drtennmkj", this);

    public final ExDBFieldString<IT_KoujyoSym, C_UmuKbn> hengakuumu = new ExDBFieldString<>("hengakuumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KoujyoSym, C_UmuKbn> newsyoumeigkumukbn = new ExDBFieldString<>("newsyoumeigkumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KoujyoSym, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KoujyoSym, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KoujyoSym, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_KoujyoSym, C_KoujyosyoumeisentakuKbn> koujyosyoumeisentakukbn = new ExDBFieldString<>("koujyosyoumeisentakukbn", this, UserType_C_KoujyosyoumeisentakuKbn.class);

    public final ExDBFieldString<IT_KoujyoSym, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<IT_KoujyoSym, String> uktnmkn = new ExDBFieldString<>("uktnmkn", this);

    public final ExDBFieldString<IT_KoujyoSym, C_SaihkHyjKbn> saihkhyjkbn = new ExDBFieldString<>("saihkhyjkbn", this, UserType_C_SaihkHyjKbn.class);

    public final ExDBFieldString<IT_KoujyoSym, C_KoujyosyoumeimsgKbn> koujyosyoumeimsgkbn = new ExDBFieldString<>("koujyosyoumeimsgkbn", this, UserType_C_KoujyosyoumeimsgKbn.class);
}
