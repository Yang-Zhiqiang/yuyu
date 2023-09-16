package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.JBPM_TASKINSTANCE;

/**
 * ＪＢＰＭタスクインスタンス のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJBPM_TASKINSTANCE extends AbstractExDBTable<JBPM_TASKINSTANCE> {

    public GenQJBPM_TASKINSTANCE() {
        this("JBPM_TASKINSTANCE");
    }

    public GenQJBPM_TASKINSTANCE(String pAlias) {
        super("JBPM_TASKINSTANCE", JBPM_TASKINSTANCE.class, pAlias);
    }

    public String JBPM_TASKINSTANCE() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<JBPM_TASKINSTANCE, Long> id_ = new ExDBFieldNumber<>("id_", this);

    public final ExDBFieldString<JBPM_TASKINSTANCE, String> class_ = new ExDBFieldString<>("class_", this);

    public final ExDBFieldNumber<JBPM_TASKINSTANCE, Long> version_ = new ExDBFieldNumber<>("version_", this);

    public final ExDBFieldString<JBPM_TASKINSTANCE, String> name_ = new ExDBFieldString<>("name_", this);

    public final ExDBFieldString<JBPM_TASKINSTANCE, String> description_ = new ExDBFieldString<>("description_", this);

    public final ExDBFieldString<JBPM_TASKINSTANCE, String> actorId_ = new ExDBFieldString<>("actorId_", this);

    public final ExDBFieldString<JBPM_TASKINSTANCE, String> create_ = new ExDBFieldString<>("create_", this);

    public final ExDBFieldString<JBPM_TASKINSTANCE, String> start_ = new ExDBFieldString<>("start_", this);

    public final ExDBFieldString<JBPM_TASKINSTANCE, String> end_ = new ExDBFieldString<>("end_", this);

    public final ExDBFieldString<JBPM_TASKINSTANCE, String> dueDate_ = new ExDBFieldString<>("dueDate_", this);

    public final ExDBFieldNumber<JBPM_TASKINSTANCE, Long> priority_ = new ExDBFieldNumber<>("priority_", this);

    public final ExDBFieldString<JBPM_TASKINSTANCE, String> isCancelled_ = new ExDBFieldString<>("isCancelled_", this);

    public final ExDBFieldString<JBPM_TASKINSTANCE, String> isSuspended_ = new ExDBFieldString<>("isSuspended_", this);

    public final ExDBFieldString<JBPM_TASKINSTANCE, String> isOpen_ = new ExDBFieldString<>("isOpen_", this);

    public final ExDBFieldString<JBPM_TASKINSTANCE, String> isSignalling_ = new ExDBFieldString<>("isSignalling_", this);

    public final ExDBFieldString<JBPM_TASKINSTANCE, String> isBlocking_ = new ExDBFieldString<>("isBlocking_", this);

    public final ExDBFieldNumber<JBPM_TASKINSTANCE, Long> task_ = new ExDBFieldNumber<>("task_", this);

    public final ExDBFieldNumber<JBPM_TASKINSTANCE, Long> token_ = new ExDBFieldNumber<>("token_", this);

    public final ExDBFieldNumber<JBPM_TASKINSTANCE, Long> procInst_ = new ExDBFieldNumber<>("procInst_", this);

    public final ExDBFieldNumber<JBPM_TASKINSTANCE, Long> swimlanInstance_ = new ExDBFieldNumber<>("swimlanInstance_", this);

    public final ExDBFieldNumber<JBPM_TASKINSTANCE, Long> taskMgmtInstance_ = new ExDBFieldNumber<>("taskMgmtInstance_", this);
}
