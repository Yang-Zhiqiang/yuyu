package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_SkKsnKaikeiTorihikiTy;
import yuyu.def.db.mapping.GenZT_SkKsnKaikeiTorihikiTy;
import yuyu.def.db.meta.GenQZT_SkKsnKaikeiTorihikiTy;
import yuyu.def.db.meta.QZT_SkKsnKaikeiTorihikiTy;

/**
 * 新契約決算用会計取引Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkKsnKaikeiTorihikiTy} の JavaDoc を参照してください。
 * @see     GenZT_SkKsnKaikeiTorihikiTy
 * @see     PKZT_SkKsnKaikeiTorihikiTy
 * @see     QZT_SkKsnKaikeiTorihikiTy
 * @see     GenQZT_SkKsnKaikeiTorihikiTy
 */
@Entity
public class ZT_SkKsnKaikeiTorihikiTy extends GenZT_SkKsnKaikeiTorihikiTy {

    private static final long serialVersionUID = 1L;

    public ZT_SkKsnKaikeiTorihikiTy() {
    }

    public ZT_SkKsnKaikeiTorihikiTy(
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
