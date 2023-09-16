package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KouzahuriMinyuTuutiRn;
import yuyu.def.db.mapping.GenZT_KouzahuriMinyuTuutiRn;
import yuyu.def.db.meta.GenQZT_KouzahuriMinyuTuutiRn;
import yuyu.def.db.meta.QZT_KouzahuriMinyuTuutiRn;

/**
 * 口座振替未入通知テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KouzahuriMinyuTuutiRn} の JavaDoc を参照してください。
 * @see     GenZT_KouzahuriMinyuTuutiRn
 * @see     PKZT_KouzahuriMinyuTuutiRn
 * @see     QZT_KouzahuriMinyuTuutiRn
 * @see     GenQZT_KouzahuriMinyuTuutiRn
 */
@Entity
public class ZT_KouzahuriMinyuTuutiRn extends GenZT_KouzahuriMinyuTuutiRn {

    private static final long serialVersionUID = 1L;

    public ZT_KouzahuriMinyuTuutiRn() {
    }

    public ZT_KouzahuriMinyuTuutiRn(String pZrntyouhyouymd, String pZrnsyono) {
        super(pZrntyouhyouymd, pZrnsyono);
    }

}
