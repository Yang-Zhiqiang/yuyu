package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_GinkouMdhnMisyuuInfoFTy;
import yuyu.def.db.mapping.GenZT_GinkouMdhnMisyuuInfoFTy;
import yuyu.def.db.meta.GenQZT_GinkouMdhnMisyuuInfoFTy;
import yuyu.def.db.meta.QZT_GinkouMdhnMisyuuInfoFTy;

/**
 * 銀行窓販未収情報Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_GinkouMdhnMisyuuInfoFTy} の JavaDoc を参照してください。
 * @see     GenZT_GinkouMdhnMisyuuInfoFTy
 * @see     PKZT_GinkouMdhnMisyuuInfoFTy
 * @see     QZT_GinkouMdhnMisyuuInfoFTy
 * @see     GenQZT_GinkouMdhnMisyuuInfoFTy
 */
@Entity
public class ZT_GinkouMdhnMisyuuInfoFTy extends GenZT_GinkouMdhnMisyuuInfoFTy {

    private static final long serialVersionUID = 1L;

    public ZT_GinkouMdhnMisyuuInfoFTy() {
    }

    public ZT_GinkouMdhnMisyuuInfoFTy(
        String pZtybsydrtencd,
        String pZtydatasakuseiymd,
        String pZtysyonosyuban
    ) {
        super(
            pZtybsydrtencd,
            pZtydatasakuseiymd,
            pZtysyonosyuban
        );
    }

}
