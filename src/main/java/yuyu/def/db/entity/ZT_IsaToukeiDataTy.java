package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_IsaToukeiDataTy;
import yuyu.def.db.mapping.GenZT_IsaToukeiDataTy;
import yuyu.def.db.meta.GenQZT_IsaToukeiDataTy;
import yuyu.def.db.meta.QZT_IsaToukeiDataTy;

/**
 * 医査統計データテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_IsaToukeiDataTy} の JavaDoc を参照してください。
 * @see     GenZT_IsaToukeiDataTy
 * @see     PKZT_IsaToukeiDataTy
 * @see     QZT_IsaToukeiDataTy
 * @see     GenQZT_IsaToukeiDataTy
 */
@Entity
public class ZT_IsaToukeiDataTy extends GenZT_IsaToukeiDataTy {

    private static final long serialVersionUID = 1L;

    public ZT_IsaToukeiDataTy() {
    }

    public ZT_IsaToukeiDataTy(String pZtymosno) {
        super(pZtymosno);
    }

}
