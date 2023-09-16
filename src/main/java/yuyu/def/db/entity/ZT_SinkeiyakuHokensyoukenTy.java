package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SinkeiyakuHokensyoukenTy;
import yuyu.def.db.mapping.GenZT_SinkeiyakuHokensyoukenTy;
import yuyu.def.db.meta.GenQZT_SinkeiyakuHokensyoukenTy;
import yuyu.def.db.meta.QZT_SinkeiyakuHokensyoukenTy;

/**
 * 新契約保険証券Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SinkeiyakuHokensyoukenTy} の JavaDoc を参照してください。
 * @see     GenZT_SinkeiyakuHokensyoukenTy
 * @see     PKZT_SinkeiyakuHokensyoukenTy
 * @see     QZT_SinkeiyakuHokensyoukenTy
 * @see     GenQZT_SinkeiyakuHokensyoukenTy
 */
@Entity
public class ZT_SinkeiyakuHokensyoukenTy extends GenZT_SinkeiyakuHokensyoukenTy {

    private static final long serialVersionUID = 1L;

    public ZT_SinkeiyakuHokensyoukenTy() {
    }

    public ZT_SinkeiyakuHokensyoukenTy(String pZtytyouhyouymd, String pZtysyono) {
        super(pZtytyouhyouymd, pZtysyono);
    }

}
