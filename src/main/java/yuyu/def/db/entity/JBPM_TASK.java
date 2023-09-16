package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKJBPM_TASK;
import yuyu.def.db.mapping.GenJBPM_TASK;
import yuyu.def.db.meta.GenQJBPM_TASK;
import yuyu.def.db.meta.QJBPM_TASK;

/**
 * ＪＢＰＭタスク エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJBPM_TASK} の JavaDoc を参照してください。
 * @see     GenJBPM_TASK
 * @see     PKJBPM_TASK
 * @see     QJBPM_TASK
 * @see     GenQJBPM_TASK
 */
@Entity
public class JBPM_TASK extends GenJBPM_TASK {

    private static final long serialVersionUID = 1L;

    public JBPM_TASK() {
    }

    public JBPM_TASK(Long pId_) {
        super(pId_);
    }

}
