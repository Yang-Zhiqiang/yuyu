package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_TtdkKanAdHenkouTy;
import yuyu.def.db.mapping.GenZT_TtdkKanAdHenkouTy;
import yuyu.def.db.meta.GenQZT_TtdkKanAdHenkouTy;
import yuyu.def.db.meta.QZT_TtdkKanAdHenkouTy;

/**
 * 手続完了（住所変更）Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TtdkKanAdHenkouTy} の JavaDoc を参照してください。
 * @see     GenZT_TtdkKanAdHenkouTy
 * @see     PKZT_TtdkKanAdHenkouTy
 * @see     QZT_TtdkKanAdHenkouTy
 * @see     GenQZT_TtdkKanAdHenkouTy
 */
@Entity
public class ZT_TtdkKanAdHenkouTy extends GenZT_TtdkKanAdHenkouTy {

    private static final long serialVersionUID = 1L;

    public ZT_TtdkKanAdHenkouTy() {
    }

    public ZT_TtdkKanAdHenkouTy(
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
