package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KouzahuriStartAnnaiTy;
import yuyu.def.db.mapping.GenZT_KouzahuriStartAnnaiTy;
import yuyu.def.db.meta.GenQZT_KouzahuriStartAnnaiTy;
import yuyu.def.db.meta.QZT_KouzahuriStartAnnaiTy;

/**
 * 口座振替開始案内テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KouzahuriStartAnnaiTy} の JavaDoc を参照してください。
 * @see     GenZT_KouzahuriStartAnnaiTy
 * @see     PKZT_KouzahuriStartAnnaiTy
 * @see     QZT_KouzahuriStartAnnaiTy
 * @see     GenQZT_KouzahuriStartAnnaiTy
 */
@Entity
public class ZT_KouzahuriStartAnnaiTy extends GenZT_KouzahuriStartAnnaiTy {

    private static final long serialVersionUID = 1L;

    public ZT_KouzahuriStartAnnaiTy() {
    }

    public ZT_KouzahuriStartAnnaiTy(String pZtytyouhyouymd, String pZtysyono) {
        super(pZtytyouhyouymd, pZtysyono);
    }

}
