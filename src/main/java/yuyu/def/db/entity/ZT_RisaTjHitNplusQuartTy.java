package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.suuri.srcommon.RisanomiTjHitsyyugkParam;
import yuyu.def.db.id.PKZT_RisaTjHitNplusQuartTy;
import yuyu.def.db.mapping.GenZT_RisaTjHitNplusQuartTy;
import yuyu.def.db.meta.GenQZT_RisaTjHitNplusQuartTy;
import yuyu.def.db.meta.QZT_RisaTjHitNplusQuartTy;

/**
 * 利差のみ通常配当所要額Ｆ（Ｎ＋Ｑ）テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RisaTjHitNplusQuartTy} の JavaDoc を参照してください。
 * @see     GenZT_RisaTjHitNplusQuartTy
 * @see     PKZT_RisaTjHitNplusQuartTy
 * @see     QZT_RisaTjHitNplusQuartTy
 * @see     GenQZT_RisaTjHitNplusQuartTy
 */
@Entity
public class ZT_RisaTjHitNplusQuartTy extends GenZT_RisaTjHitNplusQuartTy implements RisanomiTjHitsyyugkParam {

    private static final long serialVersionUID = 1L;

    public ZT_RisaTjHitNplusQuartTy() {
    }

    public ZT_RisaTjHitNplusQuartTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
