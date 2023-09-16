package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkToukeiRigRn;
import yuyu.def.db.mapping.GenZT_NkToukeiRigRn;
import yuyu.def.db.meta.GenQZT_NkToukeiRigRn;
import yuyu.def.db.meta.QZT_NkToukeiRigRn;

/**
 * 年金統計Ｆ例月用テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkToukeiRigRn} の JavaDoc を参照してください。
 * @see     GenZT_NkToukeiRigRn
 * @see     PKZT_NkToukeiRigRn
 * @see     QZT_NkToukeiRigRn
 * @see     GenQZT_NkToukeiRigRn
 */
@Entity
public class ZT_NkToukeiRigRn extends GenZT_NkToukeiRigRn {

    private static final long serialVersionUID = 1L;

    public ZT_NkToukeiRigRn() {
    }

    public ZT_NkToukeiRigRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
