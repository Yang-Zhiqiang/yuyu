package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_HaitouhouKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Kktyhysksitisy;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_TekiyouseidoKbn;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KoujyoSymSougou;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_HaitouhouKbn;
import yuyu.def.db.type.UserType_C_HaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_HknkknsmnKbn;
import yuyu.def.db.type.UserType_C_Kktyhysksitisy;
import yuyu.def.db.type.UserType_C_Kykjyoutai;
import yuyu.def.db.type.UserType_C_TekiyouseidoKbn;
import yuyu.def.db.type.UserType_C_TyhyrenrakusikibetuKbn;
import yuyu.def.db.type.UserType_C_YuukousyoumetuKbn;

/**
 * 控除証明書（総合通知用）テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KoujyoSymSougou extends AbstractExDBTable<IT_KoujyoSymSougou> {

    public GenQIT_KoujyoSymSougou() {
        this("IT_KoujyoSymSougou");
    }

    public GenQIT_KoujyoSymSougou(String pAlias) {
        super("IT_KoujyoSymSougou", IT_KoujyoSymSougou.class, pAlias);
    }

    public String IT_KoujyoSymSougou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KoujyoSymSougou, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KoujyoSymSougou, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KoujyoSymSougou, String> nendo = new ExDBFieldString<>("nendo", this);

    public final ExDBFieldString<IT_KoujyoSymSougou, C_Kktyhysksitisy> kktyhysksitisykbn = new ExDBFieldString<>("kktyhysksitisykbn", this, UserType_C_Kktyhysksitisy.class);

    public final ExDBFieldString<IT_KoujyoSymSougou, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_KoujyoSymSougou, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<IT_KoujyoSymSougou, C_TekiyouseidoKbn> tekiyouseidokbn = new ExDBFieldString<>("tekiyouseidokbn", this, UserType_C_TekiyouseidoKbn.class);

    public final ExDBFieldString<IT_KoujyoSymSougou, String> syoumeiymd = new ExDBFieldString<>("syoumeiymd", this);

    public final ExDBFieldString<IT_KoujyoSymSougou, BizDateYM> syoumeistartym = new ExDBFieldString<>("syoumeistartym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_KoujyoSymSougou, BizDateYM> syoumeiendym = new ExDBFieldString<>("syoumeiendym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_KoujyoSymSougou, Integer> syoumeikkntukisuu = new ExDBFieldNumber<>("syoumeikkntukisuu", this);

    public final ExDBFieldString<IT_KoujyoSymSougou, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_KoujyoSymSougou, String> uktnmkj = new ExDBFieldString<>("uktnmkj", this);

    public final ExDBFieldString<IT_KoujyoSymSougou, String> hknsyuruinmrykkj = new ExDBFieldString<>("hknsyuruinmrykkj", this);

    public final ExDBFieldString<IT_KoujyoSymSougou, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KoujyoSymSougou, C_HknkknsmnKbn> hknkknsmnkbnsyu = new ExDBFieldString<>("hknkknsmnkbnsyu", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldString<IT_KoujyoSymSougou, BizNumber> hknkknsyu = new ExDBFieldString<>("hknkknsyu", this, BizNumberType.class);

    public final ExDBFieldNumber<IT_KoujyoSymSougou, Integer> nenkanhrkkaisuu = new ExDBFieldNumber<>("nenkanhrkkaisuu", this);

    public final ExDBFieldString<IT_KoujyoSymSougou, C_Kykjyoutai> kykjyoutai = new ExDBFieldString<>("kykjyoutai", this, UserType_C_Kykjyoutai.class);

    public final ExDBFieldString<IT_KoujyoSymSougou, C_YuukousyoumetuKbn> yuukousyoumetukbn = new ExDBFieldString<>("yuukousyoumetukbn", this, UserType_C_YuukousyoumetuKbn.class);

    public final ExDBFieldString<IT_KoujyoSymSougou, C_HaitouhouKbn> haitouhoukbn = new ExDBFieldString<>("haitouhoukbn", this, UserType_C_HaitouhouKbn.class);

    public final ExDBFieldString<IT_KoujyoSymSougou, C_HaitoukinuketorihouKbn> haitoukinuketorihoukbn = new ExDBFieldString<>("haitoukinuketorihoukbn", this, UserType_C_HaitoukinuketorihouKbn.class);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> oldippanjissekip = new ExDBFieldBizCurrency<>("oldippanjissekip", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> oldippannenkanp = new ExDBFieldBizCurrency<>("oldippannenkanp", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> oldippanjissekihaitoukin = new ExDBFieldBizCurrency<>("oldippanjissekihaitoukin", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> oldippannenkanhaitoukin = new ExDBFieldBizCurrency<>("oldippannenkanhaitoukin", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> oldippanjissekisyoumeigk = new ExDBFieldBizCurrency<>("oldippanjissekisyoumeigk", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> oldippannenkansyoumeigk = new ExDBFieldBizCurrency<>("oldippannenkansyoumeigk", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> newippanjissekip = new ExDBFieldBizCurrency<>("newippanjissekip", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> newippannenkanp = new ExDBFieldBizCurrency<>("newippannenkanp", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> newippanjissekihaitoukin = new ExDBFieldBizCurrency<>("newippanjissekihaitoukin", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> newippannenkanhaitoukin = new ExDBFieldBizCurrency<>("newippannenkanhaitoukin", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> newippanjissekisyoumeigk = new ExDBFieldBizCurrency<>("newippanjissekisyoumeigk", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> newippannenkansyoumeigk = new ExDBFieldBizCurrency<>("newippannenkansyoumeigk", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> newiryoujissekip = new ExDBFieldBizCurrency<>("newiryoujissekip", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> newiryounenkanp = new ExDBFieldBizCurrency<>("newiryounenkanp", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> newiryoujissekihaitoukin = new ExDBFieldBizCurrency<>("newiryoujissekihaitoukin", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> newiryounenkanhaitoukin = new ExDBFieldBizCurrency<>("newiryounenkanhaitoukin", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> newiryoujissekisyoumeigk = new ExDBFieldBizCurrency<>("newiryoujissekisyoumeigk", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> newiryounenkansyoumeigk = new ExDBFieldBizCurrency<>("newiryounenkansyoumeigk", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> newnkjissekip = new ExDBFieldBizCurrency<>("newnkjissekip", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> newnknenkanp = new ExDBFieldBizCurrency<>("newnknenkanp", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> newnkjissekihaitoukin = new ExDBFieldBizCurrency<>("newnkjissekihaitoukin", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> newnknenkanhaitoukin = new ExDBFieldBizCurrency<>("newnknenkanhaitoukin", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> newnkjissekisyoumeigk = new ExDBFieldBizCurrency<>("newnkjissekisyoumeigk", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymSougou> newnknenkansyoumeigk = new ExDBFieldBizCurrency<>("newnknenkansyoumeigk", this);

    public final ExDBFieldNumber<IT_KoujyoSymSougou, Integer> rtratkicd = new ExDBFieldNumber<>("rtratkicd", this);

    public final ExDBFieldString<IT_KoujyoSymSougou, String> rtyouhyoucd = new ExDBFieldString<>("rtyouhyoucd", this);

    public final ExDBFieldString<IT_KoujyoSymSougou, C_TyhyrenrakusikibetuKbn> tyhyrenrakusikibetukbn = new ExDBFieldString<>("tyhyrenrakusikibetukbn", this, UserType_C_TyhyrenrakusikibetuKbn.class);

    public final ExDBFieldString<IT_KoujyoSymSougou, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KoujyoSymSougou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KoujyoSymSougou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
