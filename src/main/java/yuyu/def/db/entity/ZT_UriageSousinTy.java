package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_UriageSousinTy;
import yuyu.def.db.mapping.GenZT_UriageSousinTy;
import yuyu.def.db.meta.GenQZT_UriageSousinTy;
import yuyu.def.db.meta.QZT_UriageSousinTy;

/**
 * 売上送信Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_UriageSousinTy} の JavaDoc を参照してください。
 * @see     GenZT_UriageSousinTy
 * @see     PKZT_UriageSousinTy
 * @see     QZT_UriageSousinTy
 * @see     GenQZT_UriageSousinTy
 */
@Entity
public class ZT_UriageSousinTy extends GenZT_UriageSousinTy {

    private static final long serialVersionUID = 1L;

    public ZT_UriageSousinTy() {
    }

    public ZT_UriageSousinTy(
        String pZtycreditkessaiyouno,
        String pZtysyono,
        String pZtyuriageseikyuuymd,
        Long pZtyrsgaku,
        String pZtyrecordno
    ) {
        super(
            pZtycreditkessaiyouno,
            pZtysyono,
            pZtyuriageseikyuuymd,
            pZtyrsgaku,
            pZtyrecordno
        );
    }

}
