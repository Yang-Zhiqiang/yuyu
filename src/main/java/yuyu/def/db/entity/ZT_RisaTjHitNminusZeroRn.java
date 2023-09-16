package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_RisaTjHitNminusZeroRn;
import yuyu.def.db.mapping.GenZT_RisaTjHitNminusZeroRn;
import yuyu.def.db.meta.GenQZT_RisaTjHitNminusZeroRn;
import yuyu.def.db.meta.QZT_RisaTjHitNminusZeroRn;

/**
 * 利差のみ通常配当所要額Ｆ（Ｎ－０）テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RisaTjHitNminusZeroRn} の JavaDoc を参照してください。
 * @see     GenZT_RisaTjHitNminusZeroRn
 * @see     PKZT_RisaTjHitNminusZeroRn
 * @see     QZT_RisaTjHitNminusZeroRn
 * @see     GenQZT_RisaTjHitNminusZeroRn
 */
@Entity
public class ZT_RisaTjHitNminusZeroRn extends GenZT_RisaTjHitNminusZeroRn {

    private static final long serialVersionUID = 1L;

    public ZT_RisaTjHitNminusZeroRn() {
    }

    public ZT_RisaTjHitNminusZeroRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
