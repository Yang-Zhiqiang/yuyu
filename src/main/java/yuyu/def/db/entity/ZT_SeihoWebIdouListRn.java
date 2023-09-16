package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SeihoWebIdouListRn;
import yuyu.def.db.mapping.GenZT_SeihoWebIdouListRn;
import yuyu.def.db.meta.GenQZT_SeihoWebIdouListRn;
import yuyu.def.db.meta.QZT_SeihoWebIdouListRn;

/**
 * 生保Ｗｅｂ異動一覧抽出テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SeihoWebIdouListRn} の JavaDoc を参照してください。
 * @see     GenZT_SeihoWebIdouListRn
 * @see     PKZT_SeihoWebIdouListRn
 * @see     QZT_SeihoWebIdouListRn
 * @see     GenQZT_SeihoWebIdouListRn
 */
@Entity
public class ZT_SeihoWebIdouListRn extends GenZT_SeihoWebIdouListRn {

    private static final long serialVersionUID = 1L;

    public ZT_SeihoWebIdouListRn() {
    }

    public ZT_SeihoWebIdouListRn(
        Long pZrnsakuseiymd7keta,
        String pZrnbsydrtencd,
        String pZrntntusycd,
        String pZrnsyono,
        String pZrnhasseiymd,
        String pZrnidoukbn1,
        String pZrnkydatkikbnkj,
        String pZrnkykyymm,
        String pZrncifcd
    ) {
        super(
            pZrnsakuseiymd7keta,
            pZrnbsydrtencd,
            pZrntntusycd,
            pZrnsyono,
            pZrnhasseiymd,
            pZrnidoukbn1,
            pZrnkydatkikbnkj,
            pZrnkykyymm,
            pZrncifcd
        );
    }

}
