package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKJBPM_PROCESSINSTANCE;
import yuyu.def.db.mapping.GenJBPM_PROCESSINSTANCE;
import yuyu.def.db.meta.GenQJBPM_PROCESSINSTANCE;
import yuyu.def.db.meta.QJBPM_PROCESSINSTANCE;

/**
 * ＪＢＰＭプロセスインスタンス エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJBPM_PROCESSINSTANCE} の JavaDoc を参照してください。
 * @see     GenJBPM_PROCESSINSTANCE
 * @see     PKJBPM_PROCESSINSTANCE
 * @see     QJBPM_PROCESSINSTANCE
 * @see     GenQJBPM_PROCESSINSTANCE
 */
@Entity
public class JBPM_PROCESSINSTANCE extends GenJBPM_PROCESSINSTANCE {

    private static final long serialVersionUID = 1L;

    public JBPM_PROCESSINSTANCE() {
    }

    public JBPM_PROCESSINSTANCE(Long pId_) {
        super(pId_);
    }

}
