package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.biz.bzcommon.FurikaeDenpyouParam;
import yuyu.def.db.id.PKZT_SkFurikaeDenpyouTy;
import yuyu.def.db.mapping.GenZT_SkFurikaeDenpyouTy;
import yuyu.def.db.meta.GenQZT_SkFurikaeDenpyouTy;
import yuyu.def.db.meta.QZT_SkFurikaeDenpyouTy;

/**
 * 新契約振替伝票テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkFurikaeDenpyouTy} の JavaDoc を参照してください。
 * @see     GenZT_SkFurikaeDenpyouTy
 * @see     PKZT_SkFurikaeDenpyouTy
 * @see     QZT_SkFurikaeDenpyouTy
 * @see     GenQZT_SkFurikaeDenpyouTy
 */
@Entity
public class ZT_SkFurikaeDenpyouTy extends GenZT_SkFurikaeDenpyouTy implements FurikaeDenpyouParam {

    private static final long serialVersionUID = 1L;

    public ZT_SkFurikaeDenpyouTy() {
    }

    public ZT_SkFurikaeDenpyouTy(
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
