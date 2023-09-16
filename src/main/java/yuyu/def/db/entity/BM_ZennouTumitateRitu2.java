package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_ZennouTumitateRitu2;
import yuyu.def.db.mapping.GenBM_ZennouTumitateRitu2;
import yuyu.def.db.meta.GenQBM_ZennouTumitateRitu2;
import yuyu.def.db.meta.QBM_ZennouTumitateRitu2;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 前納積立率マスタ２ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ZennouTumitateRitu2} の JavaDoc を参照してください。
 * @see     GenBM_ZennouTumitateRitu2
 * @see     PKBM_ZennouTumitateRitu2
 * @see     QBM_ZennouTumitateRitu2
 * @see     GenQBM_ZennouTumitateRitu2
 */
@Entity
public class BM_ZennouTumitateRitu2 extends GenBM_ZennouTumitateRitu2 {

    private static final long serialVersionUID = 1L;

    public BM_ZennouTumitateRitu2() {
    }

    public BM_ZennouTumitateRitu2(
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
