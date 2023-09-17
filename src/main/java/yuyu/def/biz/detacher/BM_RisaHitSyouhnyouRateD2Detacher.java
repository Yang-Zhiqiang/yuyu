package yuyu.def.biz.detacher;

import yuyu.def.db.entity.BM_RisaHitSyouhnyouRateD2;

/**
 * 利差配当商品用Ｄレートマスタ２(BM_RisaHitSyouhnyouRateD2) デタッチャークラスです。<br />
 */
public class BM_RisaHitSyouhnyouRateD2Detacher {

    public static BM_RisaHitSyouhnyouRateD2 detachRisaHitSyouhnyouRateD2touched(BM_RisaHitSyouhnyouRateD2 pEntity) {


        if (pEntity != null) {


            pEntity.detach();

            return pEntity;
        }

        return null;
    }
}
