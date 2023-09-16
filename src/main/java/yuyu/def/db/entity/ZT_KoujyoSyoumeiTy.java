package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KoujyoSyoumeiTy;
import yuyu.def.db.mapping.GenZT_KoujyoSyoumeiTy;
import yuyu.def.db.meta.GenQZT_KoujyoSyoumeiTy;
import yuyu.def.db.meta.QZT_KoujyoSyoumeiTy;

/**
 * 控除証明書Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KoujyoSyoumeiTy} の JavaDoc を参照してください。
 * @see     GenZT_KoujyoSyoumeiTy
 * @see     PKZT_KoujyoSyoumeiTy
 * @see     QZT_KoujyoSyoumeiTy
 * @see     GenQZT_KoujyoSyoumeiTy
 */
@Entity
public class ZT_KoujyoSyoumeiTy extends GenZT_KoujyoSyoumeiTy {

    private static final long serialVersionUID = 1L;

    public ZT_KoujyoSyoumeiTy() {
    }

    public ZT_KoujyoSyoumeiTy(
        String pZtytyouhyouymd,
        String pZtysyono,
        String pZtysakunm15keta
    ) {
        super(
            pZtytyouhyouymd,
            pZtysyono,
            pZtysakunm15keta
        );
    }

}
