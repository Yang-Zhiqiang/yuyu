package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KaikeiTorihikiFileRn;
import yuyu.def.db.mapping.GenZT_KaikeiTorihikiFileRn;
import yuyu.def.db.meta.GenQZT_KaikeiTorihikiFileRn;
import yuyu.def.db.meta.QZT_KaikeiTorihikiFileRn;

/**
 * 会計取引ファイルテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KaikeiTorihikiFileRn} の JavaDoc を参照してください。
 * @see     GenZT_KaikeiTorihikiFileRn
 * @see     PKZT_KaikeiTorihikiFileRn
 * @see     QZT_KaikeiTorihikiFileRn
 * @see     GenQZT_KaikeiTorihikiFileRn
 */
@Entity
public class ZT_KaikeiTorihikiFileRn extends GenZT_KaikeiTorihikiFileRn {

    private static final long serialVersionUID = 1L;

    public ZT_KaikeiTorihikiFileRn() {
    }

    public ZT_KaikeiTorihikiFileRn(
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
