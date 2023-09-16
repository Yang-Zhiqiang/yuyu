package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DshrToukeiLoadingTy;
import yuyu.def.db.mapping.GenZT_DshrToukeiLoadingTy;
import yuyu.def.db.meta.GenQZT_DshrToukeiLoadingTy;
import yuyu.def.db.meta.QZT_DshrToukeiLoadingTy;

/**
 * Ｄ支払統計ローディングＦテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DshrToukeiLoadingTy} の JavaDoc を参照してください。
 * @see     GenZT_DshrToukeiLoadingTy
 * @see     PKZT_DshrToukeiLoadingTy
 * @see     QZT_DshrToukeiLoadingTy
 * @see     GenQZT_DshrToukeiLoadingTy
 */
@Entity
public class ZT_DshrToukeiLoadingTy extends GenZT_DshrToukeiLoadingTy {

    private static final long serialVersionUID = 1L;

    public ZT_DshrToukeiLoadingTy() {
    }

    public ZT_DshrToukeiLoadingTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
