package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_RayKimatuVTy;
import yuyu.def.db.mapping.GenZT_RayKimatuVTy;
import yuyu.def.db.meta.GenQZT_RayKimatuVTy;
import yuyu.def.db.meta.QZT_RayKimatuVTy;

/**
 * ＲＡＹ期末ＶＦテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RayKimatuVTy} の JavaDoc を参照してください。
 * @see     GenZT_RayKimatuVTy
 * @see     PKZT_RayKimatuVTy
 * @see     QZT_RayKimatuVTy
 * @see     GenQZT_RayKimatuVTy
 */
@Entity
public class ZT_RayKimatuVTy extends GenZT_RayKimatuVTy {

    private static final long serialVersionUID = 1L;

    public ZT_RayKimatuVTy() {
    }

    public ZT_RayKimatuVTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
