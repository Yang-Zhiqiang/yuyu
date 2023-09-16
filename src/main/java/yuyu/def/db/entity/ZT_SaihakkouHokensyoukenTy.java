package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SaihakkouHokensyoukenTy;
import yuyu.def.db.mapping.GenZT_SaihakkouHokensyoukenTy;
import yuyu.def.db.meta.GenQZT_SaihakkouHokensyoukenTy;
import yuyu.def.db.meta.QZT_SaihakkouHokensyoukenTy;

/**
 * 再発行保険証券Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SaihakkouHokensyoukenTy} の JavaDoc を参照してください。
 * @see     GenZT_SaihakkouHokensyoukenTy
 * @see     PKZT_SaihakkouHokensyoukenTy
 * @see     QZT_SaihakkouHokensyoukenTy
 * @see     GenQZT_SaihakkouHokensyoukenTy
 */
@Entity
public class ZT_SaihakkouHokensyoukenTy extends GenZT_SaihakkouHokensyoukenTy {

    private static final long serialVersionUID = 1L;

    public ZT_SaihakkouHokensyoukenTy() {
    }

    public ZT_SaihakkouHokensyoukenTy(String pZtytyouhyouymd, String pZtysyono) {
        super(pZtytyouhyouymd, pZtysyono);
    }

}
