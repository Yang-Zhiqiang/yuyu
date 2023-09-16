package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SkFurikaeDenpyouRn;
import yuyu.def.db.mapping.GenZT_SkFurikaeDenpyouRn;
import yuyu.def.db.meta.GenQZT_SkFurikaeDenpyouRn;
import yuyu.def.db.meta.QZT_SkFurikaeDenpyouRn;

/**
 * 新契約振替伝票テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkFurikaeDenpyouRn} の JavaDoc を参照してください。
 * @see     GenZT_SkFurikaeDenpyouRn
 * @see     PKZT_SkFurikaeDenpyouRn
 * @see     QZT_SkFurikaeDenpyouRn
 * @see     GenQZT_SkFurikaeDenpyouRn
 */
@Entity
public class ZT_SkFurikaeDenpyouRn extends GenZT_SkFurikaeDenpyouRn {

    private static final long serialVersionUID = 1L;

    public ZT_SkFurikaeDenpyouRn() {
    }

    public ZT_SkFurikaeDenpyouRn(
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
