package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_FurikaeDenpyouRn;
import yuyu.def.db.mapping.GenZT_FurikaeDenpyouRn;
import yuyu.def.db.meta.GenQZT_FurikaeDenpyouRn;
import yuyu.def.db.meta.QZT_FurikaeDenpyouRn;

/**
 * 振替伝票テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_FurikaeDenpyouRn} の JavaDoc を参照してください。
 * @see     GenZT_FurikaeDenpyouRn
 * @see     PKZT_FurikaeDenpyouRn
 * @see     QZT_FurikaeDenpyouRn
 * @see     GenQZT_FurikaeDenpyouRn
 */
@Entity
public class ZT_FurikaeDenpyouRn extends GenZT_FurikaeDenpyouRn {

    private static final long serialVersionUID = 1L;

    public ZT_FurikaeDenpyouRn() {
    }

    public ZT_FurikaeDenpyouRn(
        String pZrntorihikinoc8,
        String pZrntorihikinoedano,
        String pZrntorihikiymdgengokbn,
        String pZrntorihikinen,
        String pZrntorihikituki,
        String pZrntorihikibi
    ) {
        super(
            pZrntorihikinoc8,
            pZrntorihikinoedano,
            pZrntorihikiymdgengokbn,
            pZrntorihikinen,
            pZrntorihikituki,
            pZrntorihikibi
        );
    }

}
