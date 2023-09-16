package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BM_Syokugyou;

/**
 * 職業マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_Syokugyou extends AbstractExDBTable<BM_Syokugyou> {

    public GenQBM_Syokugyou() {
        this("BM_Syokugyou");
    }

    public GenQBM_Syokugyou(String pAlias) {
        super("BM_Syokugyou", BM_Syokugyou.class, pAlias);
    }

    public String BM_Syokugyou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_Syokugyou, String> syokugyoucd = new ExDBFieldString<>("syokugyoucd", this);

    public final ExDBFieldString<BM_Syokugyou, String> syokugyounm = new ExDBFieldString<>("syokugyounm", this);

    public final ExDBFieldString<BM_Syokugyou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BM_Syokugyou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
