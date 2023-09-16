package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_YuseiMinyuKykDtlSyokaiTy;
import yuyu.def.db.mapping.GenZT_YuseiMinyuKykDtlSyokaiTy;
import yuyu.def.db.meta.GenQZT_YuseiMinyuKykDtlSyokaiTy;
import yuyu.def.db.meta.QZT_YuseiMinyuKykDtlSyokaiTy;

/**
 * 郵政未入契約明細照会用Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_YuseiMinyuKykDtlSyokaiTy} の JavaDoc を参照してください。
 * @see     GenZT_YuseiMinyuKykDtlSyokaiTy
 * @see     PKZT_YuseiMinyuKykDtlSyokaiTy
 * @see     QZT_YuseiMinyuKykDtlSyokaiTy
 * @see     GenQZT_YuseiMinyuKykDtlSyokaiTy
 */
@Entity
public class ZT_YuseiMinyuKykDtlSyokaiTy extends GenZT_YuseiMinyuKykDtlSyokaiTy {

    private static final long serialVersionUID = 1L;

    public ZT_YuseiMinyuKykDtlSyokaiTy() {
    }

    public ZT_YuseiMinyuKykDtlSyokaiTy(
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
