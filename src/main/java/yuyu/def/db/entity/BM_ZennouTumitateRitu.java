package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_ZennouTumitateRitu;
import yuyu.def.db.mapping.GenBM_ZennouTumitateRitu;
import yuyu.def.db.meta.GenQBM_ZennouTumitateRitu;
import yuyu.def.db.meta.QBM_ZennouTumitateRitu;

/**
 * 前納積立率マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ZennouTumitateRitu} の JavaDoc を参照してください。
 * @see     GenBM_ZennouTumitateRitu
 * @see     PKBM_ZennouTumitateRitu
 * @see     QBM_ZennouTumitateRitu
 * @see     GenQBM_ZennouTumitateRitu
 */
@Entity
public class BM_ZennouTumitateRitu extends GenBM_ZennouTumitateRitu {

    private static final long serialVersionUID = 1L;

    public BM_ZennouTumitateRitu() {
    }

    public BM_ZennouTumitateRitu(String pTekiyoukknfrom, String pTekiyoukknkto) {
        super(pTekiyoukknfrom, pTekiyoukknkto);
    }

}
