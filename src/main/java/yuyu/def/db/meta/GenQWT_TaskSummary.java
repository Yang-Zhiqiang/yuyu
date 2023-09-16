package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.WT_TaskSummary;

/**
 * タスクサマリテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQWT_TaskSummary extends AbstractExDBTable<WT_TaskSummary> {

    public GenQWT_TaskSummary() {
        this("WT_TaskSummary");
    }

    public GenQWT_TaskSummary(String pAlias) {
        super("WT_TaskSummary", WT_TaskSummary.class, pAlias);
    }

    public String WT_TaskSummary() {
        return getAliasExpression();
    }

    public final ExDBFieldString<WT_TaskSummary, String> flowId = new ExDBFieldString<>("flowId", this);

    public final ExDBFieldString<WT_TaskSummary, String> iwfTskId = new ExDBFieldString<>("iwfTskId", this);

    public final ExDBFieldString<WT_TaskSummary, String> tokenId = new ExDBFieldString<>("tokenId", this);

    public final ExDBFieldString<WT_TaskSummary, String> flowName = new ExDBFieldString<>("flowName", this);

    public final ExDBFieldString<WT_TaskSummary, String> iwfTskNm = new ExDBFieldString<>("iwfTskNm", this);

    public final ExDBFieldString<WT_TaskSummary, String> taskCreateTime = new ExDBFieldString<>("taskCreateTime", this);

    public final ExDBFieldString<WT_TaskSummary, String> taskStartTime = new ExDBFieldString<>("taskStartTime", this);

    public final ExDBFieldString<WT_TaskSummary, String> taskEndTime = new ExDBFieldString<>("taskEndTime", this);

    public final ExDBFieldString<WT_TaskSummary, String> actorId = new ExDBFieldString<>("actorId", this);
}
