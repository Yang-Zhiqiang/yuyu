package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_ZennouGenkaRitu2;
import yuyu.def.db.mapping.GenBM_ZennouGenkaRitu2;
import yuyu.def.db.meta.GenQBM_ZennouGenkaRitu2;
import yuyu.def.db.meta.QBM_ZennouGenkaRitu2;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 前納現価率マスタ２ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ZennouGenkaRitu2} の JavaDoc を参照してください。
 * @see     GenBM_ZennouGenkaRitu2
 * @see     PKBM_ZennouGenkaRitu2
 * @see     QBM_ZennouGenkaRitu2
 * @see     GenQBM_ZennouGenkaRitu2
 */
@Entity
public class BM_ZennouGenkaRitu2 extends GenBM_ZennouGenkaRitu2 {

    private static final long serialVersionUID = 1L;

    public BM_ZennouGenkaRitu2() {
    }

    public BM_ZennouGenkaRitu2(
        C_Tuukasyu pTuukasyu,
        String pZennoutkybr1,
        String pZennoutkybr2,
        String pZennoutkybr3,
        Integer pZennounensuu,
        String pTekiyoukknfrom,
        String pTekiyoukknkto
    ) {
        super(
            pTuukasyu,
            pZennoutkybr1,
            pZennoutkybr2,
            pZennoutkybr3,
            pZennounensuu,
            pTekiyoukknfrom,
            pTekiyoukknkto
        );
    }

}
