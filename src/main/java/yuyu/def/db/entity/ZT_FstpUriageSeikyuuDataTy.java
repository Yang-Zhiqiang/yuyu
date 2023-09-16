package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_FstpUriageSeikyuuDataTy;
import yuyu.def.db.mapping.GenZT_FstpUriageSeikyuuDataTy;
import yuyu.def.db.meta.GenQZT_FstpUriageSeikyuuDataTy;
import yuyu.def.db.meta.QZT_FstpUriageSeikyuuDataTy;

/**
 * 初回保険料売上請求データテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_FstpUriageSeikyuuDataTy} の JavaDoc を参照してください。
 * @see     GenZT_FstpUriageSeikyuuDataTy
 * @see     PKZT_FstpUriageSeikyuuDataTy
 * @see     QZT_FstpUriageSeikyuuDataTy
 * @see     GenQZT_FstpUriageSeikyuuDataTy
 */
@Entity
public class ZT_FstpUriageSeikyuuDataTy extends GenZT_FstpUriageSeikyuuDataTy {

    private static final long serialVersionUID = 1L;

    public ZT_FstpUriageSeikyuuDataTy() {
    }

    public ZT_FstpUriageSeikyuuDataTy(
        String pZtyuriageymd6keta,
        String pZtycreditkessaiyouno,
        String pZtysyono,
        String pZtyrecordno,
        Long pZtyseikyuukngk11keta
    ) {
        super(
            pZtyuriageymd6keta,
            pZtycreditkessaiyouno,
            pZtysyono,
            pZtyrecordno,
            pZtyseikyuukngk11keta
        );
    }

}
