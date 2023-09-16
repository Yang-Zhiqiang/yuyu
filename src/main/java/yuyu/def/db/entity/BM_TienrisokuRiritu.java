package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_TienrisokuRiritu;
import yuyu.def.db.mapping.GenBM_TienrisokuRiritu;
import yuyu.def.db.meta.GenQBM_TienrisokuRiritu;
import yuyu.def.db.meta.QBM_TienrisokuRiritu;

/**
 * 遅延利息利率マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_TienrisokuRiritu} の JavaDoc を参照してください。
 * @see     GenBM_TienrisokuRiritu
 * @see     PKBM_TienrisokuRiritu
 * @see     QBM_TienrisokuRiritu
 * @see     GenQBM_TienrisokuRiritu
 */
@Entity
public class BM_TienrisokuRiritu extends GenBM_TienrisokuRiritu {

    private static final long serialVersionUID = 1L;

    public BM_TienrisokuRiritu() {
    }

    public BM_TienrisokuRiritu(String pTekiyoukknfrom, String pTekiyoukknkto) {
        super(pTekiyoukknfrom, pTekiyoukknkto);
    }

}
