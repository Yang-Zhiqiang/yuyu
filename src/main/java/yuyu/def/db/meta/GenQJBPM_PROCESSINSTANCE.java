package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.JBPM_PROCESSINSTANCE;

/**
 * ＪＢＰＭプロセスインスタンス のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJBPM_PROCESSINSTANCE extends AbstractExDBTable<JBPM_PROCESSINSTANCE> {

    public GenQJBPM_PROCESSINSTANCE() {
        this("JBPM_PROCESSINSTANCE");
    }

    public GenQJBPM_PROCESSINSTANCE(String pAlias) {
        super("JBPM_PROCESSINSTANCE", JBPM_PROCESSINSTANCE.class, pAlias);
    }

    public String JBPM_PROCESSINSTANCE() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<JBPM_PROCESSINSTANCE, Long> id_ = new ExDBFieldNumber<>("id_", this);

    public final ExDBFieldNumber<JBPM_PROCESSINSTANCE, Long> version_ = new ExDBFieldNumber<>("version_", this);

    public final ExDBFieldString<JBPM_PROCESSINSTANCE, String> key_ = new ExDBFieldString<>("key_", this);

    public final ExDBFieldString<JBPM_PROCESSINSTANCE, String> start_ = new ExDBFieldString<>("start_", this);

    public final ExDBFieldString<JBPM_PROCESSINSTANCE, String> end_ = new ExDBFieldString<>("end_", this);

    public final ExDBFieldString<JBPM_PROCESSINSTANCE, String> isSuspended_ = new ExDBFieldString<>("isSuspended_", this);

    public final ExDBFieldNumber<JBPM_PROCESSINSTANCE, Long> processDefinition_ = new ExDBFieldNumber<>("processDefinition_", this);

    public final ExDBFieldNumber<JBPM_PROCESSINSTANCE, Long> rootToken_ = new ExDBFieldNumber<>("rootToken_", this);

    public final ExDBFieldNumber<JBPM_PROCESSINSTANCE, Long> superProcessToken_ = new ExDBFieldNumber<>("superProcessToken_", this);
}
