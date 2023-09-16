package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkToukeiHySgRn;
import yuyu.def.db.mapping.GenZT_NkToukeiHySgRn;
import yuyu.def.db.meta.GenQZT_NkToukeiHySgRn;
import yuyu.def.db.meta.QZT_NkToukeiHySgRn;

/**
 * 年金統計Ｆ保有照合用テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkToukeiHySgRn} の JavaDoc を参照してください。
 * @see     GenZT_NkToukeiHySgRn
 * @see     PKZT_NkToukeiHySgRn
 * @see     QZT_NkToukeiHySgRn
 * @see     GenQZT_NkToukeiHySgRn
 */
@Entity
public class ZT_NkToukeiHySgRn extends GenZT_NkToukeiHySgRn {

    private static final long serialVersionUID = 1L;

    public ZT_NkToukeiHySgRn() {
    }

    public ZT_NkToukeiHySgRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
