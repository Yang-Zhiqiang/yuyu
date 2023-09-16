package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_ZennouRiritu;
import yuyu.def.db.mapping.GenBM_ZennouRiritu;
import yuyu.def.db.meta.GenQBM_ZennouRiritu;
import yuyu.def.db.meta.QBM_ZennouRiritu;

/**
 * 前納利率マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ZennouRiritu} の JavaDoc を参照してください。
 * @see     GenBM_ZennouRiritu
 * @see     PKBM_ZennouRiritu
 * @see     QBM_ZennouRiritu
 * @see     GenQBM_ZennouRiritu
 */
@Entity
public class BM_ZennouRiritu extends GenBM_ZennouRiritu {

    private static final long serialVersionUID = 1L;

    public BM_ZennouRiritu() {
    }

    public BM_ZennouRiritu(String pTekiyoukknfrom, String pTekiyoukknkto) {
        super(pTekiyoukknfrom, pTekiyoukknkto);
    }

}
