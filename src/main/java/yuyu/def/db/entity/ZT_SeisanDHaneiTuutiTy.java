package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SeisanDHaneiTuutiTy;
import yuyu.def.db.mapping.GenZT_SeisanDHaneiTuutiTy;
import yuyu.def.db.meta.GenQZT_SeisanDHaneiTuutiTy;
import yuyu.def.db.meta.QZT_SeisanDHaneiTuutiTy;

/**
 * 精算Ｄ反映通知テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SeisanDHaneiTuutiTy} の JavaDoc を参照してください。
 * @see     GenZT_SeisanDHaneiTuutiTy
 * @see     PKZT_SeisanDHaneiTuutiTy
 * @see     QZT_SeisanDHaneiTuutiTy
 * @see     GenQZT_SeisanDHaneiTuutiTy
 */
@Entity
public class ZT_SeisanDHaneiTuutiTy extends GenZT_SeisanDHaneiTuutiTy {

    private static final long serialVersionUID = 1L;

    public ZT_SeisanDHaneiTuutiTy() {
    }

    public ZT_SeisanDHaneiTuutiTy(String pZtytyouhyouymd, String pZtykeysyono) {
        super(pZtytyouhyouymd, pZtykeysyono);
    }

}
