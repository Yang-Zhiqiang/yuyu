package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.db.entity.JT_BetukutiSateiInfo;
import yuyu.def.db.type.UserType_C_NoinitUmuKbn;

/**
 * 別口査定情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_BetukutiSateiInfo extends AbstractExDBTable<JT_BetukutiSateiInfo> {

    public GenQJT_BetukutiSateiInfo() {
        this("JT_BetukutiSateiInfo");
    }

    public GenQJT_BetukutiSateiInfo(String pAlias) {
        super("JT_BetukutiSateiInfo", JT_BetukutiSateiInfo.class, pAlias);
    }

    public String JT_BetukutiSateiInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_BetukutiSateiInfo, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_BetukutiSateiInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_BetukutiSateiInfo, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldString<JT_BetukutiSateiInfo, C_NoinitUmuKbn> betusibouumukbn = new ExDBFieldString<>("betusibouumukbn", this, UserType_C_NoinitUmuKbn.class);

    public final ExDBFieldString<JT_BetukutiSateiInfo, String> betusiboucomment = new ExDBFieldString<>("betusiboucomment", this);

    public final ExDBFieldString<JT_BetukutiSateiInfo, C_NoinitUmuKbn> betukdsgumukbn = new ExDBFieldString<>("betukdsgumukbn", this, UserType_C_NoinitUmuKbn.class);

    public final ExDBFieldString<JT_BetukutiSateiInfo, String> betukdsgcomment = new ExDBFieldString<>("betukdsgcomment", this);

    public final ExDBFieldString<JT_BetukutiSateiInfo, C_NoinitUmuKbn> betusoukiumukbn = new ExDBFieldString<>("betusoukiumukbn", this, UserType_C_NoinitUmuKbn.class);

    public final ExDBFieldString<JT_BetukutiSateiInfo, String> betusoukicomment = new ExDBFieldString<>("betusoukicomment", this);

    public final ExDBFieldString<JT_BetukutiSateiInfo, C_NoinitUmuKbn> betusymtkykumukbn = new ExDBFieldString<>("betusymtkykumukbn", this, UserType_C_NoinitUmuKbn.class);

    public final ExDBFieldString<JT_BetukutiSateiInfo, String> betusymtkykcomment = new ExDBFieldString<>("betusymtkykcomment", this);

    public final ExDBFieldString<JT_BetukutiSateiInfo, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_BetukutiSateiInfo, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_BetukutiSateiInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_BetukutiSateiInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
