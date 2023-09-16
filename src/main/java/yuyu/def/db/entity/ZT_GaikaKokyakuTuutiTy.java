package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_GaikaKokyakuTuutiTy;
import yuyu.def.db.mapping.GenZT_GaikaKokyakuTuutiTy;
import yuyu.def.db.meta.GenQZT_GaikaKokyakuTuutiTy;
import yuyu.def.db.meta.QZT_GaikaKokyakuTuutiTy;

/**
 * 外貨建顧客通知Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_GaikaKokyakuTuutiTy} の JavaDoc を参照してください。
 * @see     GenZT_GaikaKokyakuTuutiTy
 * @see     PKZT_GaikaKokyakuTuutiTy
 * @see     QZT_GaikaKokyakuTuutiTy
 * @see     GenQZT_GaikaKokyakuTuutiTy
 */
@Entity
public class ZT_GaikaKokyakuTuutiTy extends GenZT_GaikaKokyakuTuutiTy {

    private static final long serialVersionUID = 1L;

    public ZT_GaikaKokyakuTuutiTy() {
    }

    public ZT_GaikaKokyakuTuutiTy(String pZtytyouhyouymd, String pZtysyono) {
        super(pZtytyouhyouymd, pZtysyono);
    }

}
