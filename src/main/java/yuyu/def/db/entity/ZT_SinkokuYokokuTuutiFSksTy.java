package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SinkokuYokokuTuutiFSksTy;
import yuyu.def.db.mapping.GenZT_SinkokuYokokuTuutiFSksTy;
import yuyu.def.db.meta.GenQZT_SinkokuYokokuTuutiFSksTy;
import yuyu.def.db.meta.QZT_SinkokuYokokuTuutiFSksTy;

/**
 * 申告予告通知Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SinkokuYokokuTuutiFSksTy} の JavaDoc を参照してください。
 * @see     GenZT_SinkokuYokokuTuutiFSksTy
 * @see     PKZT_SinkokuYokokuTuutiFSksTy
 * @see     QZT_SinkokuYokokuTuutiFSksTy
 * @see     GenQZT_SinkokuYokokuTuutiFSksTy
 */
@Entity
public class ZT_SinkokuYokokuTuutiFSksTy extends GenZT_SinkokuYokokuTuutiFSksTy {

    private static final long serialVersionUID = 1L;

    public ZT_SinkokuYokokuTuutiFSksTy() {
    }

    public ZT_SinkokuYokokuTuutiFSksTy(
        String pZtytyouhyouymd,
        String pZtysyono,
        String pZtysinkokunenkj
    ) {
        super(
            pZtytyouhyouymd,
            pZtysyono,
            pZtysinkokunenkj
        );
    }

}
