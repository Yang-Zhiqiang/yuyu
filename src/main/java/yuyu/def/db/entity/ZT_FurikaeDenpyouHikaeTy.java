package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.biz.bzcommon.FurikaeDenpyouParam;
import yuyu.def.db.id.PKZT_FurikaeDenpyouHikaeTy;
import yuyu.def.db.mapping.GenZT_FurikaeDenpyouHikaeTy;
import yuyu.def.db.meta.GenQZT_FurikaeDenpyouHikaeTy;
import yuyu.def.db.meta.QZT_FurikaeDenpyouHikaeTy;

/**
 * 振替伝票（控）テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_FurikaeDenpyouHikaeTy} の JavaDoc を参照してください。
 * @see     GenZT_FurikaeDenpyouHikaeTy
 * @see     PKZT_FurikaeDenpyouHikaeTy
 * @see     QZT_FurikaeDenpyouHikaeTy
 * @see     GenQZT_FurikaeDenpyouHikaeTy
 */
@Entity
public class ZT_FurikaeDenpyouHikaeTy extends GenZT_FurikaeDenpyouHikaeTy implements FurikaeDenpyouParam {

    private static final long serialVersionUID = 1L;

    public ZT_FurikaeDenpyouHikaeTy() {
    }

    public ZT_FurikaeDenpyouHikaeTy(
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
