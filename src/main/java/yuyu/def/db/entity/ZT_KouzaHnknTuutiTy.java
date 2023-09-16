package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KouzaHnknTuutiTy;
import yuyu.def.db.mapping.GenZT_KouzaHnknTuutiTy;
import yuyu.def.db.meta.GenQZT_KouzaHnknTuutiTy;
import yuyu.def.db.meta.QZT_KouzaHnknTuutiTy;

/**
 * 口座返金通知テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KouzaHnknTuutiTy} の JavaDoc を参照してください。
 * @see     GenZT_KouzaHnknTuutiTy
 * @see     PKZT_KouzaHnknTuutiTy
 * @see     QZT_KouzaHnknTuutiTy
 * @see     GenQZT_KouzaHnknTuutiTy
 */
@Entity
public class ZT_KouzaHnknTuutiTy extends GenZT_KouzaHnknTuutiTy {

    private static final long serialVersionUID = 1L;

    public ZT_KouzaHnknTuutiTy() {
    }

    public ZT_KouzaHnknTuutiTy(
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
