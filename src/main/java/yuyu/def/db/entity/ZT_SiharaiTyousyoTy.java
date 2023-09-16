package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SiharaiTyousyoTy;
import yuyu.def.db.mapping.GenZT_SiharaiTyousyoTy;
import yuyu.def.db.meta.GenQZT_SiharaiTyousyoTy;
import yuyu.def.db.meta.QZT_SiharaiTyousyoTy;

/**
 * 支払調書テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SiharaiTyousyoTy} の JavaDoc を参照してください。
 * @see     GenZT_SiharaiTyousyoTy
 * @see     PKZT_SiharaiTyousyoTy
 * @see     QZT_SiharaiTyousyoTy
 * @see     GenQZT_SiharaiTyousyoTy
 */
@Entity
public class ZT_SiharaiTyousyoTy extends GenZT_SiharaiTyousyoTy {

    private static final long serialVersionUID = 1L;

    public ZT_SiharaiTyousyoTy() {
    }

    public ZT_SiharaiTyousyoTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
