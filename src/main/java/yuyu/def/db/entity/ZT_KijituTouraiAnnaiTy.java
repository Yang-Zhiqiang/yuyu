package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KijituTouraiAnnaiTy;
import yuyu.def.db.mapping.GenZT_KijituTouraiAnnaiTy;
import yuyu.def.db.meta.GenQZT_KijituTouraiAnnaiTy;
import yuyu.def.db.meta.QZT_KijituTouraiAnnaiTy;

/**
 * 期日到来案内テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KijituTouraiAnnaiTy} の JavaDoc を参照してください。
 * @see     GenZT_KijituTouraiAnnaiTy
 * @see     PKZT_KijituTouraiAnnaiTy
 * @see     QZT_KijituTouraiAnnaiTy
 * @see     GenQZT_KijituTouraiAnnaiTy
 */
@Entity
public class ZT_KijituTouraiAnnaiTy extends GenZT_KijituTouraiAnnaiTy {

    private static final long serialVersionUID = 1L;

    public ZT_KijituTouraiAnnaiTy() {
    }

    public ZT_KijituTouraiAnnaiTy(String pZtytyouhyouymd, String pZtysyono) {
        super(pZtytyouhyouymd, pZtysyono);
    }

}
