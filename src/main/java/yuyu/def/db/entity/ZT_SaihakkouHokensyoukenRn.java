package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SaihakkouHokensyoukenRn;
import yuyu.def.db.mapping.GenZT_SaihakkouHokensyoukenRn;
import yuyu.def.db.meta.GenQZT_SaihakkouHokensyoukenRn;
import yuyu.def.db.meta.QZT_SaihakkouHokensyoukenRn;

/**
 * 再発行保険証券Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SaihakkouHokensyoukenRn} の JavaDoc を参照してください。
 * @see     GenZT_SaihakkouHokensyoukenRn
 * @see     PKZT_SaihakkouHokensyoukenRn
 * @see     QZT_SaihakkouHokensyoukenRn
 * @see     GenQZT_SaihakkouHokensyoukenRn
 */
@Entity
public class ZT_SaihakkouHokensyoukenRn extends GenZT_SaihakkouHokensyoukenRn {

    private static final long serialVersionUID = 1L;

    public ZT_SaihakkouHokensyoukenRn() {
    }

    public ZT_SaihakkouHokensyoukenRn(String pZrntyouhyouymd, String pZrnsyono) {
        super(pZrntyouhyouymd, pZrnsyono);
    }

}
