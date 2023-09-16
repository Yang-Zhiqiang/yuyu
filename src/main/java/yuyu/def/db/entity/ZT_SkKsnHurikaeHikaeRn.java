package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SkKsnHurikaeHikaeRn;
import yuyu.def.db.mapping.GenZT_SkKsnHurikaeHikaeRn;
import yuyu.def.db.meta.GenQZT_SkKsnHurikaeHikaeRn;
import yuyu.def.db.meta.QZT_SkKsnHurikaeHikaeRn;

/**
 * 新契約決算用振替伝票（控）テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkKsnHurikaeHikaeRn} の JavaDoc を参照してください。
 * @see     GenZT_SkKsnHurikaeHikaeRn
 * @see     PKZT_SkKsnHurikaeHikaeRn
 * @see     QZT_SkKsnHurikaeHikaeRn
 * @see     GenQZT_SkKsnHurikaeHikaeRn
 */
@Entity
public class ZT_SkKsnHurikaeHikaeRn extends GenZT_SkKsnHurikaeHikaeRn {

    private static final long serialVersionUID = 1L;

    public ZT_SkKsnHurikaeHikaeRn() {
    }

    public ZT_SkKsnHurikaeHikaeRn(
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
