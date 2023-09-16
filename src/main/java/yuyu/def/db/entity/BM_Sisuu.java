package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_Sisuu;
import yuyu.def.db.mapping.GenBM_Sisuu;
import yuyu.def.db.meta.GenQBM_Sisuu;
import yuyu.def.db.meta.QBM_Sisuu;
import yuyu.def.classification.C_Sisuukbn;
import jp.co.slcs.swak.date.BizDate;

/**
 * 指数マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_Sisuu} の JavaDoc を参照してください。
 * @see     GenBM_Sisuu
 * @see     PKBM_Sisuu
 * @see     QBM_Sisuu
 * @see     GenQBM_Sisuu
 */
@Entity
public class BM_Sisuu extends GenBM_Sisuu {

    private static final long serialVersionUID = 1L;

    public BM_Sisuu() {
    }

    public BM_Sisuu(C_Sisuukbn pSisuukbn, BizDate pSisuukouhyouymd) {
        super(pSisuukbn, pSisuukouhyouymd);
    }

}
