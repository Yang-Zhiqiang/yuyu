package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SkKsnHurikaeRn;
import yuyu.def.db.mapping.GenZT_SkKsnHurikaeRn;
import yuyu.def.db.meta.GenQZT_SkKsnHurikaeRn;
import yuyu.def.db.meta.QZT_SkKsnHurikaeRn;

/**
 * 新契約決算用振替伝票テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SkKsnHurikaeRn} の JavaDoc を参照してください。
 * @see     GenZT_SkKsnHurikaeRn
 * @see     PKZT_SkKsnHurikaeRn
 * @see     QZT_SkKsnHurikaeRn
 * @see     GenQZT_SkKsnHurikaeRn
 */
@Entity
public class ZT_SkKsnHurikaeRn extends GenZT_SkKsnHurikaeRn {

    private static final long serialVersionUID = 1L;

    public ZT_SkKsnHurikaeRn() {
    }

    public ZT_SkKsnHurikaeRn(
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
