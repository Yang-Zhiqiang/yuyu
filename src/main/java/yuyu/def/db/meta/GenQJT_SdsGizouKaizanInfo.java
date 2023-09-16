package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_TelkknKbn;
import yuyu.def.db.entity.JT_SdsGizouKaizanInfo;
import yuyu.def.db.type.UserType_C_NoinitUmuKbn;
import yuyu.def.db.type.UserType_C_TelkknKbn;

/**
 * 診断書偽造改竄情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SdsGizouKaizanInfo extends AbstractExDBTable<JT_SdsGizouKaizanInfo> {

    public GenQJT_SdsGizouKaizanInfo() {
        this("JT_SdsGizouKaizanInfo");
    }

    public GenQJT_SdsGizouKaizanInfo(String pAlias) {
        super("JT_SdsGizouKaizanInfo", JT_SdsGizouKaizanInfo.class, pAlias);
    }

    public String JT_SdsGizouKaizanInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SdsGizouKaizanInfo, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_SdsGizouKaizanInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_SdsGizouKaizanInfo, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldString<JT_SdsGizouKaizanInfo, C_NoinitUmuKbn> sindansyogizokaizanumukbn = new ExDBFieldString<>("sindansyogizokaizanumukbn", this, UserType_C_NoinitUmuKbn.class);

    public final ExDBFieldString<JT_SdsGizouKaizanInfo, C_TelkknKbn> sindansyogizokaizanjisikbn = new ExDBFieldString<>("sindansyogizokaizanjisikbn", this, UserType_C_TelkknKbn.class);

    public final ExDBFieldString<JT_SdsGizouKaizanInfo, String> sindansyogizokaizanriyuu = new ExDBFieldString<>("sindansyogizokaizanriyuu", this);

    public final ExDBFieldString<JT_SdsGizouKaizanInfo, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_SdsGizouKaizanInfo, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_SdsGizouKaizanInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SdsGizouKaizanInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
