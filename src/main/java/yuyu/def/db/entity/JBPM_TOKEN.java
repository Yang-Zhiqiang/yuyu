package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKJBPM_TOKEN;
import yuyu.def.db.mapping.GenJBPM_TOKEN;
import yuyu.def.db.meta.GenQJBPM_TOKEN;
import yuyu.def.db.meta.QJBPM_TOKEN;

/**
 * ＪＢＰＭトークン エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJBPM_TOKEN} の JavaDoc を参照してください。
 * @see     GenJBPM_TOKEN
 * @see     PKJBPM_TOKEN
 * @see     QJBPM_TOKEN
 * @see     GenQJBPM_TOKEN
 */
@Entity
public class JBPM_TOKEN extends GenJBPM_TOKEN {

    private static final long serialVersionUID = 1L;

    public JBPM_TOKEN() {
    }

    public JBPM_TOKEN(Long pId_) {
        super(pId_);
    }

}
