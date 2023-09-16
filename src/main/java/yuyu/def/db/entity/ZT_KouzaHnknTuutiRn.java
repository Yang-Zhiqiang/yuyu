package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KouzaHnknTuutiRn;
import yuyu.def.db.mapping.GenZT_KouzaHnknTuutiRn;
import yuyu.def.db.meta.GenQZT_KouzaHnknTuutiRn;
import yuyu.def.db.meta.QZT_KouzaHnknTuutiRn;

/**
 * 口座返金通知テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KouzaHnknTuutiRn} の JavaDoc を参照してください。
 * @see     GenZT_KouzaHnknTuutiRn
 * @see     PKZT_KouzaHnknTuutiRn
 * @see     QZT_KouzaHnknTuutiRn
 * @see     GenQZT_KouzaHnknTuutiRn
 */
@Entity
public class ZT_KouzaHnknTuutiRn extends GenZT_KouzaHnknTuutiRn {

    private static final long serialVersionUID = 1L;

    public ZT_KouzaHnknTuutiRn() {
    }

    public ZT_KouzaHnknTuutiRn(
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
