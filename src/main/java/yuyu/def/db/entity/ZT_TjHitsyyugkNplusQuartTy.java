package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.suuri.srcommon.TuujyuHitusyyugkParam;
import yuyu.def.db.id.PKZT_TjHitsyyugkNplusQuartTy;
import yuyu.def.db.mapping.GenZT_TjHitsyyugkNplusQuartTy;
import yuyu.def.db.meta.GenQZT_TjHitsyyugkNplusQuartTy;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusQuartTy;

/**
 * 通常配当所要額Ｆ（Ｎ＋Ｑ）テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TjHitsyyugkNplusQuartTy} の JavaDoc を参照してください。
 * @see     GenZT_TjHitsyyugkNplusQuartTy
 * @see     PKZT_TjHitsyyugkNplusQuartTy
 * @see     QZT_TjHitsyyugkNplusQuartTy
 * @see     GenQZT_TjHitsyyugkNplusQuartTy
 */
@Entity
public class ZT_TjHitsyyugkNplusQuartTy extends GenZT_TjHitsyyugkNplusQuartTy implements TuujyuHitusyyugkParam {

    private static final long serialVersionUID = 1L;

    public ZT_TjHitsyyugkNplusQuartTy() {
    }

    public ZT_TjHitsyyugkNplusQuartTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
