package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_ZennouKeikaRiritu2;
import yuyu.def.db.mapping.GenBM_ZennouKeikaRiritu2;
import yuyu.def.db.meta.GenQBM_ZennouKeikaRiritu2;
import yuyu.def.db.meta.QBM_ZennouKeikaRiritu2;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 前納経過利率マスタ２ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ZennouKeikaRiritu2} の JavaDoc を参照してください。
 * @see     GenBM_ZennouKeikaRiritu2
 * @see     PKBM_ZennouKeikaRiritu2
 * @see     QBM_ZennouKeikaRiritu2
 * @see     GenQBM_ZennouKeikaRiritu2
 */
@Entity
public class BM_ZennouKeikaRiritu2 extends GenBM_ZennouKeikaRiritu2 {

    private static final long serialVersionUID = 1L;

    public BM_ZennouKeikaRiritu2() {
    }

    public BM_ZennouKeikaRiritu2(
        C_Tuukasyu pTuukasyu,
        String pZennoutkybr1,
        String pZennoutkybr2,
        String pZennoutkybr3,
        Integer pKeikatukisuu,
        String pTekiyoukknfrom,
        String pTekiyoukknkto
    ) {
        super(
            pTuukasyu,
            pZennoutkybr1,
            pZennoutkybr2,
            pZennoutkybr3,
            pKeikatukisuu,
            pTekiyoukknfrom,
            pTekiyoukknkto
        );
    }

}
