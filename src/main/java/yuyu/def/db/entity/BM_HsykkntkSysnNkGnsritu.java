package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_HsykkntkSysnNkGnsritu;
import yuyu.def.db.mapping.GenBM_HsykkntkSysnNkGnsritu;
import yuyu.def.db.meta.GenQBM_HsykkntkSysnNkGnsritu;
import yuyu.def.db.meta.QBM_HsykkntkSysnNkGnsritu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_Seibetu;

/**
 * 保証期間付終身年金原資率マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_HsykkntkSysnNkGnsritu} の JavaDoc を参照してください。
 * @see     GenBM_HsykkntkSysnNkGnsritu
 * @see     PKBM_HsykkntkSysnNkGnsritu
 * @see     QBM_HsykkntkSysnNkGnsritu
 * @see     GenQBM_HsykkntkSysnNkGnsritu
 */
@Entity
public class BM_HsykkntkSysnNkGnsritu extends GenBM_HsykkntkSysnNkGnsritu {

    private static final long serialVersionUID = 1L;

    public BM_HsykkntkSysnNkGnsritu() {
    }

    public BM_HsykkntkSysnNkGnsritu(
        String pRyouritusdno,
        C_Tuukasyu pTuukasyu,
        C_Seibetu pSeibetu,
        Integer pNkshrstartnen
    ) {
        super(
            pRyouritusdno,
            pTuukasyu,
            pSeibetu,
            pNkshrstartnen
        );
    }

}
