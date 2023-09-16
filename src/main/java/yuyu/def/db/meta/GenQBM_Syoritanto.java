package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.BM_Syoritanto;
import yuyu.def.db.type.UserType_C_TantouCdKbn;

/**
 * 処理担当マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_Syoritanto extends AbstractExDBTable<BM_Syoritanto> {

    public GenQBM_Syoritanto() {
        this("BM_Syoritanto");
    }

    public GenQBM_Syoritanto(String pAlias) {
        super("BM_Syoritanto", BM_Syoritanto.class, pAlias);
    }

    public String BM_Syoritanto() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_Syoritanto, String> syoricd = new ExDBFieldString<>("syoricd", this);

    public final ExDBFieldString<BM_Syoritanto, C_TantouCdKbn> tantocd = new ExDBFieldString<>("tantocd", this, UserType_C_TantouCdKbn.class);
}
