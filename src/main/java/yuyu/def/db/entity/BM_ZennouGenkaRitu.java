package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_ZennouGenkaRitu;
import yuyu.def.db.mapping.GenBM_ZennouGenkaRitu;
import yuyu.def.db.meta.GenQBM_ZennouGenkaRitu;
import yuyu.def.db.meta.QBM_ZennouGenkaRitu;

/**
 * 前納現価率マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ZennouGenkaRitu} の JavaDoc を参照してください。
 * @see     GenBM_ZennouGenkaRitu
 * @see     PKBM_ZennouGenkaRitu
 * @see     QBM_ZennouGenkaRitu
 * @see     GenQBM_ZennouGenkaRitu
 */
@Entity
public class BM_ZennouGenkaRitu extends GenBM_ZennouGenkaRitu {

    private static final long serialVersionUID = 1L;

    public BM_ZennouGenkaRitu() {
    }

    public BM_ZennouGenkaRitu(
        Integer pZennounensuu,
        String pTekiyoukknfrom,
        String pTekiyoukknkto
    ) {
        super(
            pZennounensuu,
            pTekiyoukknfrom,
            pTekiyoukknkto
        );
    }

}
