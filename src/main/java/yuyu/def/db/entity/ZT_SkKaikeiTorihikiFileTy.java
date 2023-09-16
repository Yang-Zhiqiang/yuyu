package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_SkKaikeiTorihikiFileTy;
import yuyu.def.db.mapping.GenZT_SkKaikeiTorihikiFileTy;
import yuyu.def.db.meta.GenQZT_SkKaikeiTorihikiFileTy;
import yuyu.def.db.meta.QZT_SkKaikeiTorihikiFileTy;

/**
 * 新契約会計取引ファイルテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkKaikeiTorihikiFileTy} の JavaDoc を参照してください。
 * @see     GenZT_SkKaikeiTorihikiFileTy
 * @see     PKZT_SkKaikeiTorihikiFileTy
 * @see     QZT_SkKaikeiTorihikiFileTy
 * @see     GenQZT_SkKaikeiTorihikiFileTy
 */
@Entity
public class ZT_SkKaikeiTorihikiFileTy extends GenZT_SkKaikeiTorihikiFileTy {

    private static final long serialVersionUID = 1L;

    public ZT_SkKaikeiTorihikiFileTy() {
    }

    public ZT_SkKaikeiTorihikiFileTy(
        String pZtytorihikiymd,
        String pZtytorihikinon7,
        String pZtytaisyakukbnn,
        String pZtykanjyoukamokucdn,
        String pZtysuitoubumon,
        String pZtytekiyoucd
        ) {
        super(
            pZtytorihikiymd,
            pZtytorihikinon7,
            pZtytaisyakukbnn,
            pZtykanjyoukamokucdn,
            pZtysuitoubumon,
            pZtytekiyoucd
            );
    }

}
