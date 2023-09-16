package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_DispKbn;
import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.classification.C_KoujyosymnaiyourecKbn;
import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_TekiyouseidoKbn;
import yuyu.def.db.entity.IT_BAK_KoujyoSymNaiyou;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Delflag;
import yuyu.def.db.type.UserType_C_DispKbn;
import yuyu.def.db.type.UserType_C_Kjsmhakkouzumiflg;
import yuyu.def.db.type.UserType_C_KoujyosymnaiyourecKbn;
import yuyu.def.db.type.UserType_C_KoujyosyoumeipKbn;
import yuyu.def.db.type.UserType_C_TekiyouseidoKbn;

/**
 * 控除証明内容バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_KoujyoSymNaiyou extends AbstractExDBTable<IT_BAK_KoujyoSymNaiyou> {

    public GenQIT_BAK_KoujyoSymNaiyou() {
        this("IT_BAK_KoujyoSymNaiyou");
    }

    public GenQIT_BAK_KoujyoSymNaiyou(String pAlias) {
        super("IT_BAK_KoujyoSymNaiyou", IT_BAK_KoujyoSymNaiyou.class, pAlias);
    }

    public String IT_BAK_KoujyoSymNaiyou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_KoujyoSymNaiyou, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_KoujyoSymNaiyou, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_KoujyoSymNaiyou, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_KoujyoSymNaiyou, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<IT_BAK_KoujyoSymNaiyou, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<IT_BAK_KoujyoSymNaiyou, String> koujyosyoumeinnd = new ExDBFieldString<>("koujyosyoumeinnd", this);

    public final ExDBFieldString<IT_BAK_KoujyoSymNaiyou, BizDateYM> syoumeistartym = new ExDBFieldString<>("syoumeistartym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_BAK_KoujyoSymNaiyou, BizDateYM> syoumeiendym = new ExDBFieldString<>("syoumeiendym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_BAK_KoujyoSymNaiyou, C_KoujyosyoumeipKbn> koujyosyoumeipkbn = new ExDBFieldString<>("koujyosyoumeipkbn", this, UserType_C_KoujyosyoumeipKbn.class);

    public final ExDBFieldString<IT_BAK_KoujyoSymNaiyou, C_TekiyouseidoKbn> tekiyouseidokbn = new ExDBFieldString<>("tekiyouseidokbn", this, UserType_C_TekiyouseidoKbn.class);

    public final ExDBFieldString<IT_BAK_KoujyoSymNaiyou, C_KoujyosymnaiyourecKbn> koujyosymnaiyoureckbn = new ExDBFieldString<>("koujyosymnaiyoureckbn", this, UserType_C_KoujyosymnaiyourecKbn.class);

    public final ExDBFieldBizCurrency<IT_BAK_KoujyoSymNaiyou> koujyosyoumeigk = new ExDBFieldBizCurrency<>("koujyosyoumeigk", this);

    public final ExDBFieldString<IT_BAK_KoujyoSymNaiyou, BizDateYM> jyutoustartym = new ExDBFieldString<>("jyutoustartym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_BAK_KoujyoSymNaiyou, Integer> nyknjskrrkrenno = new ExDBFieldNumber<>("nyknjskrrkrenno", this);

    public final ExDBFieldNumber<IT_BAK_KoujyoSymNaiyou, Integer> kihrkpssrrkrenno = new ExDBFieldNumber<>("kihrkpssrrkrenno", this);

    public final ExDBFieldString<IT_BAK_KoujyoSymNaiyou, C_Kjsmhakkouzumiflg> kjsmhakkouzumiflg = new ExDBFieldString<>("kjsmhakkouzumiflg", this, UserType_C_Kjsmhakkouzumiflg.class);

    public final ExDBFieldString<IT_BAK_KoujyoSymNaiyou, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_KoujyoSymNaiyou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_KoujyoSymNaiyou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_BAK_KoujyoSymNaiyou, C_Delflag> sakujyoflg = new ExDBFieldString<>("sakujyoflg", this, UserType_C_Delflag.class);

    public final ExDBFieldString<IT_BAK_KoujyoSymNaiyou, BizDate> zennoukaisiymd = new ExDBFieldString<>("zennoukaisiymd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_BAK_KoujyoSymNaiyou, Integer> zennourenno = new ExDBFieldNumber<>("zennourenno", this);

    public final ExDBFieldString<IT_BAK_KoujyoSymNaiyou, C_DispKbn> keisanhukahyoujikbn = new ExDBFieldString<>("keisanhukahyoujikbn", this, UserType_C_DispKbn.class);

    public final ExDBFieldString<IT_BAK_KoujyoSymNaiyou, String> keisanhukariyuucd = new ExDBFieldString<>("keisanhukariyuucd", this);
}
