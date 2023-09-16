package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BM_DairitenSyougou;

/**
 * 代理店法人商号マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_DairitenSyougou extends AbstractExDBTable<BM_DairitenSyougou> {

    public GenQBM_DairitenSyougou() {
        this("BM_DairitenSyougou");
    }

    public GenQBM_DairitenSyougou(String pAlias) {
        super("BM_DairitenSyougou", BM_DairitenSyougou.class, pAlias);
    }

    public String BM_DairitenSyougou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_DairitenSyougou, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<BM_DairitenSyougou, String> kanjihoujinsyougou = new ExDBFieldString<>("kanjihoujinsyougou", this);
}
