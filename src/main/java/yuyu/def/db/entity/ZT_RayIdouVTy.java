package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_RayIdouVTy;
import yuyu.def.db.mapping.GenZT_RayIdouVTy;
import yuyu.def.db.meta.GenQZT_RayIdouVTy;
import yuyu.def.db.meta.QZT_RayIdouVTy;

/**
 * ＲＡＹ異動ＶＦテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RayIdouVTy} の JavaDoc を参照してください。
 * @see     GenZT_RayIdouVTy
 * @see     PKZT_RayIdouVTy
 * @see     QZT_RayIdouVTy
 * @see     GenQZT_RayIdouVTy
 */
@Entity
public class ZT_RayIdouVTy extends GenZT_RayIdouVTy {

    private static final long serialVersionUID = 1L;

    public ZT_RayIdouVTy() {
    }

    public ZT_RayIdouVTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
