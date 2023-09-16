package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_HnsyScrMeigiTy;
import yuyu.def.db.mapping.GenZT_HnsyScrMeigiTy;
import yuyu.def.db.meta.GenQZT_HnsyScrMeigiTy;
import yuyu.def.db.meta.QZT_HnsyScrMeigiTy;

/**
 * 反社スクリーニング用名義データテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_HnsyScrMeigiTy} の JavaDoc を参照してください。
 * @see     GenZT_HnsyScrMeigiTy
 * @see     PKZT_HnsyScrMeigiTy
 * @see     QZT_HnsyScrMeigiTy
 * @see     GenQZT_HnsyScrMeigiTy
 */
@Entity
public class ZT_HnsyScrMeigiTy extends GenZT_HnsyScrMeigiTy {

    private static final long serialVersionUID = 1L;

    public ZT_HnsyScrMeigiTy() {
    }

    public ZT_HnsyScrMeigiTy(
        String pZtytaisyounmkn,
        String pZtytaisyounmkj,
        String pZtytaisyouseiymd,
        String pZtynayosetaisyousegkbn,
        String pZtysyono
    ) {
        super(
            pZtytaisyounmkn,
            pZtytaisyounmkj,
            pZtytaisyouseiymd,
            pZtynayosetaisyousegkbn,
            pZtysyono
        );
    }

}
