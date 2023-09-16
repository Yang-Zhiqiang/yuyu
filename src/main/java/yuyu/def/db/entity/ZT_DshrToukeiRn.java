package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DshrToukeiRn;
import yuyu.def.db.mapping.GenZT_DshrToukeiRn;
import yuyu.def.db.meta.GenQZT_DshrToukeiRn;
import yuyu.def.db.meta.QZT_DshrToukeiRn;

/**
 * Ｄ支払統計Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DshrToukeiRn} の JavaDoc を参照してください。
 * @see     GenZT_DshrToukeiRn
 * @see     PKZT_DshrToukeiRn
 * @see     QZT_DshrToukeiRn
 * @see     GenQZT_DshrToukeiRn
 */
@Entity
public class ZT_DshrToukeiRn extends GenZT_DshrToukeiRn {

    private static final long serialVersionUID = 1L;

    public ZT_DshrToukeiRn() {
    }

    public ZT_DshrToukeiRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
