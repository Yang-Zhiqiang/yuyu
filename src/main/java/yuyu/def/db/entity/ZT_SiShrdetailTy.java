package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SiShrdetailTy;
import yuyu.def.db.mapping.GenZT_SiShrdetailTy;
import yuyu.def.db.meta.GenQZT_SiShrdetailTy;
import yuyu.def.db.meta.QZT_SiShrdetailTy;

/**
 * 保険金給付金支払明細書テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SiShrdetailTy} の JavaDoc を参照してください。
 * @see     GenZT_SiShrdetailTy
 * @see     PKZT_SiShrdetailTy
 * @see     QZT_SiShrdetailTy
 * @see     GenQZT_SiShrdetailTy
 */
@Entity
public class ZT_SiShrdetailTy extends GenZT_SiShrdetailTy {

    private static final long serialVersionUID = 1L;

    public ZT_SiShrdetailTy() {
    }

    public ZT_SiShrdetailTy(
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
