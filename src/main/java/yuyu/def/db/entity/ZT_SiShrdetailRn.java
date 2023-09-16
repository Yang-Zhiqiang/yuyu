package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SiShrdetailRn;
import yuyu.def.db.mapping.GenZT_SiShrdetailRn;
import yuyu.def.db.meta.GenQZT_SiShrdetailRn;
import yuyu.def.db.meta.QZT_SiShrdetailRn;

/**
 * 保険金給付金支払明細書テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SiShrdetailRn} の JavaDoc を参照してください。
 * @see     GenZT_SiShrdetailRn
 * @see     PKZT_SiShrdetailRn
 * @see     QZT_SiShrdetailRn
 * @see     GenQZT_SiShrdetailRn
 */
@Entity
public class ZT_SiShrdetailRn extends GenZT_SiShrdetailRn {

    private static final long serialVersionUID = 1L;

    public ZT_SiShrdetailRn() {
    }

    public ZT_SiShrdetailRn(
        String pZrntyouhyouymd,
        String pZrnsyono,
        String pZrnsikibetuno
    ) {
        super(
            pZrntyouhyouymd,
            pZrnsyono,
            pZrnsikibetuno
        );
    }

}
