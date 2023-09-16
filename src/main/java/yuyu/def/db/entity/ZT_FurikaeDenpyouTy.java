package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.biz.bzcommon.FurikaeDenpyouParam;
import yuyu.def.db.id.PKZT_FurikaeDenpyouTy;
import yuyu.def.db.mapping.GenZT_FurikaeDenpyouTy;
import yuyu.def.db.meta.GenQZT_FurikaeDenpyouTy;
import yuyu.def.db.meta.QZT_FurikaeDenpyouTy;

/**
 * 振替伝票テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_FurikaeDenpyouTy} の JavaDoc を参照してください。
 * @see     GenZT_FurikaeDenpyouTy
 * @see     PKZT_FurikaeDenpyouTy
 * @see     QZT_FurikaeDenpyouTy
 * @see     GenQZT_FurikaeDenpyouTy
 */
@Entity
public class ZT_FurikaeDenpyouTy extends GenZT_FurikaeDenpyouTy implements FurikaeDenpyouParam {

    private static final long serialVersionUID = 1L;

    public ZT_FurikaeDenpyouTy() {
    }

    public ZT_FurikaeDenpyouTy(
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
