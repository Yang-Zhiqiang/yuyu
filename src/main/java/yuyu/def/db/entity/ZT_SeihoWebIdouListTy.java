package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SeihoWebIdouListTy;
import yuyu.def.db.mapping.GenZT_SeihoWebIdouListTy;
import yuyu.def.db.meta.GenQZT_SeihoWebIdouListTy;
import yuyu.def.db.meta.QZT_SeihoWebIdouListTy;

/**
 * 生保Ｗｅｂ異動一覧抽出テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SeihoWebIdouListTy} の JavaDoc を参照してください。
 * @see     GenZT_SeihoWebIdouListTy
 * @see     PKZT_SeihoWebIdouListTy
 * @see     QZT_SeihoWebIdouListTy
 * @see     GenQZT_SeihoWebIdouListTy
 */
@Entity
public class ZT_SeihoWebIdouListTy extends GenZT_SeihoWebIdouListTy {

    private static final long serialVersionUID = 1L;

    public ZT_SeihoWebIdouListTy() {
    }

    public ZT_SeihoWebIdouListTy(
        String pZtysakuseiymd7keta,
        String pZtybsydrtencd,
        String pZtytntusycd,
        String pZtysyono,
        String pZtyhasseiymd,
        String pZtyidoukbn1,
        String pZtykydatkikbnkj,
        String pZtykykyymm,
        String pZtycifcd
    ) {
        super(
            pZtysakuseiymd7keta,
            pZtybsydrtencd,
            pZtytntusycd,
            pZtysyono,
            pZtyhasseiymd,
            pZtyidoukbn1,
            pZtykydatkikbnkj,
            pZtykykyymm,
            pZtycifcd
        );
    }

}
