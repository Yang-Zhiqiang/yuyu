package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_NkToukeiRigTy;
import yuyu.def.db.mapping.GenZT_NkToukeiRigTy;
import yuyu.def.db.meta.GenQZT_NkToukeiRigTy;
import yuyu.def.db.meta.QZT_NkToukeiRigTy;

/**
 * 年金統計Ｆ例月用テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_NkToukeiRigTy} の JavaDoc を参照してください。
 * @see     GenZT_NkToukeiRigTy
 * @see     PKZT_NkToukeiRigTy
 * @see     QZT_NkToukeiRigTy
 * @see     GenQZT_NkToukeiRigTy
 */
@Entity
public class ZT_NkToukeiRigTy extends GenZT_NkToukeiRigTy {

    private static final long serialVersionUID = 1L;

    public ZT_NkToukeiRigTy() {
    }

    public ZT_NkToukeiRigTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
