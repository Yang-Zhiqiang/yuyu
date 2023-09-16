package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.DM_JimutetuzukiTask;

/**
 * 事務手続タスクマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQDM_JimutetuzukiTask extends AbstractExDBTable<DM_JimutetuzukiTask> {

    public GenQDM_JimutetuzukiTask() {
        this("DM_JimutetuzukiTask");
    }

    public GenQDM_JimutetuzukiTask(String pAlias) {
        super("DM_JimutetuzukiTask", DM_JimutetuzukiTask.class, pAlias);
    }

    public String DM_JimutetuzukiTask() {
        return getAliasExpression();
    }

    public final ExDBFieldString<DM_JimutetuzukiTask, String> subSystemId = new ExDBFieldString<>("subSystemId", this);

    public final ExDBFieldString<DM_JimutetuzukiTask, String> jimutetuzukicd = new ExDBFieldString<>("jimutetuzukicd", this);

    public final ExDBFieldString<DM_JimutetuzukiTask, String> workflowTskId = new ExDBFieldString<>("workflowTskId", this);

    public final ExDBFieldString<DM_JimutetuzukiTask, String> workflowTskNm = new ExDBFieldString<>("workflowTskNm", this);

    public final ExDBFieldNumber<DM_JimutetuzukiTask, Integer> hyoujijyun = new ExDBFieldNumber<>("hyoujijyun", this);

    public final ExDBFieldNumber<DM_JimutetuzukiTask, Integer> worklistHyoujiFlag = new ExDBFieldNumber<>("worklistHyoujiFlag", this);
}
