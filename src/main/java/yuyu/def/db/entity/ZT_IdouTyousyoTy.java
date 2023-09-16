package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_IdouTyousyoTy;
import yuyu.def.db.mapping.GenZT_IdouTyousyoTy;
import yuyu.def.db.meta.GenQZT_IdouTyousyoTy;
import yuyu.def.db.meta.QZT_IdouTyousyoTy;

/**
 * 異動調書テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_IdouTyousyoTy} の JavaDoc を参照してください。
 * @see     GenZT_IdouTyousyoTy
 * @see     PKZT_IdouTyousyoTy
 * @see     QZT_IdouTyousyoTy
 * @see     GenQZT_IdouTyousyoTy
 */
@Entity
public class ZT_IdouTyousyoTy extends GenZT_IdouTyousyoTy {

    private static final long serialVersionUID = 1L;

    public ZT_IdouTyousyoTy() {
    }

    public ZT_IdouTyousyoTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
