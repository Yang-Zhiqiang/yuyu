package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SateiKokuhanInfo;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 査定告反情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SateiKokuhanInfo extends AbstractExDBTable<JT_SateiKokuhanInfo> {

    public GenQJT_SateiKokuhanInfo() {
        this("JT_SateiKokuhanInfo");
    }

    public GenQJT_SateiKokuhanInfo(String pAlias) {
        super("JT_SateiKokuhanInfo", JT_SateiKokuhanInfo.class, pAlias);
    }

    public String JT_SateiKokuhanInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SateiKokuhanInfo, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_SateiKokuhanInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_SateiKokuhanInfo, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldString<JT_SateiKokuhanInfo, C_UmuKbn> kokuhancheckkbn1 = new ExDBFieldString<>("kokuhancheckkbn1", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SateiKokuhanInfo, String> kokuhanchecomment1 = new ExDBFieldString<>("kokuhanchecomment1", this);

    public final ExDBFieldString<JT_SateiKokuhanInfo, C_UmuKbn> kokuhancheckkbn2 = new ExDBFieldString<>("kokuhancheckkbn2", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SateiKokuhanInfo, String> kokuhanchecomment2 = new ExDBFieldString<>("kokuhanchecomment2", this);

    public final ExDBFieldString<JT_SateiKokuhanInfo, C_UmuKbn> kokuhancheckkbn3 = new ExDBFieldString<>("kokuhancheckkbn3", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SateiKokuhanInfo, String> kokuhanchecomment3 = new ExDBFieldString<>("kokuhanchecomment3", this);

    public final ExDBFieldString<JT_SateiKokuhanInfo, C_UmuKbn> kokuhancheckkbn4 = new ExDBFieldString<>("kokuhancheckkbn4", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SateiKokuhanInfo, String> kokuhanchecomment4 = new ExDBFieldString<>("kokuhanchecomment4", this);

    public final ExDBFieldString<JT_SateiKokuhanInfo, C_UmuKbn> kokuhancheckkbn5 = new ExDBFieldString<>("kokuhancheckkbn5", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SateiKokuhanInfo, String> kokuhanchecomment5 = new ExDBFieldString<>("kokuhanchecomment5", this);

    public final ExDBFieldString<JT_SateiKokuhanInfo, C_UmuKbn> kokuhancheckkbn6 = new ExDBFieldString<>("kokuhancheckkbn6", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SateiKokuhanInfo, String> kokuhanchecomment6 = new ExDBFieldString<>("kokuhanchecomment6", this);

    public final ExDBFieldString<JT_SateiKokuhanInfo, C_UmuKbn> kokuhancheckkbn7 = new ExDBFieldString<>("kokuhancheckkbn7", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SateiKokuhanInfo, String> kokuhanchecomment7 = new ExDBFieldString<>("kokuhanchecomment7", this);

    public final ExDBFieldString<JT_SateiKokuhanInfo, C_UmuKbn> kokuhancheckkbn8 = new ExDBFieldString<>("kokuhancheckkbn8", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SateiKokuhanInfo, String> kokuhanchecomment8 = new ExDBFieldString<>("kokuhanchecomment8", this);

    public final ExDBFieldString<JT_SateiKokuhanInfo, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_SateiKokuhanInfo, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_SateiKokuhanInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SateiKokuhanInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
