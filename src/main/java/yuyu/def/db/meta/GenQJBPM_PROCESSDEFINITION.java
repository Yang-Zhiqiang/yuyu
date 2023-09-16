package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.JBPM_PROCESSDEFINITION;

/**
 * ＪＢＰＭプロセス定義 のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJBPM_PROCESSDEFINITION extends AbstractExDBTable<JBPM_PROCESSDEFINITION> {

    public GenQJBPM_PROCESSDEFINITION() {
        this("JBPM_PROCESSDEFINITION");
    }

    public GenQJBPM_PROCESSDEFINITION(String pAlias) {
        super("JBPM_PROCESSDEFINITION", JBPM_PROCESSDEFINITION.class, pAlias);
    }

    public String JBPM_PROCESSDEFINITION() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<JBPM_PROCESSDEFINITION, Long> id_ = new ExDBFieldNumber<>("id_", this);

    public final ExDBFieldString<JBPM_PROCESSDEFINITION, String> class_ = new ExDBFieldString<>("class_", this);

    public final ExDBFieldString<JBPM_PROCESSDEFINITION, String> name_ = new ExDBFieldString<>("name_", this);

    public final ExDBFieldString<JBPM_PROCESSDEFINITION, String> description_ = new ExDBFieldString<>("description_", this);

    public final ExDBFieldNumber<JBPM_PROCESSDEFINITION, Long> version_ = new ExDBFieldNumber<>("version_", this);

    public final ExDBFieldString<JBPM_PROCESSDEFINITION, String> isTerminationImplicit_ = new ExDBFieldString<>("isTerminationImplicit_", this);

    public final ExDBFieldNumber<JBPM_PROCESSDEFINITION, Long> startState_ = new ExDBFieldNumber<>("startState_", this);
}
