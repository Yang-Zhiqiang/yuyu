package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_SkKubunKeiriFileTy;
import yuyu.def.db.mapping.GenZT_SkKubunKeiriFileTy;
import yuyu.def.db.meta.GenQZT_SkKubunKeiriFileTy;
import yuyu.def.db.meta.QZT_SkKubunKeiriFileTy;

/**
 * 新契約区分経理ファイルテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkKubunKeiriFileTy} の JavaDoc を参照してください。
 * @see     GenZT_SkKubunKeiriFileTy
 * @see     PKZT_SkKubunKeiriFileTy
 * @see     QZT_SkKubunKeiriFileTy
 * @see     GenQZT_SkKubunKeiriFileTy
 */
@Entity
public class ZT_SkKubunKeiriFileTy extends GenZT_SkKubunKeiriFileTy {

    private static final long serialVersionUID = 1L;

    public ZT_SkKubunKeiriFileTy() {
    }

    public ZT_SkKubunKeiriFileTy(
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
