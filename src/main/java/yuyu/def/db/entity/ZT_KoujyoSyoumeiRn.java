package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KoujyoSyoumeiRn;
import yuyu.def.db.mapping.GenZT_KoujyoSyoumeiRn;
import yuyu.def.db.meta.GenQZT_KoujyoSyoumeiRn;
import yuyu.def.db.meta.QZT_KoujyoSyoumeiRn;

/**
 * 控除証明書Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KoujyoSyoumeiRn} の JavaDoc を参照してください。
 * @see     GenZT_KoujyoSyoumeiRn
 * @see     PKZT_KoujyoSyoumeiRn
 * @see     QZT_KoujyoSyoumeiRn
 * @see     GenQZT_KoujyoSyoumeiRn
 */
@Entity
public class ZT_KoujyoSyoumeiRn extends GenZT_KoujyoSyoumeiRn {

    private static final long serialVersionUID = 1L;

    public ZT_KoujyoSyoumeiRn() {
    }

    public ZT_KoujyoSyoumeiRn(
        String pZrntyouhyouymd,
        String pZrnsyono,
        String pZrnsakunm15keta
    ) {
        super(
            pZrntyouhyouymd,
            pZrnsyono,
            pZrnsakunm15keta
        );
    }

}
