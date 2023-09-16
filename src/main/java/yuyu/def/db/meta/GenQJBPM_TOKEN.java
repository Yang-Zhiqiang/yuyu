package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.JBPM_TOKEN;

/**
 * ＪＢＰＭトークン のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJBPM_TOKEN extends AbstractExDBTable<JBPM_TOKEN> {

    public GenQJBPM_TOKEN() {
        this("JBPM_TOKEN");
    }

    public GenQJBPM_TOKEN(String pAlias) {
        super("JBPM_TOKEN", JBPM_TOKEN.class, pAlias);
    }

    public String JBPM_TOKEN() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<JBPM_TOKEN, Long> id_ = new ExDBFieldNumber<>("id_", this);

    public final ExDBFieldNumber<JBPM_TOKEN, Long> version_ = new ExDBFieldNumber<>("version_", this);

    public final ExDBFieldString<JBPM_TOKEN, String> name_ = new ExDBFieldString<>("name_", this);

    public final ExDBFieldString<JBPM_TOKEN, String> start_ = new ExDBFieldString<>("start_", this);

    public final ExDBFieldString<JBPM_TOKEN, String> end_ = new ExDBFieldString<>("end_", this);

    public final ExDBFieldString<JBPM_TOKEN, String> nodeEnter_ = new ExDBFieldString<>("nodeEnter_", this);

    public final ExDBFieldNumber<JBPM_TOKEN, Long> nextLogIndex_ = new ExDBFieldNumber<>("nextLogIndex_", this);

    public final ExDBFieldString<JBPM_TOKEN, String> isAbleToReactivateParent_ = new ExDBFieldString<>("isAbleToReactivateParent_", this);

    public final ExDBFieldString<JBPM_TOKEN, String> isTerminationImplicit_ = new ExDBFieldString<>("isTerminationImplicit_", this);

    public final ExDBFieldNumber<JBPM_TOKEN, Long> node_ = new ExDBFieldNumber<>("node_", this);

    public final ExDBFieldString<JBPM_TOKEN, String> isSuspended_ = new ExDBFieldString<>("isSuspended_", this);

    public final ExDBFieldString<JBPM_TOKEN, String> lock_ = new ExDBFieldString<>("lock_", this);

    public final ExDBFieldNumber<JBPM_TOKEN, Long> processInstance_ = new ExDBFieldNumber<>("processInstance_", this);

    public final ExDBFieldNumber<JBPM_TOKEN, Long> parent_ = new ExDBFieldNumber<>("parent_", this);

    public final ExDBFieldNumber<JBPM_TOKEN, Long> subProcessInstance_ = new ExDBFieldNumber<>("subProcessInstance_", this);
}
