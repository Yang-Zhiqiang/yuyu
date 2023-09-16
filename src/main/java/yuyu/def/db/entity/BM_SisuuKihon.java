package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_SisuuKihon;
import yuyu.def.db.mapping.GenBM_SisuuKihon;
import yuyu.def.db.meta.GenQBM_SisuuKihon;
import yuyu.def.db.meta.QBM_SisuuKihon;
import yuyu.def.classification.C_Sisuukbn;

/**
 * 指数基本マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_SisuuKihon} の JavaDoc を参照してください。
 * @see     GenBM_SisuuKihon
 * @see     PKBM_SisuuKihon
 * @see     QBM_SisuuKihon
 * @see     GenQBM_SisuuKihon
 */
@Entity
public class BM_SisuuKihon extends GenBM_SisuuKihon {

    private static final long serialVersionUID = 1L;

    public BM_SisuuKihon() {
    }

    public BM_SisuuKihon(C_Sisuukbn pSisuukbn) {
        super(pSisuukbn);
    }

}
