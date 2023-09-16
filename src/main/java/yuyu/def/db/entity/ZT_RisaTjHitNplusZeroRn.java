package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_RisaTjHitNplusZeroRn;
import yuyu.def.db.mapping.GenZT_RisaTjHitNplusZeroRn;
import yuyu.def.db.meta.GenQZT_RisaTjHitNplusZeroRn;
import yuyu.def.db.meta.QZT_RisaTjHitNplusZeroRn;

/**
 * 利差のみ通常配当所要額Ｆ（Ｎ＋０）テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RisaTjHitNplusZeroRn} の JavaDoc を参照してください。
 * @see     GenZT_RisaTjHitNplusZeroRn
 * @see     PKZT_RisaTjHitNplusZeroRn
 * @see     QZT_RisaTjHitNplusZeroRn
 * @see     GenQZT_RisaTjHitNplusZeroRn
 */
@Entity
public class ZT_RisaTjHitNplusZeroRn extends GenZT_RisaTjHitNplusZeroRn {

    private static final long serialVersionUID = 1L;

    public ZT_RisaTjHitNplusZeroRn() {
    }

    public ZT_RisaTjHitNplusZeroRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
