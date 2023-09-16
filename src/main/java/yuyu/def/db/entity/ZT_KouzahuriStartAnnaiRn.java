package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KouzahuriStartAnnaiRn;
import yuyu.def.db.mapping.GenZT_KouzahuriStartAnnaiRn;
import yuyu.def.db.meta.GenQZT_KouzahuriStartAnnaiRn;
import yuyu.def.db.meta.QZT_KouzahuriStartAnnaiRn;

/**
 * 口座振替開始案内テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KouzahuriStartAnnaiRn} の JavaDoc を参照してください。
 * @see     GenZT_KouzahuriStartAnnaiRn
 * @see     PKZT_KouzahuriStartAnnaiRn
 * @see     QZT_KouzahuriStartAnnaiRn
 * @see     GenQZT_KouzahuriStartAnnaiRn
 */
@Entity
public class ZT_KouzahuriStartAnnaiRn extends GenZT_KouzahuriStartAnnaiRn {

    private static final long serialVersionUID = 1L;

    public ZT_KouzahuriStartAnnaiRn() {
    }

    public ZT_KouzahuriStartAnnaiRn(String pZrntyouhyouymd, String pZrnsyono) {
        super(pZrntyouhyouymd, pZrnsyono);
    }

}
