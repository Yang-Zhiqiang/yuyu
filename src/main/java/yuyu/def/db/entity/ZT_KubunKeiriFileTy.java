package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_KubunKeiriFileTy;
import yuyu.def.db.mapping.GenZT_KubunKeiriFileTy;
import yuyu.def.db.meta.GenQZT_KubunKeiriFileTy;
import yuyu.def.db.meta.QZT_KubunKeiriFileTy;

/**
 * 区分経理ファイルテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KubunKeiriFileTy} の JavaDoc を参照してください。
 * @see     GenZT_KubunKeiriFileTy
 * @see     PKZT_KubunKeiriFileTy
 * @see     QZT_KubunKeiriFileTy
 * @see     GenQZT_KubunKeiriFileTy
 */
@Entity
public class ZT_KubunKeiriFileTy extends GenZT_KubunKeiriFileTy {

    private static final long serialVersionUID = 1L;

    public ZT_KubunKeiriFileTy() {
    }

    public ZT_KubunKeiriFileTy(
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
