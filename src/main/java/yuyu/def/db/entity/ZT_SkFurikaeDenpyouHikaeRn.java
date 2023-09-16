package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SkFurikaeDenpyouHikaeRn;
import yuyu.def.db.mapping.GenZT_SkFurikaeDenpyouHikaeRn;
import yuyu.def.db.meta.GenQZT_SkFurikaeDenpyouHikaeRn;
import yuyu.def.db.meta.QZT_SkFurikaeDenpyouHikaeRn;

/**
 * 新契約振替伝票（控）テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkFurikaeDenpyouHikaeRn} の JavaDoc を参照してください。
 * @see     GenZT_SkFurikaeDenpyouHikaeRn
 * @see     PKZT_SkFurikaeDenpyouHikaeRn
 * @see     QZT_SkFurikaeDenpyouHikaeRn
 * @see     GenQZT_SkFurikaeDenpyouHikaeRn
 */
@Entity
public class ZT_SkFurikaeDenpyouHikaeRn extends GenZT_SkFurikaeDenpyouHikaeRn {

    private static final long serialVersionUID = 1L;

    public ZT_SkFurikaeDenpyouHikaeRn() {
    }

    public ZT_SkFurikaeDenpyouHikaeRn(
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
