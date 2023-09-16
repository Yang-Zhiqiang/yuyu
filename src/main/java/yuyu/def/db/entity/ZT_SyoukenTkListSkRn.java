package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SyoukenTkListSkRn;
import yuyu.def.db.mapping.GenZT_SyoukenTkListSkRn;
import yuyu.def.db.meta.GenQZT_SyoukenTkListSkRn;
import yuyu.def.db.meta.QZT_SyoukenTkListSkRn;

/**
 * 証券特殊処理明細リスト（新契約）Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SyoukenTkListSkRn} の JavaDoc を参照してください。
 * @see     GenZT_SyoukenTkListSkRn
 * @see     PKZT_SyoukenTkListSkRn
 * @see     QZT_SyoukenTkListSkRn
 * @see     GenQZT_SyoukenTkListSkRn
 */
@Entity
public class ZT_SyoukenTkListSkRn extends GenZT_SyoukenTkListSkRn {

    private static final long serialVersionUID = 1L;

    public ZT_SyoukenTkListSkRn() {
    }

    public ZT_SyoukenTkListSkRn(String pZrntyouhyouymd, String pZrnsyono) {
        super(pZrntyouhyouymd, pZrnsyono);
    }

}
