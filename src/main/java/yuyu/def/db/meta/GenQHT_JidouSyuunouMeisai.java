package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KessanKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_JidouSyuunouMeisai;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KessanKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 自動収納照合明細テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_JidouSyuunouMeisai extends AbstractExDBTable<HT_JidouSyuunouMeisai> {

    public GenQHT_JidouSyuunouMeisai() {
        this("HT_JidouSyuunouMeisai");
    }

    public GenQHT_JidouSyuunouMeisai(String pAlias) {
        super("HT_JidouSyuunouMeisai", HT_JidouSyuunouMeisai.class, pAlias);
    }

    public String HT_JidouSyuunouMeisai() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_JidouSyuunouMeisai, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HT_JidouSyuunouMeisai, C_KessanKbn> kessankbn = new ExDBFieldString<>("kessankbn", this, UserType_C_KessanKbn.class);

    public final ExDBFieldString<HT_JidouSyuunouMeisai, C_Tuukasyu> rstuukasyu = new ExDBFieldString<>("rstuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldNumber<HT_JidouSyuunouMeisai, Integer> sgittikensuu = new ExDBFieldNumber<>("sgittikensuu", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai> sgittigk = new ExDBFieldBizCurrency<>("sgittigk", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai> sgittigkyen = new ExDBFieldBizCurrency<>("sgittigkyen", this);

    public final ExDBFieldNumber<HT_JidouSyuunouMeisai, Integer> sghuittikensuu = new ExDBFieldNumber<>("sghuittikensuu", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai> sghuittigk = new ExDBFieldBizCurrency<>("sghuittigk", this);

    public final ExDBFieldNumber<HT_JidouSyuunouMeisai, Integer> mostrkskensuu = new ExDBFieldNumber<>("mostrkskensuu", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai> mostrksgk = new ExDBFieldBizCurrency<>("mostrksgk", this);

    public final ExDBFieldNumber<HT_JidouSyuunouMeisai, Integer> yuukoukknkeikakensuu = new ExDBFieldNumber<>("yuukoukknkeikakensuu", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai> yuukoukknkeikagk = new ExDBFieldBizCurrency<>("yuukoukknkeikagk", this);

    public final ExDBFieldNumber<HT_JidouSyuunouMeisai, Integer> yokukurikosikensuu = new ExDBFieldNumber<>("yokukurikosikensuu", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai> yokukurikosigk = new ExDBFieldBizCurrency<>("yokukurikosigk", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai> yokukurikosigkyen = new ExDBFieldBizCurrency<>("yokukurikosigkyen", this);

    public final ExDBFieldNumber<HT_JidouSyuunouMeisai, Integer> jnykntsgkensuu = new ExDBFieldNumber<>("jnykntsgkensuu", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai> jnykntsggk = new ExDBFieldBizCurrency<>("jnykntsggk", this);

    public final ExDBFieldNumber<HT_JidouSyuunouMeisai, Integer> tjkensuu = new ExDBFieldNumber<>("tjkensuu", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai> tjgk = new ExDBFieldBizCurrency<>("tjgk", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai> tjgkyen = new ExDBFieldBizCurrency<>("tjgkyen", this);

    public final ExDBFieldNumber<HT_JidouSyuunouMeisai, Integer> zenjitukurikosikensuu = new ExDBFieldNumber<>("zenjitukurikosikensuu", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai> zenjitukurikosigk = new ExDBFieldBizCurrency<>("zenjitukurikosigk", this);

    public final ExDBFieldNumber<HT_JidouSyuunouMeisai, Integer> hrkmtsrykensuu = new ExDBFieldNumber<>("hrkmtsrykensuu", this);

    public final ExDBFieldBizCurrency<HT_JidouSyuunouMeisai> hrkmtsrykingk = new ExDBFieldBizCurrency<>("hrkmtsrykingk", this);

    public final ExDBFieldString<HT_JidouSyuunouMeisai, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_JidouSyuunouMeisai, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
