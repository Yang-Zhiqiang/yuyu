package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_TjHitsyyugkNplusZeroRn;
import yuyu.def.db.mapping.GenZT_TjHitsyyugkNplusZeroRn;
import yuyu.def.db.meta.GenQZT_TjHitsyyugkNplusZeroRn;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusZeroRn;

/**
 * 通常配当所要額Ｆ（Ｎ＋０）テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TjHitsyyugkNplusZeroRn} の JavaDoc を参照してください。
 * @see     GenZT_TjHitsyyugkNplusZeroRn
 * @see     PKZT_TjHitsyyugkNplusZeroRn
 * @see     QZT_TjHitsyyugkNplusZeroRn
 * @see     GenQZT_TjHitsyyugkNplusZeroRn
 */
@Entity
public class ZT_TjHitsyyugkNplusZeroRn extends GenZT_TjHitsyyugkNplusZeroRn {

    private static final long serialVersionUID = 1L;

    public ZT_TjHitsyyugkNplusZeroRn() {
    }

    public ZT_TjHitsyyugkNplusZeroRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
