package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_ZennouKeikaRiritu;
import yuyu.def.db.mapping.GenBM_ZennouKeikaRiritu;
import yuyu.def.db.meta.GenQBM_ZennouKeikaRiritu;
import yuyu.def.db.meta.QBM_ZennouKeikaRiritu;

/**
 * 前納経過利率マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ZennouKeikaRiritu} の JavaDoc を参照してください。
 * @see     GenBM_ZennouKeikaRiritu
 * @see     PKBM_ZennouKeikaRiritu
 * @see     QBM_ZennouKeikaRiritu
 * @see     GenQBM_ZennouKeikaRiritu
 */
@Entity
public class BM_ZennouKeikaRiritu extends GenBM_ZennouKeikaRiritu {

    private static final long serialVersionUID = 1L;

    public BM_ZennouKeikaRiritu() {
    }

    public BM_ZennouKeikaRiritu(
        Integer pKeikatukisuu,
        String pTekiyoukknfrom,
        String pTekiyoukknkto
    ) {
        super(
            pKeikatukisuu,
            pTekiyoukknfrom,
            pTekiyoukknkto
        );
    }

}
