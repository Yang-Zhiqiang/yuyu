package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_TjHitsyyugkNplusTwoRn;
import yuyu.def.db.mapping.GenZT_TjHitsyyugkNplusTwoRn;
import yuyu.def.db.meta.GenQZT_TjHitsyyugkNplusTwoRn;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusTwoRn;

/**
 * 通常配当所要額Ｆ（Ｎ＋２）テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TjHitsyyugkNplusTwoRn} の JavaDoc を参照してください。
 * @see     GenZT_TjHitsyyugkNplusTwoRn
 * @see     PKZT_TjHitsyyugkNplusTwoRn
 * @see     QZT_TjHitsyyugkNplusTwoRn
 * @see     GenQZT_TjHitsyyugkNplusTwoRn
 */
@Entity
public class ZT_TjHitsyyugkNplusTwoRn extends GenZT_TjHitsyyugkNplusTwoRn {

    private static final long serialVersionUID = 1L;

    public ZT_TjHitsyyugkNplusTwoRn() {
    }

    public ZT_TjHitsyyugkNplusTwoRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
