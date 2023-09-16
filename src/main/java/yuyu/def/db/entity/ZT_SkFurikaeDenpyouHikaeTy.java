package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.biz.bzcommon.FurikaeDenpyouParam;
import yuyu.def.db.id.PKZT_SkFurikaeDenpyouHikaeTy;
import yuyu.def.db.mapping.GenZT_SkFurikaeDenpyouHikaeTy;
import yuyu.def.db.meta.GenQZT_SkFurikaeDenpyouHikaeTy;
import yuyu.def.db.meta.QZT_SkFurikaeDenpyouHikaeTy;

/**
 * 新契約振替伝票（控）テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkFurikaeDenpyouHikaeTy} の JavaDoc を参照してください。
 * @see     GenZT_SkFurikaeDenpyouHikaeTy
 * @see     PKZT_SkFurikaeDenpyouHikaeTy
 * @see     QZT_SkFurikaeDenpyouHikaeTy
 * @see     GenQZT_SkFurikaeDenpyouHikaeTy
 */
@Entity
public class ZT_SkFurikaeDenpyouHikaeTy extends GenZT_SkFurikaeDenpyouHikaeTy implements FurikaeDenpyouParam {

    private static final long serialVersionUID = 1L;

    public ZT_SkFurikaeDenpyouHikaeTy() {
    }

    public ZT_SkFurikaeDenpyouHikaeTy(
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
            pZtytorihikituki,
            pZtytorihikibi
            );
    }

}
