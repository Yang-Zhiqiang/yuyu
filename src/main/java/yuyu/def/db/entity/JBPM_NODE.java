package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKJBPM_NODE;
import yuyu.def.db.mapping.GenJBPM_NODE;
import yuyu.def.db.meta.GenQJBPM_NODE;
import yuyu.def.db.meta.QJBPM_NODE;

/**
 * ＪＢＰＭノード エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJBPM_NODE} の JavaDoc を参照してください。
 * @see     GenJBPM_NODE
 * @see     PKJBPM_NODE
 * @see     QJBPM_NODE
 * @see     GenQJBPM_NODE
 */
@Entity
public class JBPM_NODE extends GenJBPM_NODE {

    private static final long serialVersionUID = 1L;

    public JBPM_NODE() {
    }

    public JBPM_NODE(Long pId_) {
        super(pId_);
    }

}
