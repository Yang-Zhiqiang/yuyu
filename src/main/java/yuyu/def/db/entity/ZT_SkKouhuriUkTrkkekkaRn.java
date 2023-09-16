package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SkKouhuriUkTrkkekkaRn;
import yuyu.def.db.mapping.GenZT_SkKouhuriUkTrkkekkaRn;
import yuyu.def.db.meta.GenQZT_SkKouhuriUkTrkkekkaRn;
import yuyu.def.db.meta.QZT_SkKouhuriUkTrkkekkaRn;

/**
 * 新契約口振受付登録結果テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkKouhuriUkTrkkekkaRn} の JavaDoc を参照してください。
 * @see     GenZT_SkKouhuriUkTrkkekkaRn
 * @see     PKZT_SkKouhuriUkTrkkekkaRn
 * @see     QZT_SkKouhuriUkTrkkekkaRn
 * @see     GenQZT_SkKouhuriUkTrkkekkaRn
 */
@Entity
public class ZT_SkKouhuriUkTrkkekkaRn extends GenZT_SkKouhuriUkTrkkekkaRn {

    private static final long serialVersionUID = 1L;

    public ZT_SkKouhuriUkTrkkekkaRn() {
    }

    public ZT_SkKouhuriUkTrkkekkaRn(
        String pZrnsyukkncd,
        String pZrnkinyuukikancd8keta,
        String pZrnkinyuukkntratkiymd,
        String pZrnkinyuukkntratkitime,
        String pZrnkouhuriokyakusamano
    ) {
        super(
            pZrnsyukkncd,
            pZrnkinyuukikancd8keta,
            pZrnkinyuukkntratkiymd,
            pZrnkinyuukkntratkitime,
            pZrnkouhuriokyakusamano
        );
    }

}
