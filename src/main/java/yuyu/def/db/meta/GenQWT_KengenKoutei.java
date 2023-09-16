package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.WT_KengenKoutei;

/**
 * 権限明細（工程）テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQWT_KengenKoutei extends AbstractExDBTable<WT_KengenKoutei> {

    public GenQWT_KengenKoutei() {
        this("WT_KengenKoutei");
    }

    public GenQWT_KengenKoutei(String pAlias) {
        super("WT_KengenKoutei", WT_KengenKoutei.class, pAlias);
    }

    public String WT_KengenKoutei() {
        return getAliasExpression();
    }

    public final ExDBFieldString<WT_KengenKoutei, String> roleCd = new ExDBFieldString<>("roleCd", this);

    public final ExDBFieldString<WT_KengenKoutei, String> flowId = new ExDBFieldString<>("flowId", this);

    public final ExDBFieldString<WT_KengenKoutei, String> nodeId = new ExDBFieldString<>("nodeId", this);
}
