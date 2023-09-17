package yuyu.def.biz.detacher;

import yuyu.def.db.entity.BM_RisaHitSyouhnyouRateD;

/**
 * 利差配当商品用Ｄレートマスタ(BM_RisaHitSyouhnyouRateD) デタッチャークラスです。<br />
 */
public class BM_RisaHitSyouhnyouRateDDetacher {

    public static BM_RisaHitSyouhnyouRateD detachRisaHitSyouhnyouRateDtouched(BM_RisaHitSyouhnyouRateD pEntity) {


        if (pEntity != null) {


            pEntity.detach();

            return pEntity;
        }

        return null;
    }
}
