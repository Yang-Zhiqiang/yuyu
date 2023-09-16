package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_MeihenUktKbn;
import yuyu.def.classification.C_MeihenYuukouMukouKbn;
import yuyu.def.db.entity.JT_SateiMeigihenkouInfo;
import yuyu.def.db.type.UserType_C_MeihenUktKbn;
import yuyu.def.db.type.UserType_C_MeihenYuukouMukouKbn;

/**
 * 査定名義変更情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SateiMeigihenkouInfo extends AbstractExDBTable<JT_SateiMeigihenkouInfo> {

    public GenQJT_SateiMeigihenkouInfo() {
        this("JT_SateiMeigihenkouInfo");
    }

    public GenQJT_SateiMeigihenkouInfo(String pAlias) {
        super("JT_SateiMeigihenkouInfo", JT_SateiMeigihenkouInfo.class, pAlias);
    }

    public String JT_SateiMeigihenkouInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SateiMeigihenkouInfo, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_SateiMeigihenkouInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_SateiMeigihenkouInfo, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldString<JT_SateiMeigihenkouInfo, C_MeihenYuukouMukouKbn> meihenyuukoumukoukbn = new ExDBFieldString<>("meihenyuukoumukoukbn", this, UserType_C_MeihenYuukouMukouKbn.class);

    public final ExDBFieldString<JT_SateiMeigihenkouInfo, C_MeihenUktKbn> meihenuktkbn = new ExDBFieldString<>("meihenuktkbn", this, UserType_C_MeihenUktKbn.class);

    public final ExDBFieldString<JT_SateiMeigihenkouInfo, String> meihenuktnm = new ExDBFieldString<>("meihenuktnm", this);

    public final ExDBFieldString<JT_SateiMeigihenkouInfo, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_SateiMeigihenkouInfo, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_SateiMeigihenkouInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SateiMeigihenkouInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
