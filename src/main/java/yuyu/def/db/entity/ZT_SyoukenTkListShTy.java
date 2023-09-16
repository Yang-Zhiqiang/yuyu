package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SyoukenTkListShTy;
import yuyu.def.db.mapping.GenZT_SyoukenTkListShTy;
import yuyu.def.db.meta.GenQZT_SyoukenTkListShTy;
import yuyu.def.db.meta.QZT_SyoukenTkListShTy;

/**
 * 証券特殊処理明細リスト（再発行）Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SyoukenTkListShTy} の JavaDoc を参照してください。
 * @see     GenZT_SyoukenTkListShTy
 * @see     PKZT_SyoukenTkListShTy
 * @see     QZT_SyoukenTkListShTy
 * @see     GenQZT_SyoukenTkListShTy
 */
@Entity
public class ZT_SyoukenTkListShTy extends GenZT_SyoukenTkListShTy {

    private static final long serialVersionUID = 1L;

    public ZT_SyoukenTkListShTy() {
    }

    public ZT_SyoukenTkListShTy(String pZtytyouhyouymd, String pZtysyono) {
        super(pZtytyouhyouymd, pZtysyono);
    }

}
