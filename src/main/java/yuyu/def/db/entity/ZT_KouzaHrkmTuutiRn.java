package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KouzaHrkmTuutiRn;
import yuyu.def.db.mapping.GenZT_KouzaHrkmTuutiRn;
import yuyu.def.db.meta.GenQZT_KouzaHrkmTuutiRn;
import yuyu.def.db.meta.QZT_KouzaHrkmTuutiRn;

/**
 * 口座振込通知テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KouzaHrkmTuutiRn} の JavaDoc を参照してください。
 * @see     GenZT_KouzaHrkmTuutiRn
 * @see     PKZT_KouzaHrkmTuutiRn
 * @see     QZT_KouzaHrkmTuutiRn
 * @see     GenQZT_KouzaHrkmTuutiRn
 */
@Entity
public class ZT_KouzaHrkmTuutiRn extends GenZT_KouzaHrkmTuutiRn {

    private static final long serialVersionUID = 1L;

    public ZT_KouzaHrkmTuutiRn() {
    }

    public ZT_KouzaHrkmTuutiRn(
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
