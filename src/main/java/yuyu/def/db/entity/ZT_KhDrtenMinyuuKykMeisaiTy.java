package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KhDrtenMinyuuKykMeisaiTy;
import yuyu.def.db.mapping.GenZT_KhDrtenMinyuuKykMeisaiTy;
import yuyu.def.db.meta.GenQZT_KhDrtenMinyuuKykMeisaiTy;
import yuyu.def.db.meta.QZT_KhDrtenMinyuuKykMeisaiTy;

/**
 * 代理店未入契約明細テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KhDrtenMinyuuKykMeisaiTy} の JavaDoc を参照してください。
 * @see     GenZT_KhDrtenMinyuuKykMeisaiTy
 * @see     PKZT_KhDrtenMinyuuKykMeisaiTy
 * @see     QZT_KhDrtenMinyuuKykMeisaiTy
 * @see     GenQZT_KhDrtenMinyuuKykMeisaiTy
 */
@Entity
public class ZT_KhDrtenMinyuuKykMeisaiTy extends GenZT_KhDrtenMinyuuKykMeisaiTy {

    private static final long serialVersionUID = 1L;

    public ZT_KhDrtenMinyuuKykMeisaiTy() {
    }

    public ZT_KhDrtenMinyuuKykMeisaiTy(
        String pZtysyoriymd,
        String pZtybsydrtencd,
        String pZtysyono
    ) {
        super(
            pZtysyoriymd,
            pZtybsydrtencd,
            pZtysyono
        );
    }

}
