package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KessanKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_JidouSyuunouMeisai2;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KessanKbn;
import yuyu.def.db.type.UserType_C_NyktyhyoutKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 自動収納照合明細テーブル２ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_JidouSyuunouMeisai2 extends AbstractExDBTable<HT_JidouSyuunouMeisai2> {

    public GenQHT_JidouSyuunouMeisai2() {
        this("HT_JidouSyuunouMeisai2");
    }

    public GenQHT_JidouSyuunouMeisai2(String pAlias) {
        super("HT_JidouSyuunouMeisai2", HT_JidouSyuunouMeisai2.class, pAlias);
    }

    public String HT_JidouSyuunouMeisai2() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_JidouSyuunouMeisai2, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HT_JidouSyuunouMeisai2, C_KessanKbn> kessankbn = new ExDBFieldString<>("kessankbn", this, UserType_C_KessanKbn.class);

    public final ExDBFieldString<HT_JidouSyuunouMeisai2, C_Tuukasyu> rstuukasyu = new ExDBFieldString<>("rstuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HT_JidouSyuunouMeisai2, C_NyktyhyoutKbn> nyktyhyoutkbn = new ExDBFieldString<>("nyktyhyoutkbn", this, UserType_C_NyktyhyoutKbn.class);

    public final ExDBFieldNumber<HT_JidouSyuunouMeisai2, Integer> sgittikensuu = new ExDBFieldNumber<>("sgittikensuu", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai2> sgittigk = new ExDBFieldBizCurrency<>("sgittigk", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai2> sgittigkyen = new ExDBFieldBizCurrency<>("sgittigkyen", this);

    public final ExDBFieldNumber<HT_JidouSyuunouMeisai2, Integer> sghuittikensuu = new ExDBFieldNumber<>("sghuittikensuu", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai2> sghuittigk = new ExDBFieldBizCurrency<>("sghuittigk", this);

    public final ExDBFieldNumber<HT_JidouSyuunouMeisai2, Integer> mostrkskensuu = new ExDBFieldNumber<>("mostrkskensuu", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai2> mostrksgk = new ExDBFieldBizCurrency<>("mostrksgk", this);

    public final ExDBFieldNumber<HT_JidouSyuunouMeisai2, Integer> yuukoukknkeikakensuu = new ExDBFieldNumber<>("yuukoukknkeikakensuu", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai2> yuukoukknkeikagk = new ExDBFieldBizCurrency<>("yuukoukknkeikagk", this);

    public final ExDBFieldNumber<HT_JidouSyuunouMeisai2, Integer> yokukurikosikensuu = new ExDBFieldNumber<>("yokukurikosikensuu", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai2> yokukurikosigk = new ExDBFieldBizCurrency<>("yokukurikosigk", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai2> yokukurikosigkyen = new ExDBFieldBizCurrency<>("yokukurikosigkyen", this);

    public final ExDBFieldNumber<HT_JidouSyuunouMeisai2, Integer> jnykntsgkensuu = new ExDBFieldNumber<>("jnykntsgkensuu", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai2> jnykntsggk = new ExDBFieldBizCurrency<>("jnykntsggk", this);

    public final ExDBFieldNumber<HT_JidouSyuunouMeisai2, Integer> tjkensuu = new ExDBFieldNumber<>("tjkensuu", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai2> tjgk = new ExDBFieldBizCurrency<>("tjgk", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai2> tjgkyen = new ExDBFieldBizCurrency<>("tjgkyen", this);

    public final ExDBFieldNumber<HT_JidouSyuunouMeisai2, Integer> zenjitukurikosikensuu = new ExDBFieldNumber<>("zenjitukurikosikensuu", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai2> zenjitukurikosigk = new ExDBFieldBizCurrency<>("zenjitukurikosigk", this);

    public final ExDBFieldNumber<HT_JidouSyuunouMeisai2, Integer> hrkmtsrykensuu = new ExDBFieldNumber<>("hrkmtsrykensuu", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai2> hrkmtsrykingk = new ExDBFieldBizCurrency<>("hrkmtsrykingk", this);

    public final ExDBFieldString<HT_JidouSyuunouMeisai2, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_JidouSyuunouMeisai2, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
