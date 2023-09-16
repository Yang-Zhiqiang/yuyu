package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKJBPM_PROCESSDEFINITION;
import yuyu.def.db.mapping.GenJBPM_PROCESSDEFINITION;
import yuyu.def.db.meta.GenQJBPM_PROCESSDEFINITION;
import yuyu.def.db.meta.QJBPM_PROCESSDEFINITION;

/**
 * ＪＢＰＭプロセス定義 エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJBPM_PROCESSDEFINITION} の JavaDoc を参照してください。
 * @see     GenJBPM_PROCESSDEFINITION
 * @see     PKJBPM_PROCESSDEFINITION
 * @see     QJBPM_PROCESSDEFINITION
 * @see     GenQJBPM_PROCESSDEFINITION
 */
@Entity
public class JBPM_PROCESSDEFINITION extends GenJBPM_PROCESSDEFINITION {

    private static final long serialVersionUID = 1L;

    public JBPM_PROCESSDEFINITION() {
    }

    public JBPM_PROCESSDEFINITION(Long pId_) {
        super(pId_);
    }

}
