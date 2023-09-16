package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SyoukenTkListSkTy;
import yuyu.def.db.mapping.GenZT_SyoukenTkListSkTy;
import yuyu.def.db.meta.GenQZT_SyoukenTkListSkTy;
import yuyu.def.db.meta.QZT_SyoukenTkListSkTy;

/**
 * 証券特殊処理明細リスト（新契約）Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SyoukenTkListSkTy} の JavaDoc を参照してください。
 * @see     GenZT_SyoukenTkListSkTy
 * @see     PKZT_SyoukenTkListSkTy
 * @see     QZT_SyoukenTkListSkTy
 * @see     GenQZT_SyoukenTkListSkTy
 */
@Entity
public class ZT_SyoukenTkListSkTy extends GenZT_SyoukenTkListSkTy {

    private static final long serialVersionUID = 1L;

    public ZT_SyoukenTkListSkTy() {
    }

    public ZT_SyoukenTkListSkTy(String pZtytyouhyouymd, String pZtysyono) {
        super(pZtytyouhyouymd, pZtysyono);
    }

}
