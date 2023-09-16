package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_FstpUriageSeikyuuDataRn;
import yuyu.def.db.mapping.GenZT_FstpUriageSeikyuuDataRn;
import yuyu.def.db.meta.GenQZT_FstpUriageSeikyuuDataRn;
import yuyu.def.db.meta.QZT_FstpUriageSeikyuuDataRn;

/**
 * 初回保険料売上請求データテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_FstpUriageSeikyuuDataRn} の JavaDoc を参照してください。
 * @see     GenZT_FstpUriageSeikyuuDataRn
 * @see     PKZT_FstpUriageSeikyuuDataRn
 * @see     QZT_FstpUriageSeikyuuDataRn
 * @see     GenQZT_FstpUriageSeikyuuDataRn
 */
@Entity
public class ZT_FstpUriageSeikyuuDataRn extends GenZT_FstpUriageSeikyuuDataRn {

    private static final long serialVersionUID = 1L;

    public ZT_FstpUriageSeikyuuDataRn() {
    }

    public ZT_FstpUriageSeikyuuDataRn(
        String pZrnuriageymd6keta,
        String pZrncreditkessaiyouno,
        String pZrnsyono,
        String pZrnrecordno,
        Long pZrnseikyuukngk11keta
    ) {
        super(
            pZrnuriageymd6keta,
            pZrncreditkessaiyouno,
            pZrnsyono,
            pZrnrecordno,
            pZrnseikyuukngk11keta
        );
    }

}
