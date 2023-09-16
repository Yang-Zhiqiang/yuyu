package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_TjHitsyyugkNplusQuartRn;
import yuyu.def.db.mapping.GenZT_TjHitsyyugkNplusQuartRn;
import yuyu.def.db.meta.GenQZT_TjHitsyyugkNplusQuartRn;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusQuartRn;

/**
 * 通常配当所要額Ｆ（Ｎ＋Ｑ）テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TjHitsyyugkNplusQuartRn} の JavaDoc を参照してください。
 * @see     GenZT_TjHitsyyugkNplusQuartRn
 * @see     PKZT_TjHitsyyugkNplusQuartRn
 * @see     QZT_TjHitsyyugkNplusQuartRn
 * @see     GenQZT_TjHitsyyugkNplusQuartRn
 */
@Entity
public class ZT_TjHitsyyugkNplusQuartRn extends GenZT_TjHitsyyugkNplusQuartRn {

    private static final long serialVersionUID = 1L;

    public ZT_TjHitsyyugkNplusQuartRn() {
    }

    public ZT_TjHitsyyugkNplusQuartRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
