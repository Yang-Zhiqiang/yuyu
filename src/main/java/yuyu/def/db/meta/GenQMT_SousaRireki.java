package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SousaRirekiJkKbn;
import yuyu.def.classification.C_TtdkKekkaKbn;
import yuyu.def.classification.C_TtdkKinouKbn;
import yuyu.def.db.entity.MT_SousaRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_SousaRirekiJkKbn;
import yuyu.def.db.type.UserType_C_TtdkKekkaKbn;
import yuyu.def.db.type.UserType_C_TtdkKinouKbn;

/**
 * 操作履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_SousaRireki extends AbstractExDBTable<MT_SousaRireki> {

    public GenQMT_SousaRireki() {
        this("MT_SousaRireki");
    }

    public GenQMT_SousaRireki(String pAlias) {
        super("MT_SousaRireki", MT_SousaRireki.class, pAlias);
    }

    public String MT_SousaRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_SousaRireki, String> ttdksikibetuid = new ExDBFieldString<>("ttdksikibetuid", this);

    public final ExDBFieldString<MT_SousaRireki, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<MT_SousaRireki, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldString<MT_SousaRireki, BizDate> ttdkstartymd = new ExDBFieldString<>("ttdkstartymd", this, BizDateType.class);

    public final ExDBFieldString<MT_SousaRireki, String> ttdkstarttime = new ExDBFieldString<>("ttdkstarttime", this);

    public final ExDBFieldString<MT_SousaRireki, BizDate> ttdkendymd = new ExDBFieldString<>("ttdkendymd", this, BizDateType.class);

    public final ExDBFieldString<MT_SousaRireki, String> ttdkendtime = new ExDBFieldString<>("ttdkendtime", this);

    public final ExDBFieldString<MT_SousaRireki, C_TtdkKinouKbn> ttdkkinoukbn = new ExDBFieldString<>("ttdkkinoukbn", this, UserType_C_TtdkKinouKbn.class);

    public final ExDBFieldString<MT_SousaRireki, C_SousaRirekiJkKbn> sousarirekijkkbn = new ExDBFieldString<>("sousarirekijkkbn", this, UserType_C_SousaRirekiJkKbn.class);

    public final ExDBFieldString<MT_SousaRireki, C_TtdkKekkaKbn> sousarirekikekkakbn = new ExDBFieldString<>("sousarirekikekkakbn", this, UserType_C_TtdkKekkaKbn.class);

    public final ExDBFieldString<MT_SousaRireki, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_SousaRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<MT_SousaRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
