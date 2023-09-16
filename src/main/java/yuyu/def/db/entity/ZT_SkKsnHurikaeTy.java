package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.biz.bzcommon.FurikaeDenpyouParam;
import yuyu.def.db.id.PKZT_SkKsnHurikaeTy;
import yuyu.def.db.mapping.GenZT_SkKsnHurikaeTy;
import yuyu.def.db.meta.GenQZT_SkKsnHurikaeTy;
import yuyu.def.db.meta.QZT_SkKsnHurikaeTy;

/**
 * 新契約決算用振替伝票テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkKsnHurikaeTy} の JavaDoc を参照してください。
 * @see     GenZT_SkKsnHurikaeTy
 * @see     PKZT_SkKsnHurikaeTy
 * @see     QZT_SkKsnHurikaeTy
 * @see     GenQZT_SkKsnHurikaeTy
 */
@Entity
public class ZT_SkKsnHurikaeTy extends GenZT_SkKsnHurikaeTy implements FurikaeDenpyouParam {

    private static final long serialVersionUID = 1L;

    public ZT_SkKsnHurikaeTy() {
    }

    public ZT_SkKsnHurikaeTy(
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
