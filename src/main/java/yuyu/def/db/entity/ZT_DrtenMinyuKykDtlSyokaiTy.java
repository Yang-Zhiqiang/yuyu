package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DrtenMinyuKykDtlSyokaiTy;
import yuyu.def.db.mapping.GenZT_DrtenMinyuKykDtlSyokaiTy;
import yuyu.def.db.meta.GenQZT_DrtenMinyuKykDtlSyokaiTy;
import yuyu.def.db.meta.QZT_DrtenMinyuKykDtlSyokaiTy;

/**
 * 代理店未入契約明細照会用Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DrtenMinyuKykDtlSyokaiTy} の JavaDoc を参照してください。
 * @see     GenZT_DrtenMinyuKykDtlSyokaiTy
 * @see     PKZT_DrtenMinyuKykDtlSyokaiTy
 * @see     QZT_DrtenMinyuKykDtlSyokaiTy
 * @see     GenQZT_DrtenMinyuKykDtlSyokaiTy
 */
@Entity
public class ZT_DrtenMinyuKykDtlSyokaiTy extends GenZT_DrtenMinyuKykDtlSyokaiTy {

    private static final long serialVersionUID = 1L;

    public ZT_DrtenMinyuKykDtlSyokaiTy() {
    }

    public ZT_DrtenMinyuKykDtlSyokaiTy(
        String pZtysakuseiym,
        String pZtybsydrtencd,
        String pZtytntusycd,
        String pZtysyono
    ) {
        super(
            pZtysakuseiym,
            pZtybsydrtencd,
            pZtytntusycd,
            pZtysyono
        );
    }

}
