package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKJBPM_TASKINSTANCE;
import yuyu.def.db.mapping.GenJBPM_TASKINSTANCE;
import yuyu.def.db.meta.GenQJBPM_TASKINSTANCE;
import yuyu.def.db.meta.QJBPM_TASKINSTANCE;

/**
 * ＪＢＰＭタスクインスタンス エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJBPM_TASKINSTANCE} の JavaDoc を参照してください。
 * @see     GenJBPM_TASKINSTANCE
 * @see     PKJBPM_TASKINSTANCE
 * @see     QJBPM_TASKINSTANCE
 * @see     GenQJBPM_TASKINSTANCE
 */
@Entity
public class JBPM_TASKINSTANCE extends GenJBPM_TASKINSTANCE {

    private static final long serialVersionUID = 1L;

    public JBPM_TASKINSTANCE() {
    }

    public JBPM_TASKINSTANCE(Long pId_) {
        super(pId_);
    }

}
