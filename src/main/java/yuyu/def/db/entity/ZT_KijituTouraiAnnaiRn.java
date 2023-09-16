package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KijituTouraiAnnaiRn;
import yuyu.def.db.mapping.GenZT_KijituTouraiAnnaiRn;
import yuyu.def.db.meta.GenQZT_KijituTouraiAnnaiRn;
import yuyu.def.db.meta.QZT_KijituTouraiAnnaiRn;

/**
 * 期日到来案内テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KijituTouraiAnnaiRn} の JavaDoc を参照してください。
 * @see     GenZT_KijituTouraiAnnaiRn
 * @see     PKZT_KijituTouraiAnnaiRn
 * @see     QZT_KijituTouraiAnnaiRn
 * @see     GenQZT_KijituTouraiAnnaiRn
 */
@Entity
public class ZT_KijituTouraiAnnaiRn extends GenZT_KijituTouraiAnnaiRn {

    private static final long serialVersionUID = 1L;

    public ZT_KijituTouraiAnnaiRn() {
    }

    public ZT_KijituTouraiAnnaiRn(String pZrntyouhyouymd, String pZrnsyono) {
        super(pZrntyouhyouymd, pZrnsyono);
    }

}
