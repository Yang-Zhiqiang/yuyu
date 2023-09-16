package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_CreditHnknTuutiTy;
import yuyu.def.db.mapping.GenZT_CreditHnknTuutiTy;
import yuyu.def.db.meta.GenQZT_CreditHnknTuutiTy;
import yuyu.def.db.meta.QZT_CreditHnknTuutiTy;

/**
 * クレカ返金通知テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_CreditHnknTuutiTy} の JavaDoc を参照してください。
 * @see     GenZT_CreditHnknTuutiTy
 * @see     PKZT_CreditHnknTuutiTy
 * @see     QZT_CreditHnknTuutiTy
 * @see     GenQZT_CreditHnknTuutiTy
 */
@Entity
public class ZT_CreditHnknTuutiTy extends GenZT_CreditHnknTuutiTy {

    private static final long serialVersionUID = 1L;

    public ZT_CreditHnknTuutiTy() {
    }

    public ZT_CreditHnknTuutiTy(
        String pZtysyono,
        String pZtytyouhyouymd,
        String pZtysikibetuno
    ) {
        super(
            pZtysyono,
            pZtytyouhyouymd,
            pZtysikibetuno
        );
    }

}
