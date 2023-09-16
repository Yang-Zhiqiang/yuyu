package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SkKaikeiTorihikiFileRn;
import yuyu.def.db.mapping.GenZT_SkKaikeiTorihikiFileRn;
import yuyu.def.db.meta.GenQZT_SkKaikeiTorihikiFileRn;
import yuyu.def.db.meta.QZT_SkKaikeiTorihikiFileRn;

/**
 * 新契約会計取引ファイルテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkKaikeiTorihikiFileRn} の JavaDoc を参照してください。
 * @see     GenZT_SkKaikeiTorihikiFileRn
 * @see     PKZT_SkKaikeiTorihikiFileRn
 * @see     QZT_SkKaikeiTorihikiFileRn
 * @see     GenQZT_SkKaikeiTorihikiFileRn
 */
@Entity
public class ZT_SkKaikeiTorihikiFileRn extends GenZT_SkKaikeiTorihikiFileRn {

    private static final long serialVersionUID = 1L;

    public ZT_SkKaikeiTorihikiFileRn() {
    }

    public ZT_SkKaikeiTorihikiFileRn(
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
