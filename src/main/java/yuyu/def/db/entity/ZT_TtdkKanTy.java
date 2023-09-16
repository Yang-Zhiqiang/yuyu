package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_TtdkKanTy;
import yuyu.def.db.mapping.GenZT_TtdkKanTy;
import yuyu.def.db.meta.GenQZT_TtdkKanTy;
import yuyu.def.db.meta.QZT_TtdkKanTy;

/**
 * 手続完了Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TtdkKanTy} の JavaDoc を参照してください。
 * @see     GenZT_TtdkKanTy
 * @see     PKZT_TtdkKanTy
 * @see     QZT_TtdkKanTy
 * @see     GenQZT_TtdkKanTy
 */
@Entity
public class ZT_TtdkKanTy extends GenZT_TtdkKanTy {

    private static final long serialVersionUID = 1L;

    public ZT_TtdkKanTy() {
    }

    public ZT_TtdkKanTy(
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
