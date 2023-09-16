package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_FstpUriageSeikyuuKekkaRn;
import yuyu.def.db.mapping.GenZT_FstpUriageSeikyuuKekkaRn;
import yuyu.def.db.meta.GenQZT_FstpUriageSeikyuuKekkaRn;
import yuyu.def.db.meta.QZT_FstpUriageSeikyuuKekkaRn;

/**
 * 初回保険料売上請求結果テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_FstpUriageSeikyuuKekkaRn} の JavaDoc を参照してください。
 * @see     GenZT_FstpUriageSeikyuuKekkaRn
 * @see     PKZT_FstpUriageSeikyuuKekkaRn
 * @see     QZT_FstpUriageSeikyuuKekkaRn
 * @see     GenQZT_FstpUriageSeikyuuKekkaRn
 */
@Entity
public class ZT_FstpUriageSeikyuuKekkaRn extends GenZT_FstpUriageSeikyuuKekkaRn {

    private static final long serialVersionUID = 1L;

    public ZT_FstpUriageSeikyuuKekkaRn() {
    }

    public ZT_FstpUriageSeikyuuKekkaRn(
        String pZrnuriageymd6keta,
        String pZrncreditkessaiyouno,
        String pZrnsyono,
        String pZrnrecordno,
        Long pZrnseikyuukngk
    ) {
        super(
            pZrnuriageymd6keta,
            pZrncreditkessaiyouno,
            pZrnsyono,
            pZrnrecordno,
            pZrnseikyuukngk
        );
    }

}
