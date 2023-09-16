package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.WT_KouteiLock;

/**
 * 工程ロック情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQWT_KouteiLock extends AbstractExDBTable<WT_KouteiLock> {

    public GenQWT_KouteiLock() {
        this("WT_KouteiLock");
    }

    public GenQWT_KouteiLock(String pAlias) {
        super("WT_KouteiLock", WT_KouteiLock.class, pAlias);
    }

    public String WT_KouteiLock() {
        return getAliasExpression();
    }

    public final ExDBFieldString<WT_KouteiLock, String> lockTime = new ExDBFieldString<>("lockTime", this);

    public final ExDBFieldString<WT_KouteiLock, String> lockKey = new ExDBFieldString<>("lockKey", this);

    public final ExDBFieldString<WT_KouteiLock, String> gyoumuKey = new ExDBFieldString<>("gyoumuKey", this);

    public final ExDBFieldString<WT_KouteiLock, String> flowId = new ExDBFieldString<>("flowId", this);

    public final ExDBFieldString<WT_KouteiLock, String> userId = new ExDBFieldString<>("userId", this);

    public final ExDBFieldString<WT_KouteiLock, String> nodeNm = new ExDBFieldString<>("nodeNm", this);
}
