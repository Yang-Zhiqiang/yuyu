package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_SikinIdouGroup;
import yuyu.def.db.mapping.GenBM_SikinIdouGroup;
import yuyu.def.db.meta.GenQBM_SikinIdouGroup;
import yuyu.def.db.meta.QBM_SikinIdouGroup;
import yuyu.def.classification.C_Segcd;

/**
 * 資金移動グループマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_SikinIdouGroup} の JavaDoc を参照してください。
 * @see     GenBM_SikinIdouGroup
 * @see     PKBM_SikinIdouGroup
 * @see     QBM_SikinIdouGroup
 * @see     GenQBM_SikinIdouGroup
 */
@Entity
public class BM_SikinIdouGroup extends GenBM_SikinIdouGroup {

    private static final long serialVersionUID = 1L;

    public BM_SikinIdouGroup() {
    }

    public BM_SikinIdouGroup(C_Segcd pSegcd) {
        super(pSegcd);
    }

}
