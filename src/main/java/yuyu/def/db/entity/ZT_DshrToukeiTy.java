package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DshrToukeiTy;
import yuyu.def.db.mapping.GenZT_DshrToukeiTy;
import yuyu.def.db.meta.GenQZT_DshrToukeiTy;
import yuyu.def.db.meta.QZT_DshrToukeiTy;

/**
 * Ｄ支払統計Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DshrToukeiTy} の JavaDoc を参照してください。
 * @see     GenZT_DshrToukeiTy
 * @see     PKZT_DshrToukeiTy
 * @see     QZT_DshrToukeiTy
 * @see     GenQZT_DshrToukeiTy
 */
@Entity
public class ZT_DshrToukeiTy extends GenZT_DshrToukeiTy {

    private static final long serialVersionUID = 1L;

    public ZT_DshrToukeiTy() {
    }

    public ZT_DshrToukeiTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
