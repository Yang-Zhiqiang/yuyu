package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SkKsnKaikeiTorihikiRn;
import yuyu.def.db.mapping.GenZT_SkKsnKaikeiTorihikiRn;
import yuyu.def.db.meta.GenQZT_SkKsnKaikeiTorihikiRn;
import yuyu.def.db.meta.QZT_SkKsnKaikeiTorihikiRn;

/**
 * 新契約決算用会計取引Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkKsnKaikeiTorihikiRn} の JavaDoc を参照してください。
 * @see     GenZT_SkKsnKaikeiTorihikiRn
 * @see     PKZT_SkKsnKaikeiTorihikiRn
 * @see     QZT_SkKsnKaikeiTorihikiRn
 * @see     GenQZT_SkKsnKaikeiTorihikiRn
 */
@Entity
public class ZT_SkKsnKaikeiTorihikiRn extends GenZT_SkKsnKaikeiTorihikiRn {

    private static final long serialVersionUID = 1L;

    public ZT_SkKsnKaikeiTorihikiRn() {
    }

    public ZT_SkKsnKaikeiTorihikiRn(
        String pZrntorihikiymd,
        String pZrntorihikinon7,
        String pZrntaisyakukbnn,
        String pZrnkanjyoukamokucdn,
        String pZrnsuitoubumon,
        String pZrntekiyoucd
    ) {
        super(
            pZrntorihikiymd,
            pZrntorihikinon7,
            pZrntaisyakukbnn,
            pZrnkanjyoukamokucdn,
            pZrnsuitoubumon,
            pZrntekiyoucd
        );
    }

}
