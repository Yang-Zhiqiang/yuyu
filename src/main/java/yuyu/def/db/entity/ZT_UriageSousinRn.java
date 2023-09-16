package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_UriageSousinRn;
import yuyu.def.db.mapping.GenZT_UriageSousinRn;
import yuyu.def.db.meta.GenQZT_UriageSousinRn;
import yuyu.def.db.meta.QZT_UriageSousinRn;

/**
 * 売上送信Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_UriageSousinRn} の JavaDoc を参照してください。
 * @see     GenZT_UriageSousinRn
 * @see     PKZT_UriageSousinRn
 * @see     QZT_UriageSousinRn
 * @see     GenQZT_UriageSousinRn
 */
@Entity
public class ZT_UriageSousinRn extends GenZT_UriageSousinRn {

    private static final long serialVersionUID = 1L;

    public ZT_UriageSousinRn() {
    }

    public ZT_UriageSousinRn(
        String pZrncreditkessaiyouno,
        String pZrnsyono,
        String pZrnuriageseikyuuymd,
        Long pZrnrsgaku,
        String pZrnrecordno
    ) {
        super(
            pZrncreditkessaiyouno,
            pZrnsyono,
            pZrnuriageseikyuuymd,
            pZrnrsgaku,
            pZrnrecordno
        );
    }

}
