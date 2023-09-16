package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KouzaHrkmTuutiTy;
import yuyu.def.db.mapping.GenZT_KouzaHrkmTuutiTy;
import yuyu.def.db.meta.GenQZT_KouzaHrkmTuutiTy;
import yuyu.def.db.meta.QZT_KouzaHrkmTuutiTy;

/**
 * 口座振込通知テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KouzaHrkmTuutiTy} の JavaDoc を参照してください。
 * @see     GenZT_KouzaHrkmTuutiTy
 * @see     PKZT_KouzaHrkmTuutiTy
 * @see     QZT_KouzaHrkmTuutiTy
 * @see     GenQZT_KouzaHrkmTuutiTy
 */
@Entity
public class ZT_KouzaHrkmTuutiTy extends GenZT_KouzaHrkmTuutiTy {

    private static final long serialVersionUID = 1L;

    public ZT_KouzaHrkmTuutiTy() {
    }

    public ZT_KouzaHrkmTuutiTy(
        String pZtysyono,
        String pZtytyouhyouymd,
        String pZtysikibetuno
    ) {
        super(
            pZtysyono,
            pZtytyouhyouymd,
            pZtysikibetuno
        );
    }

}
