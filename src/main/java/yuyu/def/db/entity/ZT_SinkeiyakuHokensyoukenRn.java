package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SinkeiyakuHokensyoukenRn;
import yuyu.def.db.mapping.GenZT_SinkeiyakuHokensyoukenRn;
import yuyu.def.db.meta.GenQZT_SinkeiyakuHokensyoukenRn;
import yuyu.def.db.meta.QZT_SinkeiyakuHokensyoukenRn;

/**
 * 新契約保険証券Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SinkeiyakuHokensyoukenRn} の JavaDoc を参照してください。
 * @see     GenZT_SinkeiyakuHokensyoukenRn
 * @see     PKZT_SinkeiyakuHokensyoukenRn
 * @see     QZT_SinkeiyakuHokensyoukenRn
 * @see     GenQZT_SinkeiyakuHokensyoukenRn
 */
@Entity
public class ZT_SinkeiyakuHokensyoukenRn extends GenZT_SinkeiyakuHokensyoukenRn {

    private static final long serialVersionUID = 1L;

    public ZT_SinkeiyakuHokensyoukenRn() {
    }

    public ZT_SinkeiyakuHokensyoukenRn(String pZrntyouhyouymd, String pZrnsyono) {
        super(pZrntyouhyouymd, pZrnsyono);
    }

}
