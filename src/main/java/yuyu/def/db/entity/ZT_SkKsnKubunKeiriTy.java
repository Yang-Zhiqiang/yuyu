package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_SkKsnKubunKeiriTy;
import yuyu.def.db.mapping.GenZT_SkKsnKubunKeiriTy;
import yuyu.def.db.meta.GenQZT_SkKsnKubunKeiriTy;
import yuyu.def.db.meta.QZT_SkKsnKubunKeiriTy;

/**
 * 新契約決算用区分経理Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkKsnKubunKeiriTy} の JavaDoc を参照してください。
 * @see     GenZT_SkKsnKubunKeiriTy
 * @see     PKZT_SkKsnKubunKeiriTy
 * @see     QZT_SkKsnKubunKeiriTy
 * @see     GenQZT_SkKsnKubunKeiriTy
 */
@Entity
public class ZT_SkKsnKubunKeiriTy extends GenZT_SkKsnKubunKeiriTy {

    private static final long serialVersionUID = 1L;

    public ZT_SkKsnKubunKeiriTy() {
    }

    public ZT_SkKsnKubunKeiriTy(
        String pZtytorihikiymd,
        String pZtytorihikinon7,
        String pZtytaisyakukbnn,
        String pZtykanjyoukamokucdn,
        String pZtysuitoubumoncd,
        String pZtykizokusegment,
        String pZtyaitesegment
        ) {
        super(
            pZtytorihikiymd,
            pZtytorihikinon7,
            pZtytaisyakukbnn,
            pZtykanjyoukamokucdn,
            pZtysuitoubumoncd,
            pZtykizokusegment,
            pZtyaitesegment
            );
    }

}
