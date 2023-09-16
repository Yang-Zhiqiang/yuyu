package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_HrhnTtdkKanTy;
import yuyu.def.db.mapping.GenZT_HrhnTtdkKanTy;
import yuyu.def.db.meta.GenQZT_HrhnTtdkKanTy;
import yuyu.def.db.meta.QZT_HrhnTtdkKanTy;

/**
 * 手続完了（払方変更）テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_HrhnTtdkKanTy} の JavaDoc を参照してください。
 * @see     GenZT_HrhnTtdkKanTy
 * @see     PKZT_HrhnTtdkKanTy
 * @see     QZT_HrhnTtdkKanTy
 * @see     GenQZT_HrhnTtdkKanTy
 */
@Entity
public class ZT_HrhnTtdkKanTy extends GenZT_HrhnTtdkKanTy {

    private static final long serialVersionUID = 1L;

    public ZT_HrhnTtdkKanTy() {
    }

    public ZT_HrhnTtdkKanTy(
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
