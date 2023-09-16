package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_UriageKekkaRn;
import yuyu.def.db.mapping.GenZT_UriageKekkaRn;
import yuyu.def.db.meta.GenQZT_UriageKekkaRn;
import yuyu.def.db.meta.QZT_UriageKekkaRn;

/**
 * 売上結果Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_UriageKekkaRn} の JavaDoc を参照してください。
 * @see     GenZT_UriageKekkaRn
 * @see     PKZT_UriageKekkaRn
 * @see     QZT_UriageKekkaRn
 * @see     GenQZT_UriageKekkaRn
 */
@Entity
public class ZT_UriageKekkaRn extends GenZT_UriageKekkaRn {

    private static final long serialVersionUID = 1L;

    public ZT_UriageKekkaRn() {
    }

    public ZT_UriageKekkaRn(
        String pZrnsyono,
        String pZrncreditkessaiyouno,
        String pZrnuriageymd6keta,
        String pZrnrecordno,
        Long pZrnseikyuukngk
    ) {
        super(
            pZrnsyono,
            pZrncreditkessaiyouno,
            pZrnuriageymd6keta,
            pZrnrecordno,
            pZrnseikyuukngk
        );
    }

}
