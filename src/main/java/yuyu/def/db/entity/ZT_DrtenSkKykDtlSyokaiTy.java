package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DrtenSkKykDtlSyokaiTy;
import yuyu.def.db.mapping.GenZT_DrtenSkKykDtlSyokaiTy;
import yuyu.def.db.meta.GenQZT_DrtenSkKykDtlSyokaiTy;
import yuyu.def.db.meta.QZT_DrtenSkKykDtlSyokaiTy;

/**
 * 代理店失効契約明細照会用Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DrtenSkKykDtlSyokaiTy} の JavaDoc を参照してください。
 * @see     GenZT_DrtenSkKykDtlSyokaiTy
 * @see     PKZT_DrtenSkKykDtlSyokaiTy
 * @see     QZT_DrtenSkKykDtlSyokaiTy
 * @see     GenQZT_DrtenSkKykDtlSyokaiTy
 */
@Entity
public class ZT_DrtenSkKykDtlSyokaiTy extends GenZT_DrtenSkKykDtlSyokaiTy {

    private static final long serialVersionUID = 1L;

    public ZT_DrtenSkKykDtlSyokaiTy() {
    }

    public ZT_DrtenSkKykDtlSyokaiTy(
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
