package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_HonsyaToukeiRn;
import yuyu.def.db.mapping.GenZT_HonsyaToukeiRn;
import yuyu.def.db.meta.GenQZT_HonsyaToukeiRn;
import yuyu.def.db.meta.QZT_HonsyaToukeiRn;

/**
 * 本社統計Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_HonsyaToukeiRn} の JavaDoc を参照してください。
 * @see     GenZT_HonsyaToukeiRn
 * @see     PKZT_HonsyaToukeiRn
 * @see     QZT_HonsyaToukeiRn
 * @see     GenQZT_HonsyaToukeiRn
 */
@Entity
public class ZT_HonsyaToukeiRn extends GenZT_HonsyaToukeiRn {

    private static final long serialVersionUID = 1L;

    public ZT_HonsyaToukeiRn() {
    }

    public ZT_HonsyaToukeiRn(String pZrnkijyunym, String pZrnmosno) {
        super(pZrnkijyunym, pZrnmosno);
    }

}
