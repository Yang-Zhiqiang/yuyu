package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_RayJigyohiTy;
import yuyu.def.db.mapping.GenZT_RayJigyohiTy;
import yuyu.def.db.meta.GenQZT_RayJigyohiTy;
import yuyu.def.db.meta.QZT_RayJigyohiTy;

/**
 * ＲＡＹ事業費Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RayJigyohiTy} の JavaDoc を参照してください。
 * @see     GenZT_RayJigyohiTy
 * @see     PKZT_RayJigyohiTy
 * @see     QZT_RayJigyohiTy
 * @see     GenQZT_RayJigyohiTy
 */
@Entity
public class ZT_RayJigyohiTy extends GenZT_RayJigyohiTy {

    private static final long serialVersionUID = 1L;

    public ZT_RayJigyohiTy() {
    }

    public ZT_RayJigyohiTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
