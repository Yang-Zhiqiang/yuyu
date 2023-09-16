package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_TjHitsyyugkNminusZeroRn;
import yuyu.def.db.mapping.GenZT_TjHitsyyugkNminusZeroRn;
import yuyu.def.db.meta.GenQZT_TjHitsyyugkNminusZeroRn;
import yuyu.def.db.meta.QZT_TjHitsyyugkNminusZeroRn;

/**
 * 通常配当所要額Ｆ（Ｎ－０）テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TjHitsyyugkNminusZeroRn} の JavaDoc を参照してください。
 * @see     GenZT_TjHitsyyugkNminusZeroRn
 * @see     PKZT_TjHitsyyugkNminusZeroRn
 * @see     QZT_TjHitsyyugkNminusZeroRn
 * @see     GenQZT_TjHitsyyugkNminusZeroRn
 */
@Entity
public class ZT_TjHitsyyugkNminusZeroRn extends GenZT_TjHitsyyugkNminusZeroRn {

    private static final long serialVersionUID = 1L;

    public ZT_TjHitsyyugkNminusZeroRn() {
    }

    public ZT_TjHitsyyugkNminusZeroRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
