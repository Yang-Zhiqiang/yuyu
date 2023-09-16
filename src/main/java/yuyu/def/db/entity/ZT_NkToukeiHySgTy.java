package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkToukeiHySgTy;
import yuyu.def.db.mapping.GenZT_NkToukeiHySgTy;
import yuyu.def.db.meta.GenQZT_NkToukeiHySgTy;
import yuyu.def.db.meta.QZT_NkToukeiHySgTy;

/**
 * 年金統計Ｆ保有照合用テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkToukeiHySgTy} の JavaDoc を参照してください。
 * @see     GenZT_NkToukeiHySgTy
 * @see     PKZT_NkToukeiHySgTy
 * @see     QZT_NkToukeiHySgTy
 * @see     GenQZT_NkToukeiHySgTy
 */
@Entity
public class ZT_NkToukeiHySgTy extends GenZT_NkToukeiHySgTy {

    private static final long serialVersionUID = 1L;

    public ZT_NkToukeiHySgTy() {
    }

    public ZT_NkToukeiHySgTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
