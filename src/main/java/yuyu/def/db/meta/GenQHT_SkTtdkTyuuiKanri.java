package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.HT_SkTtdkTyuuiKanri;
import yuyu.def.db.type.UserType_C_YouhiKbn;

/**
 * 新契約手続注意管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SkTtdkTyuuiKanri extends AbstractExDBTable<HT_SkTtdkTyuuiKanri> {

    public GenQHT_SkTtdkTyuuiKanri() {
        this("HT_SkTtdkTyuuiKanri");
    }

    public GenQHT_SkTtdkTyuuiKanri(String pAlias) {
        super("HT_SkTtdkTyuuiKanri", HT_SkTtdkTyuuiKanri.class, pAlias);
    }

    public String HT_SkTtdkTyuuiKanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SkTtdkTyuuiKanri, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_SkTtdkTyuuiKanri, C_YouhiKbn> skeittdkkinkyuyouhikbn = new ExDBFieldString<>("skeittdkkinkyuyouhikbn", this, UserType_C_YouhiKbn.class);

    public final ExDBFieldString<HT_SkTtdkTyuuiKanri, C_YouhiKbn> skeittdktyuuiyouhikbn = new ExDBFieldString<>("skeittdktyuuiyouhikbn", this, UserType_C_YouhiKbn.class);

    public final ExDBFieldString<HT_SkTtdkTyuuiKanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SkTtdkTyuuiKanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
