package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.JBPM_NODE;

/**
 * ＪＢＰＭノード のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJBPM_NODE extends AbstractExDBTable<JBPM_NODE> {

    public GenQJBPM_NODE() {
        this("JBPM_NODE");
    }

    public GenQJBPM_NODE(String pAlias) {
        super("JBPM_NODE", JBPM_NODE.class, pAlias);
    }

    public String JBPM_NODE() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<JBPM_NODE, Long> id_ = new ExDBFieldNumber<>("id_", this);

    public final ExDBFieldString<JBPM_NODE, String> class_ = new ExDBFieldString<>("class_", this);

    public final ExDBFieldString<JBPM_NODE, String> name_ = new ExDBFieldString<>("name_", this);

    public final ExDBFieldString<JBPM_NODE, String> description_ = new ExDBFieldString<>("description_", this);

    public final ExDBFieldNumber<JBPM_NODE, Long> processDefinition_ = new ExDBFieldNumber<>("processDefinition_", this);

    public final ExDBFieldString<JBPM_NODE, String> isAsync_ = new ExDBFieldString<>("isAsync_", this);

    public final ExDBFieldString<JBPM_NODE, String> isAsyncExcl_ = new ExDBFieldString<>("isAsyncExcl_", this);

    public final ExDBFieldNumber<JBPM_NODE, Long> action_ = new ExDBFieldNumber<>("action_", this);

    public final ExDBFieldNumber<JBPM_NODE, Long> superState_ = new ExDBFieldNumber<>("superState_", this);

    public final ExDBFieldString<JBPM_NODE, String> subProcName_ = new ExDBFieldString<>("subProcName_", this);

    public final ExDBFieldNumber<JBPM_NODE, Long> subProcessDefinition_ = new ExDBFieldNumber<>("subProcessDefinition_", this);

    public final ExDBFieldString<JBPM_NODE, String> decisionExpression_ = new ExDBFieldString<>("decisionExpression_", this);

    public final ExDBFieldNumber<JBPM_NODE, Long> decisionDelegation = new ExDBFieldNumber<>("decisionDelegation", this);

    public final ExDBFieldNumber<JBPM_NODE, Long> script_ = new ExDBFieldNumber<>("script_", this);

    public final ExDBFieldNumber<JBPM_NODE, Long> signal_ = new ExDBFieldNumber<>("signal_", this);

    public final ExDBFieldString<JBPM_NODE, String> createTasks_ = new ExDBFieldString<>("createTasks_", this);

    public final ExDBFieldString<JBPM_NODE, String> endTasks_ = new ExDBFieldString<>("endTasks_", this);

    public final ExDBFieldNumber<JBPM_NODE, Long> nodeCollectionIndex_ = new ExDBFieldNumber<>("nodeCollectionIndex_", this);
}
