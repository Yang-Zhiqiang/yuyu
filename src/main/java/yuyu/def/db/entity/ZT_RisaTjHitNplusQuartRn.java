package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_RisaTjHitNplusQuartRn;
import yuyu.def.db.mapping.GenZT_RisaTjHitNplusQuartRn;
import yuyu.def.db.meta.GenQZT_RisaTjHitNplusQuartRn;
import yuyu.def.db.meta.QZT_RisaTjHitNplusQuartRn;

/**
 * 利差のみ通常配当所要額Ｆ（Ｎ＋Ｑ）テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RisaTjHitNplusQuartRn} の JavaDoc を参照してください。
 * @see     GenZT_RisaTjHitNplusQuartRn
 * @see     PKZT_RisaTjHitNplusQuartRn
 * @see     QZT_RisaTjHitNplusQuartRn
 * @see     GenQZT_RisaTjHitNplusQuartRn
 */
@Entity
public class ZT_RisaTjHitNplusQuartRn extends GenZT_RisaTjHitNplusQuartRn {

    private static final long serialVersionUID = 1L;

    public ZT_RisaTjHitNplusQuartRn() {
    }

    public ZT_RisaTjHitNplusQuartRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
