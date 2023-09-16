package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.MT_DsTtdkRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DsSyoriKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * ＤＳ手続履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_DsTtdkRireki extends AbstractExDBTable<MT_DsTtdkRireki> {

    public GenQMT_DsTtdkRireki() {
        this("MT_DsTtdkRireki");
    }

    public GenQMT_DsTtdkRireki(String pAlias) {
        super("MT_DsTtdkRireki", MT_DsTtdkRireki.class, pAlias);
    }

    public String MT_DsTtdkRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_DsTtdkRireki, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldString<MT_DsTtdkRireki, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<MT_DsTtdkRireki, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsTtdkRireki, C_DsSyoriKbn> dssyorikbn = new ExDBFieldString<>("dssyorikbn", this, UserType_C_DsSyoriKbn.class);

    public final ExDBFieldString<MT_DsTtdkRireki, C_UmuKbn> henkourrkumu = new ExDBFieldString<>("henkourrkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<MT_DsTtdkRireki, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_DsTtdkRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<MT_DsTtdkRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);
}
