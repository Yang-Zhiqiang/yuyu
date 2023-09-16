package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DrtenKykIdouDetailTy;
import yuyu.def.db.mapping.GenZT_DrtenKykIdouDetailTy;
import yuyu.def.db.meta.GenQZT_DrtenKykIdouDetailTy;
import yuyu.def.db.meta.QZT_DrtenKykIdouDetailTy;

/**
 * 代理店契約異動明細テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DrtenKykIdouDetailTy} の JavaDoc を参照してください。
 * @see     GenZT_DrtenKykIdouDetailTy
 * @see     PKZT_DrtenKykIdouDetailTy
 * @see     QZT_DrtenKykIdouDetailTy
 * @see     GenQZT_DrtenKykIdouDetailTy
 */
@Entity
public class ZT_DrtenKykIdouDetailTy extends GenZT_DrtenKykIdouDetailTy {

    private static final long serialVersionUID = 1L;

    public ZT_DrtenKykIdouDetailTy() {
    }

    public ZT_DrtenKykIdouDetailTy(
        String pZtybsydrtencd,
        String pZtybosyuunincd,
        String pZtysyono,
        String pZtyidouhasseiymd,
        String pZtyidoukbn
    ) {
        super(
            pZtybsydrtencd,
            pZtybosyuunincd,
            pZtysyono,
            pZtyidouhasseiymd,
            pZtyidoukbn
        );
    }

}
