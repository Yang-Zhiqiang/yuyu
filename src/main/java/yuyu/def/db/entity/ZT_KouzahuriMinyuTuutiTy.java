package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KouzahuriMinyuTuutiTy;
import yuyu.def.db.mapping.GenZT_KouzahuriMinyuTuutiTy;
import yuyu.def.db.meta.GenQZT_KouzahuriMinyuTuutiTy;
import yuyu.def.db.meta.QZT_KouzahuriMinyuTuutiTy;

/**
 * 口座振替未入通知テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KouzahuriMinyuTuutiTy} の JavaDoc を参照してください。
 * @see     GenZT_KouzahuriMinyuTuutiTy
 * @see     PKZT_KouzahuriMinyuTuutiTy
 * @see     QZT_KouzahuriMinyuTuutiTy
 * @see     GenQZT_KouzahuriMinyuTuutiTy
 */
@Entity
public class ZT_KouzahuriMinyuTuutiTy extends GenZT_KouzahuriMinyuTuutiTy {

    private static final long serialVersionUID = 1L;

    public ZT_KouzahuriMinyuTuutiTy() {
    }

    public ZT_KouzahuriMinyuTuutiTy(String pZtytyouhyouymd, String pZtysyono) {
        super(pZtytyouhyouymd, pZtysyono);
    }

}
