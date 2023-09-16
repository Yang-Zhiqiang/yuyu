package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DrtenMinyuuKykInfoTy;
import yuyu.def.db.mapping.GenZT_DrtenMinyuuKykInfoTy;
import yuyu.def.db.meta.GenQZT_DrtenMinyuuKykInfoTy;
import yuyu.def.db.meta.QZT_DrtenMinyuuKykInfoTy;

/**
 * 代理店未入契約情報Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DrtenMinyuuKykInfoTy} の JavaDoc を参照してください。
 * @see     GenZT_DrtenMinyuuKykInfoTy
 * @see     PKZT_DrtenMinyuuKykInfoTy
 * @see     QZT_DrtenMinyuuKykInfoTy
 * @see     GenQZT_DrtenMinyuuKykInfoTy
 */
@Entity
public class ZT_DrtenMinyuuKykInfoTy extends GenZT_DrtenMinyuuKykInfoTy {

    private static final long serialVersionUID = 1L;

    public ZT_DrtenMinyuuKykInfoTy() {
    }

    public ZT_DrtenMinyuuKykInfoTy(String pZtysyono) {
        super(pZtysyono);
    }

}
