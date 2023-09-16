package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_UriageKekkaTr;
import yuyu.def.db.mapping.GenZT_UriageKekkaTr;
import yuyu.def.db.meta.GenQZT_UriageKekkaTr;
import yuyu.def.db.meta.QZT_UriageKekkaTr;

/**
 * 売上結果Ｆテーブル（取） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_UriageKekkaTr} の JavaDoc を参照してください。
 * @see     GenZT_UriageKekkaTr
 * @see     PKZT_UriageKekkaTr
 * @see     QZT_UriageKekkaTr
 * @see     GenQZT_UriageKekkaTr
 */
@Entity
public class ZT_UriageKekkaTr extends GenZT_UriageKekkaTr {

    private static final long serialVersionUID = 1L;

    public ZT_UriageKekkaTr() {
    }

    public ZT_UriageKekkaTr(
        String pZtrsyono,
        String pZtrcreditkessaiyouno,
        String pZtruriageymd6keta,
        String pZtrrecordno,
        Long pZtrseikyuukngk
    ) {
        super(
            pZtrsyono,
            pZtrcreditkessaiyouno,
            pZtruriageymd6keta,
            pZtrrecordno,
            pZtrseikyuukngk
        );
    }

}
