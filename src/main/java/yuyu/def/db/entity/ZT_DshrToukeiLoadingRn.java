package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DshrToukeiLoadingRn;
import yuyu.def.db.mapping.GenZT_DshrToukeiLoadingRn;
import yuyu.def.db.meta.GenQZT_DshrToukeiLoadingRn;
import yuyu.def.db.meta.QZT_DshrToukeiLoadingRn;

/**
 * Ｄ支払統計ローディングＦテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DshrToukeiLoadingRn} の JavaDoc を参照してください。
 * @see     GenZT_DshrToukeiLoadingRn
 * @see     PKZT_DshrToukeiLoadingRn
 * @see     QZT_DshrToukeiLoadingRn
 * @see     GenQZT_DshrToukeiLoadingRn
 */
@Entity
public class ZT_DshrToukeiLoadingRn extends GenZT_DshrToukeiLoadingRn {

    private static final long serialVersionUID = 1L;

    public ZT_DshrToukeiLoadingRn() {
    }

    public ZT_DshrToukeiLoadingRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
