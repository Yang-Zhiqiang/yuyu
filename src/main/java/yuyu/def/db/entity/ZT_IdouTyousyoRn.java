package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_IdouTyousyoRn;
import yuyu.def.db.mapping.GenZT_IdouTyousyoRn;
import yuyu.def.db.meta.GenQZT_IdouTyousyoRn;
import yuyu.def.db.meta.QZT_IdouTyousyoRn;

/**
 * 異動調書テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_IdouTyousyoRn} の JavaDoc を参照してください。
 * @see     GenZT_IdouTyousyoRn
 * @see     PKZT_IdouTyousyoRn
 * @see     QZT_IdouTyousyoRn
 * @see     GenQZT_IdouTyousyoRn
 */
@Entity
public class ZT_IdouTyousyoRn extends GenZT_IdouTyousyoRn {

    private static final long serialVersionUID = 1L;

    public ZT_IdouTyousyoRn() {
    }

    public ZT_IdouTyousyoRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
