package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.suuri.srcommon.RisanomiTjHitsyyugkParam;
import yuyu.def.db.id.PKZT_RisaTjHitNminusZeroTy;
import yuyu.def.db.mapping.GenZT_RisaTjHitNminusZeroTy;
import yuyu.def.db.meta.GenQZT_RisaTjHitNminusZeroTy;
import yuyu.def.db.meta.QZT_RisaTjHitNminusZeroTy;

/**
 * 利差のみ通常配当所要額Ｆ（Ｎ－０）テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RisaTjHitNminusZeroTy} の JavaDoc を参照してください。
 * @see     GenZT_RisaTjHitNminusZeroTy
 * @see     PKZT_RisaTjHitNminusZeroTy
 * @see     QZT_RisaTjHitNminusZeroTy
 * @see     GenQZT_RisaTjHitNminusZeroTy
 */
@Entity
public class ZT_RisaTjHitNminusZeroTy extends GenZT_RisaTjHitNminusZeroTy implements RisanomiTjHitsyyugkParam {

    private static final long serialVersionUID = 1L;

    public ZT_RisaTjHitNminusZeroTy() {
    }

    public ZT_RisaTjHitNminusZeroTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
