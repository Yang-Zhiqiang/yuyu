package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_CreditcardHrKskmKbn;
import yuyu.def.classification.C_KrkPayEasyHrkmyousiNkKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NyuuryokuKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.entity.IT_KhKesikomiData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_CreditcardHrKskmKbn;
import yuyu.def.db.type.UserType_C_KrkPayEasyHrkmyousiNkKbn;
import yuyu.def.db.type.UserType_C_Nykkeiro;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_NyuuryokuKbn;
import yuyu.def.db.type.UserType_C_Syuudaikocd;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;

/**
 * 消込データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhKesikomiData extends AbstractExDBTable<IT_KhKesikomiData> {

    public GenQIT_KhKesikomiData() {
        this("IT_KhKesikomiData");
    }

    public GenQIT_KhKesikomiData(String pAlias) {
        super("IT_KhKesikomiData", IT_KhKesikomiData.class, pAlias);
    }

    public String IT_KhKesikomiData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhKesikomiData, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KhKesikomiData, String> nyuukinkakusyouno = new ExDBFieldString<>("nyuukinkakusyouno", this);

    public final ExDBFieldString<IT_KhKesikomiData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KhKesikomiData, C_NyknaiyouKbn> nyknaiyoukbn = new ExDBFieldString<>("nyknaiyoukbn", this, UserType_C_NyknaiyouKbn.class);

    public final ExDBFieldString<IT_KhKesikomiData, C_NyuuryokuKbn> nyuuryokukbn = new ExDBFieldString<>("nyuuryokukbn", this, UserType_C_NyuuryokuKbn.class);

    public final ExDBFieldString<IT_KhKesikomiData, C_Nykkeiro> nykkeiro = new ExDBFieldString<>("nykkeiro", this, UserType_C_Nykkeiro.class);

    public final ExDBFieldString<IT_KhKesikomiData, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_KhKesikomiData, BizDate> nyuukinkakusyounrkymd = new ExDBFieldString<>("nyuukinkakusyounrkymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhKesikomiData, BizDate> ryosyuymd = new ExDBFieldString<>("ryosyuymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_KhKesikomiData> rsgaku = new ExDBFieldBizCurrency<>("rsgaku", this);

    public final ExDBFieldString<IT_KhKesikomiData, BizDate> nykdenymd = new ExDBFieldString<>("nykdenymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhKesikomiData, String> nyuukinkakusyounrkno = new ExDBFieldString<>("nyuukinkakusyounrkno", this);

    public final ExDBFieldString<IT_KhKesikomiData, C_TaisyakuKbn> taisyakukbn = new ExDBFieldString<>("taisyakukbn", this, UserType_C_TaisyakuKbn.class);

    public final ExDBFieldString<IT_KhKesikomiData, String> suitono = new ExDBFieldString<>("suitono", this);

    public final ExDBFieldString<IT_KhKesikomiData, String> suitoubumoncd = new ExDBFieldString<>("suitoubumoncd", this);

    public final ExDBFieldString<IT_KhKesikomiData, String> karikanjyono = new ExDBFieldString<>("karikanjyono", this);

    public final ExDBFieldString<IT_KhKesikomiData, String> kzhurikaebankcd = new ExDBFieldString<>("kzhurikaebankcd", this);

    public final ExDBFieldString<IT_KhKesikomiData, C_KrkPayEasyHrkmyousiNkKbn> hrkmyousinkkbn = new ExDBFieldString<>("hrkmyousinkkbn", this, UserType_C_KrkPayEasyHrkmyousiNkKbn.class);

    public final ExDBFieldString<IT_KhKesikomiData, String> suitososhikicd = new ExDBFieldString<>("suitososhikicd", this);

    public final ExDBFieldString<IT_KhKesikomiData, C_CreditcardHrKskmKbn> creditcardhrkskmkbn = new ExDBFieldString<>("creditcardhrkskmkbn", this, UserType_C_CreditcardHrKskmKbn.class);

    public final ExDBFieldString<IT_KhKesikomiData, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhKesikomiData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhKesikomiData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_KhKesikomiData, C_Syuudaikocd> syuudaikocd = new ExDBFieldString<>("syuudaikocd", this, UserType_C_Syuudaikocd.class);
}
