package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_KaikeiTorihikiFileTy;
import yuyu.def.db.mapping.GenZT_KaikeiTorihikiFileTy;
import yuyu.def.db.meta.GenQZT_KaikeiTorihikiFileTy;
import yuyu.def.db.meta.QZT_KaikeiTorihikiFileTy;

/**
 * 会計取引ファイルテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KaikeiTorihikiFileTy} の JavaDoc を参照してください。
 * @see     GenZT_KaikeiTorihikiFileTy
 * @see     PKZT_KaikeiTorihikiFileTy
 * @see     QZT_KaikeiTorihikiFileTy
 * @see     GenQZT_KaikeiTorihikiFileTy
 */
@Entity
public class ZT_KaikeiTorihikiFileTy extends GenZT_KaikeiTorihikiFileTy {

    private static final long serialVersionUID = 1L;

    public ZT_KaikeiTorihikiFileTy() {
    }

    public ZT_KaikeiTorihikiFileTy(
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
