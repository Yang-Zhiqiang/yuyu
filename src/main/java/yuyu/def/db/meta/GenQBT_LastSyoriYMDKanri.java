package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_LastSyoriymdKanriKbn;
import yuyu.def.db.entity.BT_LastSyoriYMDKanri;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_LastSyoriymdKanriKbn;

/**
 * 最終処理日管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_LastSyoriYMDKanri extends AbstractExDBTable<BT_LastSyoriYMDKanri> {

    public GenQBT_LastSyoriYMDKanri() {
        this("BT_LastSyoriYMDKanri");
    }

    public GenQBT_LastSyoriYMDKanri(String pAlias) {
        super("BT_LastSyoriYMDKanri", BT_LastSyoriYMDKanri.class, pAlias);
    }

    public String BT_LastSyoriYMDKanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_LastSyoriYMDKanri, C_LastSyoriymdKanriKbn> lastsyoriymdkanrikbn = new ExDBFieldString<>("lastsyoriymdkanrikbn", this, UserType_C_LastSyoriymdKanriKbn.class);

    public final ExDBFieldString<BT_LastSyoriYMDKanri, BizDate> lastsyoriymd = new ExDBFieldString<>("lastsyoriymd", this, BizDateType.class);
}
