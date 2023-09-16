package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.biz.bzcommon.FurikaeDenpyouParam;
import yuyu.def.db.id.PKZT_SkKsnHurikaeHikaeTy;
import yuyu.def.db.mapping.GenZT_SkKsnHurikaeHikaeTy;
import yuyu.def.db.meta.GenQZT_SkKsnHurikaeHikaeTy;
import yuyu.def.db.meta.QZT_SkKsnHurikaeHikaeTy;

/**
 * 新契約決算用振替伝票（控）テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkKsnHurikaeHikaeTy} の JavaDoc を参照してください。
 * @see     GenZT_SkKsnHurikaeHikaeTy
 * @see     PKZT_SkKsnHurikaeHikaeTy
 * @see     QZT_SkKsnHurikaeHikaeTy
 * @see     GenQZT_SkKsnHurikaeHikaeTy
 */
@Entity
public class ZT_SkKsnHurikaeHikaeTy extends GenZT_SkKsnHurikaeHikaeTy implements FurikaeDenpyouParam {

    private static final long serialVersionUID = 1L;

    public ZT_SkKsnHurikaeHikaeTy() {
    }

    public ZT_SkKsnHurikaeHikaeTy(
        String pZtytorihikinoc8,
        String pZtytorihikinoedano,
        String pZtytorihikiymdgengokbn,
        String pZtytorihikinen,
        String pZtytorihikituki,
        String pZtytorihikibi
        ) {
        super(
            pZtytorihikinoc8,
            pZtytorihikinoedano,
            pZtytorihikiymdgengokbn,
            pZtytorihikinen,
            pZtytorihikinoc8,
            pZtytorihikibi
            );
    }

}
