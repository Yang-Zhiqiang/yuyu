package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SkKouhuriUkTrkkekkaTr;
import yuyu.def.db.mapping.GenZT_SkKouhuriUkTrkkekkaTr;
import yuyu.def.db.meta.GenQZT_SkKouhuriUkTrkkekkaTr;
import yuyu.def.db.meta.QZT_SkKouhuriUkTrkkekkaTr;

/**
 * 新契約口振受付登録結果テーブル（取） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkKouhuriUkTrkkekkaTr} の JavaDoc を参照してください。
 * @see     GenZT_SkKouhuriUkTrkkekkaTr
 * @see     PKZT_SkKouhuriUkTrkkekkaTr
 * @see     QZT_SkKouhuriUkTrkkekkaTr
 * @see     GenQZT_SkKouhuriUkTrkkekkaTr
 */
@Entity
public class ZT_SkKouhuriUkTrkkekkaTr extends GenZT_SkKouhuriUkTrkkekkaTr {

    private static final long serialVersionUID = 1L;

    public ZT_SkKouhuriUkTrkkekkaTr() {
    }

    public ZT_SkKouhuriUkTrkkekkaTr(
        String pZtrsyukkncd,
        String pZtrkinyuukikancd8keta,
        String pZtrkinyuukkntratkiymd,
        String pZtrkinyuukkntratkitime,
        String pZtrkouhuriokyakusamano
    ) {
        super(
            pZtrsyukkncd,
            pZtrkinyuukikancd8keta,
            pZtrkinyuukkntratkiymd,
            pZtrkinyuukkntratkitime,
            pZtrkouhuriokyakusamano
        );
    }

}
