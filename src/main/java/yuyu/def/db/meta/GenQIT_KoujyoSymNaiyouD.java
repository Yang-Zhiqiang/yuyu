package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.db.entity.IT_KoujyoSymNaiyouD;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYType;
import yuyu.def.db.type.UserType_C_Delflag;
import yuyu.def.db.type.UserType_C_HaitoukinsksKbn;
import yuyu.def.db.type.UserType_C_HaitoumeisaiKbn;
import yuyu.def.db.type.UserType_C_Kjsmhakkouzumiflg;

/**
 * 控除証明内容Ｄテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KoujyoSymNaiyouD extends AbstractExDBTable<IT_KoujyoSymNaiyouD> {

    public GenQIT_KoujyoSymNaiyouD() {
        this("IT_KoujyoSymNaiyouD");
    }

    public GenQIT_KoujyoSymNaiyouD(String pAlias) {
        super("IT_KoujyoSymNaiyouD", IT_KoujyoSymNaiyouD.class, pAlias);
    }

    public String IT_KoujyoSymNaiyouD() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KoujyoSymNaiyouD, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KoujyoSymNaiyouD, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KoujyoSymNaiyouD, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<IT_KoujyoSymNaiyouD, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<IT_KoujyoSymNaiyouD, String> koujyosyoumeinnd = new ExDBFieldString<>("koujyosyoumeinnd", this);

    public final ExDBFieldBizCurrency<IT_KoujyoSymNaiyouD> koujyosyoumeid = new ExDBFieldBizCurrency<>("koujyosyoumeid", this);

    public final ExDBFieldString<IT_KoujyoSymNaiyouD, BizDateY> haitounendo = new ExDBFieldString<>("haitounendo", this, BizDateYType.class);

    public final ExDBFieldNumber<IT_KoujyoSymNaiyouD, Integer> haitoukanrirenno = new ExDBFieldNumber<>("haitoukanrirenno", this);

    public final ExDBFieldString<IT_KoujyoSymNaiyouD, C_HaitoukinsksKbn> haitoukinskskbn = new ExDBFieldString<>("haitoukinskskbn", this, UserType_C_HaitoukinsksKbn.class);

    public final ExDBFieldString<IT_KoujyoSymNaiyouD, C_HaitoumeisaiKbn> haitoumeisaikbn = new ExDBFieldString<>("haitoumeisaikbn", this, UserType_C_HaitoumeisaiKbn.class);

    public final ExDBFieldString<IT_KoujyoSymNaiyouD, C_Kjsmhakkouzumiflg> kjsmhakkouzumiflg = new ExDBFieldString<>("kjsmhakkouzumiflg", this, UserType_C_Kjsmhakkouzumiflg.class);

    public final ExDBFieldString<IT_KoujyoSymNaiyouD, C_Delflag> sakujyoflg = new ExDBFieldString<>("sakujyoflg", this, UserType_C_Delflag.class);

    public final ExDBFieldString<IT_KoujyoSymNaiyouD, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KoujyoSymNaiyouD, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KoujyoSymNaiyouD, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
