package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KsnRayJigyohiTy;
import yuyu.def.db.mapping.GenZT_KsnRayJigyohiTy;
import yuyu.def.db.meta.GenQZT_KsnRayJigyohiTy;
import yuyu.def.db.meta.QZT_KsnRayJigyohiTy;

/**
 * 決算計上用ＲＡＹ事業費Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KsnRayJigyohiTy} の JavaDoc を参照してください。
 * @see     GenZT_KsnRayJigyohiTy
 * @see     PKZT_KsnRayJigyohiTy
 * @see     QZT_KsnRayJigyohiTy
 * @see     GenQZT_KsnRayJigyohiTy
 */
@Entity
public class ZT_KsnRayJigyohiTy extends GenZT_KsnRayJigyohiTy {

    private static final long serialVersionUID = 1L;

    public ZT_KsnRayJigyohiTy() {
    }

    public ZT_KsnRayJigyohiTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
