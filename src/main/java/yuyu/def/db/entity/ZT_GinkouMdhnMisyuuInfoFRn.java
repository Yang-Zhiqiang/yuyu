package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_GinkouMdhnMisyuuInfoFRn;
import yuyu.def.db.mapping.GenZT_GinkouMdhnMisyuuInfoFRn;
import yuyu.def.db.meta.GenQZT_GinkouMdhnMisyuuInfoFRn;
import yuyu.def.db.meta.QZT_GinkouMdhnMisyuuInfoFRn;

/**
 * 銀行窓販未収情報Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_GinkouMdhnMisyuuInfoFRn} の JavaDoc を参照してください。
 * @see     GenZT_GinkouMdhnMisyuuInfoFRn
 * @see     PKZT_GinkouMdhnMisyuuInfoFRn
 * @see     QZT_GinkouMdhnMisyuuInfoFRn
 * @see     GenQZT_GinkouMdhnMisyuuInfoFRn
 */
@Entity
public class ZT_GinkouMdhnMisyuuInfoFRn extends GenZT_GinkouMdhnMisyuuInfoFRn {

    private static final long serialVersionUID = 1L;

    public ZT_GinkouMdhnMisyuuInfoFRn() {
    }

    public ZT_GinkouMdhnMisyuuInfoFRn(
        String pZrnbsydrtencd,
        String pZrndatasakuseiymd,
        String pZrnsyonosyuban
    ) {
        super(
            pZrnbsydrtencd,
            pZrndatasakuseiymd,
            pZrnsyonosyuban
        );
    }

}
