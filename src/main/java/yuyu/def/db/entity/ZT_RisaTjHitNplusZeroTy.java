package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.suuri.srcommon.RisanomiTjHitsyyugkParam;
import yuyu.def.db.id.PKZT_RisaTjHitNplusZeroTy;
import yuyu.def.db.mapping.GenZT_RisaTjHitNplusZeroTy;
import yuyu.def.db.meta.GenQZT_RisaTjHitNplusZeroTy;
import yuyu.def.db.meta.QZT_RisaTjHitNplusZeroTy;

/**
 * 利差のみ通常配当所要額Ｆ（Ｎ＋０）テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RisaTjHitNplusZeroTy} の JavaDoc を参照してください。
 * @see     GenZT_RisaTjHitNplusZeroTy
 * @see     PKZT_RisaTjHitNplusZeroTy
 * @see     QZT_RisaTjHitNplusZeroTy
 * @see     GenQZT_RisaTjHitNplusZeroTy
 */
@Entity
public class ZT_RisaTjHitNplusZeroTy extends GenZT_RisaTjHitNplusZeroTy implements RisanomiTjHitsyyugkParam {

    private static final long serialVersionUID = 1L;

    public ZT_RisaTjHitNplusZeroTy() {
    }

    public ZT_RisaTjHitNplusZeroTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
