package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_ZennouRiritu2;
import yuyu.def.db.mapping.GenBM_ZennouRiritu2;
import yuyu.def.db.meta.GenQBM_ZennouRiritu2;
import yuyu.def.db.meta.QBM_ZennouRiritu2;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 前納利率マスタ２ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ZennouRiritu2} の JavaDoc を参照してください。
 * @see     GenBM_ZennouRiritu2
 * @see     PKBM_ZennouRiritu2
 * @see     QBM_ZennouRiritu2
 * @see     GenQBM_ZennouRiritu2
 */
@Entity
public class BM_ZennouRiritu2 extends GenBM_ZennouRiritu2 {

    private static final long serialVersionUID = 1L;

    public BM_ZennouRiritu2() {
    }

    public BM_ZennouRiritu2(
        C_Tuukasyu pTuukasyu,
        String pZennoutkybr1,
        String pZennoutkybr2,
        String pZennoutkybr3,
        String pTekiyoukknfrom,
        String pTekiyoukknkto
    ) {
        super(
            pTuukasyu,
            pZennoutkybr1,
            pZennoutkybr2,
            pZennoutkybr3,
            pTekiyoukknfrom,
            pTekiyoukknkto
        );
    }

}
