package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.JBPM_TASK;

/**
 * ＪＢＰＭタスク のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJBPM_TASK extends AbstractExDBTable<JBPM_TASK> {

    public GenQJBPM_TASK() {
        this("JBPM_TASK");
    }

    public GenQJBPM_TASK(String pAlias) {
        super("JBPM_TASK", JBPM_TASK.class, pAlias);
    }

    public String JBPM_TASK() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<JBPM_TASK, Long> id_ = new ExDBFieldNumber<>("id_", this);

    public final ExDBFieldString<JBPM_TASK, String> name_ = new ExDBFieldString<>("name_", this);

    public final ExDBFieldString<JBPM_TASK, String> description_ = new ExDBFieldString<>("description_", this);

    public final ExDBFieldNumber<JBPM_TASK, Long> processDefinition_ = new ExDBFieldNumber<>("processDefinition_", this);

    public final ExDBFieldString<JBPM_TASK, String> isBlocking_ = new ExDBFieldString<>("isBlocking_", this);

    public final ExDBFieldString<JBPM_TASK, String> isSignalling_ = new ExDBFieldString<>("isSignalling_", this);

    public final ExDBFieldString<JBPM_TASK, String> condition_ = new ExDBFieldString<>("condition_", this);

    public final ExDBFieldString<JBPM_TASK, String> dueDate_ = new ExDBFieldString<>("dueDate_", this);

    public final ExDBFieldNumber<JBPM_TASK, Long> priority_ = new ExDBFieldNumber<>("priority_", this);

    public final ExDBFieldString<JBPM_TASK, String> actorIdExpression_ = new ExDBFieldString<>("actorIdExpression_", this);

    public final ExDBFieldString<JBPM_TASK, String> pooledActorsExpression_ = new ExDBFieldString<>("pooledActorsExpression_", this);

    public final ExDBFieldNumber<JBPM_TASK, Long> taskMgmtDefinition_ = new ExDBFieldNumber<>("taskMgmtDefinition_", this);

    public final ExDBFieldNumber<JBPM_TASK, Long> taskNode_ = new ExDBFieldNumber<>("taskNode_", this);

    public final ExDBFieldNumber<JBPM_TASK, Long> startState_ = new ExDBFieldNumber<>("startState_", this);

    public final ExDBFieldNumber<JBPM_TASK, Long> assignmentDelegation_ = new ExDBFieldNumber<>("assignmentDelegation_", this);

    public final ExDBFieldNumber<JBPM_TASK, Long> swimlane_ = new ExDBFieldNumber<>("swimlane_", this);

    public final ExDBFieldNumber<JBPM_TASK, Long> taskController_ = new ExDBFieldNumber<>("taskController_", this);
}
