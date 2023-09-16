package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SyoukenTkListShRn;
import yuyu.def.db.mapping.GenZT_SyoukenTkListShRn;
import yuyu.def.db.meta.GenQZT_SyoukenTkListShRn;
import yuyu.def.db.meta.QZT_SyoukenTkListShRn;

/**
 * 証券特殊処理明細リスト（再発行）Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SyoukenTkListShRn} の JavaDoc を参照してください。
 * @see     GenZT_SyoukenTkListShRn
 * @see     PKZT_SyoukenTkListShRn
 * @see     QZT_SyoukenTkListShRn
 * @see     GenQZT_SyoukenTkListShRn
 */
@Entity
public class ZT_SyoukenTkListShRn extends GenZT_SyoukenTkListShRn {

    private static final long serialVersionUID = 1L;

    public ZT_SyoukenTkListShRn() {
    }

    public ZT_SyoukenTkListShRn(String pZrntyouhyouymd, String pZrnsyono) {
        super(pZrntyouhyouymd, pZrnsyono);
    }

}
