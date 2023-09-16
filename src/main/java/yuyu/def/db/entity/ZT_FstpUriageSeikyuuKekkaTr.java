package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_FstpUriageSeikyuuKekkaTr;
import yuyu.def.db.mapping.GenZT_FstpUriageSeikyuuKekkaTr;
import yuyu.def.db.meta.GenQZT_FstpUriageSeikyuuKekkaTr;
import yuyu.def.db.meta.QZT_FstpUriageSeikyuuKekkaTr;

/**
 * 初回保険料売上請求結果テーブル（取） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_FstpUriageSeikyuuKekkaTr} の JavaDoc を参照してください。
 * @see     GenZT_FstpUriageSeikyuuKekkaTr
 * @see     PKZT_FstpUriageSeikyuuKekkaTr
 * @see     QZT_FstpUriageSeikyuuKekkaTr
 * @see     GenQZT_FstpUriageSeikyuuKekkaTr
 */
@Entity
public class ZT_FstpUriageSeikyuuKekkaTr extends GenZT_FstpUriageSeikyuuKekkaTr {

    private static final long serialVersionUID = 1L;

    public ZT_FstpUriageSeikyuuKekkaTr() {
    }

    public ZT_FstpUriageSeikyuuKekkaTr(
        String pZtruriageymd6keta,
        String pZtrcreditkessaiyouno,
        String pZtrsyono,
        String pZtrrecordno,
        Long pZtrseikyuukngk
    ) {
        super(
            pZtruriageymd6keta,
            pZtrcreditkessaiyouno,
            pZtrsyono,
            pZtrrecordno,
            pZtrseikyuukngk
        );
    }

}
