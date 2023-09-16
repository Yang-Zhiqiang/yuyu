package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SyoumetuTuutiTy;
import yuyu.def.db.mapping.GenZT_SyoumetuTuutiTy;
import yuyu.def.db.meta.GenQZT_SyoumetuTuutiTy;
import yuyu.def.db.meta.QZT_SyoumetuTuutiTy;

/**
 * 消滅通知Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SyoumetuTuutiTy} の JavaDoc を参照してください。
 * @see     GenZT_SyoumetuTuutiTy
 * @see     PKZT_SyoumetuTuutiTy
 * @see     QZT_SyoumetuTuutiTy
 * @see     GenQZT_SyoumetuTuutiTy
 */
@Entity
public class ZT_SyoumetuTuutiTy extends GenZT_SyoumetuTuutiTy {

    private static final long serialVersionUID = 1L;

    public ZT_SyoumetuTuutiTy() {
    }

    public ZT_SyoumetuTuutiTy(
        String pZtytyouhyouymd,
        String pZtysyono,
        String pZtysikibetuno
    ) {
        super(
            pZtytyouhyouymd,
            pZtysyono,
            pZtysikibetuno
        );
    }

}
