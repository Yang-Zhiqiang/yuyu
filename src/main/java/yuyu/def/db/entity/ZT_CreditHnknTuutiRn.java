package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_CreditHnknTuutiRn;
import yuyu.def.db.mapping.GenZT_CreditHnknTuutiRn;
import yuyu.def.db.meta.GenQZT_CreditHnknTuutiRn;
import yuyu.def.db.meta.QZT_CreditHnknTuutiRn;

/**
 * クレカ返金通知テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_CreditHnknTuutiRn} の JavaDoc を参照してください。
 * @see     GenZT_CreditHnknTuutiRn
 * @see     PKZT_CreditHnknTuutiRn
 * @see     QZT_CreditHnknTuutiRn
 * @see     GenQZT_CreditHnknTuutiRn
 */
@Entity
public class ZT_CreditHnknTuutiRn extends GenZT_CreditHnknTuutiRn {

    private static final long serialVersionUID = 1L;

    public ZT_CreditHnknTuutiRn() {
    }

    public ZT_CreditHnknTuutiRn(
        String pZrnsyono,
        String pZrntyouhyouymd,
        String pZrnsikibetuno
    ) {
        super(
            pZrnsyono,
            pZrntyouhyouymd,
            pZrnsikibetuno
        );
    }

}
