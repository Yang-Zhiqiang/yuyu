package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_TjHitsyyugkNplusOneRn;
import yuyu.def.db.mapping.GenZT_TjHitsyyugkNplusOneRn;
import yuyu.def.db.meta.GenQZT_TjHitsyyugkNplusOneRn;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusOneRn;

/**
 * 通常配当所要額Ｆ（Ｎ＋１）テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TjHitsyyugkNplusOneRn} の JavaDoc を参照してください。
 * @see     GenZT_TjHitsyyugkNplusOneRn
 * @see     PKZT_TjHitsyyugkNplusOneRn
 * @see     QZT_TjHitsyyugkNplusOneRn
 * @see     GenQZT_TjHitsyyugkNplusOneRn
 */
@Entity
public class ZT_TjHitsyyugkNplusOneRn extends GenZT_TjHitsyyugkNplusOneRn {

    private static final long serialVersionUID = 1L;

    public ZT_TjHitsyyugkNplusOneRn() {
    }

    public ZT_TjHitsyyugkNplusOneRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
