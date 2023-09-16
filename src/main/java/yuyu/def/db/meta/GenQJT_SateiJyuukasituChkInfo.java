package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SateiJyuukasituChkInfo;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 査定重過失チェック情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SateiJyuukasituChkInfo extends AbstractExDBTable<JT_SateiJyuukasituChkInfo> {

    public GenQJT_SateiJyuukasituChkInfo() {
        this("JT_SateiJyuukasituChkInfo");
    }

    public GenQJT_SateiJyuukasituChkInfo(String pAlias) {
        super("JT_SateiJyuukasituChkInfo", JT_SateiJyuukasituChkInfo.class, pAlias);
    }

    public String JT_SateiJyuukasituChkInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SateiJyuukasituChkInfo, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_SateiJyuukasituChkInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_SateiJyuukasituChkInfo, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldString<JT_SateiJyuukasituChkInfo, C_UmuKbn> juukasitucheckkbn1 = new ExDBFieldString<>("juukasitucheckkbn1", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SateiJyuukasituChkInfo, String> juukasitucheckcomment1 = new ExDBFieldString<>("juukasitucheckcomment1", this);

    public final ExDBFieldString<JT_SateiJyuukasituChkInfo, C_UmuKbn> juukasitucheckkbn2 = new ExDBFieldString<>("juukasitucheckkbn2", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SateiJyuukasituChkInfo, String> juukasitucheckcomment2 = new ExDBFieldString<>("juukasitucheckcomment2", this);

    public final ExDBFieldString<JT_SateiJyuukasituChkInfo, C_UmuKbn> juukasitucheckkbn3 = new ExDBFieldString<>("juukasitucheckkbn3", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SateiJyuukasituChkInfo, String> juukasitucheckcomment3 = new ExDBFieldString<>("juukasitucheckcomment3", this);

    public final ExDBFieldString<JT_SateiJyuukasituChkInfo, C_UmuKbn> juukasitucheckkbn4 = new ExDBFieldString<>("juukasitucheckkbn4", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SateiJyuukasituChkInfo, String> juukasitucheckcomment4 = new ExDBFieldString<>("juukasitucheckcomment4", this);

    public final ExDBFieldString<JT_SateiJyuukasituChkInfo, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_SateiJyuukasituChkInfo, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_SateiJyuukasituChkInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SateiJyuukasituChkInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
