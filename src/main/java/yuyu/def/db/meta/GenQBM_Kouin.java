package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BM_Kouin;

/**
 * 行員マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_Kouin extends AbstractExDBTable<BM_Kouin> {

    public GenQBM_Kouin() {
        this("BM_Kouin");
    }

    public GenQBM_Kouin(String pAlias) {
        super("BM_Kouin", BM_Kouin.class, pAlias);
    }

    public String BM_Kouin() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_Kouin, String> kinyuucd = new ExDBFieldString<>("kinyuucd", this);

    public final ExDBFieldString<BM_Kouin, String> kouincd = new ExDBFieldString<>("kouincd", this);

    public final ExDBFieldString<BM_Kouin, String> bosyuucd = new ExDBFieldString<>("bosyuucd", this);
}
