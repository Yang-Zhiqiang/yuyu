package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_FurikaeDenpyouHikaeRn;
import yuyu.def.db.mapping.GenZT_FurikaeDenpyouHikaeRn;
import yuyu.def.db.meta.GenQZT_FurikaeDenpyouHikaeRn;
import yuyu.def.db.meta.QZT_FurikaeDenpyouHikaeRn;

/**
 * 振替伝票（控）テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_FurikaeDenpyouHikaeRn} の JavaDoc を参照してください。
 * @see     GenZT_FurikaeDenpyouHikaeRn
 * @see     PKZT_FurikaeDenpyouHikaeRn
 * @see     QZT_FurikaeDenpyouHikaeRn
 * @see     GenQZT_FurikaeDenpyouHikaeRn
 */
@Entity
public class ZT_FurikaeDenpyouHikaeRn extends GenZT_FurikaeDenpyouHikaeRn {

    private static final long serialVersionUID = 1L;

    public ZT_FurikaeDenpyouHikaeRn() {
    }

    public ZT_FurikaeDenpyouHikaeRn(
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
