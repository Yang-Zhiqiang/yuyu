package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SeisanDHaneiTuutiRn;
import yuyu.def.db.mapping.GenZT_SeisanDHaneiTuutiRn;
import yuyu.def.db.meta.GenQZT_SeisanDHaneiTuutiRn;
import yuyu.def.db.meta.QZT_SeisanDHaneiTuutiRn;

/**
 * 精算Ｄ反映通知テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SeisanDHaneiTuutiRn} の JavaDoc を参照してください。
 * @see     GenZT_SeisanDHaneiTuutiRn
 * @see     PKZT_SeisanDHaneiTuutiRn
 * @see     QZT_SeisanDHaneiTuutiRn
 * @see     GenQZT_SeisanDHaneiTuutiRn
 */
@Entity
public class ZT_SeisanDHaneiTuutiRn extends GenZT_SeisanDHaneiTuutiRn {

    private static final long serialVersionUID = 1L;

    public ZT_SeisanDHaneiTuutiRn() {
    }

    public ZT_SeisanDHaneiTuutiRn(String pZrntyouhyouymd, String pZrnkeysyono) {
        super(pZrntyouhyouymd, pZrnkeysyono);
    }

}
