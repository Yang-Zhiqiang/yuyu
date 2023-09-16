package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_KktNkGnsritu;
import yuyu.def.db.mapping.GenBM_KktNkGnsritu;
import yuyu.def.db.meta.GenQBM_KktNkGnsritu;
import yuyu.def.db.meta.QBM_KktNkGnsritu;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 確定年金原資率マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_KktNkGnsritu} の JavaDoc を参照してください。
 * @see     GenBM_KktNkGnsritu
 * @see     PKBM_KktNkGnsritu
 * @see     QBM_KktNkGnsritu
 * @see     GenQBM_KktNkGnsritu
 */
@Entity
public class BM_KktNkGnsritu extends GenBM_KktNkGnsritu {

    private static final long serialVersionUID = 1L;

    public BM_KktNkGnsritu() {
    }

    public BM_KktNkGnsritu(
        String pRyouritusdno,
        C_Tuukasyu pTuukasyu,
        Integer pShrkkn
    ) {
        super(
            pRyouritusdno,
            pTuukasyu,
            pShrkkn
        );
    }

}
