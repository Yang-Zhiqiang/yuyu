package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_YuukouseiNgTuutiTy;
import yuyu.def.db.mapping.GenZT_YuukouseiNgTuutiTy;
import yuyu.def.db.meta.GenQZT_YuukouseiNgTuutiTy;
import yuyu.def.db.meta.QZT_YuukouseiNgTuutiTy;

/**
 * 有効性確認ＮＧ通知テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_YuukouseiNgTuutiTy} の JavaDoc を参照してください。
 * @see     GenZT_YuukouseiNgTuutiTy
 * @see     PKZT_YuukouseiNgTuutiTy
 * @see     QZT_YuukouseiNgTuutiTy
 * @see     GenQZT_YuukouseiNgTuutiTy
 */
@Entity
public class ZT_YuukouseiNgTuutiTy extends GenZT_YuukouseiNgTuutiTy {

    private static final long serialVersionUID = 1L;

    public ZT_YuukouseiNgTuutiTy() {
    }

    public ZT_YuukouseiNgTuutiTy(String pZtytyouhyouymd, String pZtysyono) {
        super(pZtytyouhyouymd, pZtysyono);
    }

}
