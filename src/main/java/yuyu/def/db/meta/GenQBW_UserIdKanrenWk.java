package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BW_UserIdKanrenWk;

/**
 * ユーザーＩＤ関連ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBW_UserIdKanrenWk extends AbstractExDBTable<BW_UserIdKanrenWk> {

    public GenQBW_UserIdKanrenWk() {
        this("BW_UserIdKanrenWk");
    }

    public GenQBW_UserIdKanrenWk(String pAlias) {
        super("BW_UserIdKanrenWk", BW_UserIdKanrenWk.class, pAlias);
    }

    public String BW_UserIdKanrenWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BW_UserIdKanrenWk, String> idkbn = new ExDBFieldString<>("idkbn", this);

    public final ExDBFieldString<BW_UserIdKanrenWk, String> idcd = new ExDBFieldString<>("idcd", this);

    public final ExDBFieldString<BW_UserIdKanrenWk, String> userId = new ExDBFieldString<>("userId", this);
}
