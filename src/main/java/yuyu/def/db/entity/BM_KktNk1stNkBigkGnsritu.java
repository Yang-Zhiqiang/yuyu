package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_KktNk1stNkBigkGnsritu;
import yuyu.def.db.mapping.GenBM_KktNk1stNkBigkGnsritu;
import yuyu.def.db.meta.GenQBM_KktNk1stNkBigkGnsritu;
import yuyu.def.db.meta.QBM_KktNk1stNkBigkGnsritu;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 確定年金（第１回年金倍額型）原資率マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_KktNk1stNkBigkGnsritu} の JavaDoc を参照してください。
 * @see     GenBM_KktNk1stNkBigkGnsritu
 * @see     PKBM_KktNk1stNkBigkGnsritu
 * @see     QBM_KktNk1stNkBigkGnsritu
 * @see     GenQBM_KktNk1stNkBigkGnsritu
 */
@Entity
public class BM_KktNk1stNkBigkGnsritu extends GenBM_KktNk1stNkBigkGnsritu {

    private static final long serialVersionUID = 1L;

    public BM_KktNk1stNkBigkGnsritu() {
    }

    public BM_KktNk1stNkBigkGnsritu(
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
