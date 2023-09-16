package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_TtdkKanKiykTy;
import yuyu.def.db.mapping.GenZT_TtdkKanKiykTy;
import yuyu.def.db.meta.GenQZT_TtdkKanKiykTy;
import yuyu.def.db.meta.QZT_TtdkKanKiykTy;

/**
 * 手続完了（解約）Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TtdkKanKiykTy} の JavaDoc を参照してください。
 * @see     GenZT_TtdkKanKiykTy
 * @see     PKZT_TtdkKanKiykTy
 * @see     QZT_TtdkKanKiykTy
 * @see     GenQZT_TtdkKanKiykTy
 */
@Entity
public class ZT_TtdkKanKiykTy extends GenZT_TtdkKanKiykTy {

    private static final long serialVersionUID = 1L;

    public ZT_TtdkKanKiykTy() {
    }

    public ZT_TtdkKanKiykTy(
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
