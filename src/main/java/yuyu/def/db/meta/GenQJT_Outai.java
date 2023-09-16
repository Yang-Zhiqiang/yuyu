package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_SouhusakiKbn;
import yuyu.def.classification.C_SyuhiYouhi;
import yuyu.def.db.entity.JT_Outai;
import yuyu.def.db.type.UserType_C_MousideninKbn;
import yuyu.def.db.type.UserType_C_NayoseYouhi;
import yuyu.def.db.type.UserType_C_SouhusakiKbn;
import yuyu.def.db.type.UserType_C_SyuhiYouhi;

/**
 * 応対テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_Outai extends AbstractExDBTable<JT_Outai> {

    public GenQJT_Outai() {
        this("JT_Outai");
    }

    public GenQJT_Outai(String pAlias) {
        super("JT_Outai", JT_Outai.class, pAlias);
    }

    public String JT_Outai() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_Outai, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_Outai, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<JT_Outai, C_NayoseYouhi> nayoseyouhi = new ExDBFieldString<>("nayoseyouhi", this, UserType_C_NayoseYouhi.class);

    public final ExDBFieldString<JT_Outai, C_MousideninKbn> mousideninkbn = new ExDBFieldString<>("mousideninkbn", this, UserType_C_MousideninKbn.class);

    public final ExDBFieldString<JT_Outai, C_SyuhiYouhi> syuhiyouhi = new ExDBFieldString<>("syuhiyouhi", this, UserType_C_SyuhiYouhi.class);

    public final ExDBFieldString<JT_Outai, String> mousideninnmkj = new ExDBFieldString<>("mousideninnmkj", this);

    public final ExDBFieldString<JT_Outai, C_SouhusakiKbn> souhusakikbn = new ExDBFieldString<>("souhusakikbn", this, UserType_C_SouhusakiKbn.class);

    public final ExDBFieldString<JT_Outai, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<JT_Outai, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<JT_Outai, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<JT_Outai, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<JT_Outai, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldNumber<JT_Outai, Integer> betukyksuu = new ExDBFieldNumber<>("betukyksuu", this);

    public final ExDBFieldString<JT_Outai, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_Outai, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_Outai, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_Outai, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
