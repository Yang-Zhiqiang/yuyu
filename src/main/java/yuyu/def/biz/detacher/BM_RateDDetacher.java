package yuyu.def.biz.detacher;

import yuyu.def.db.entity.BM_RateD;

/**
 * Ｄレートマスタ(BM_RateD) デタッチャークラスです。<br />
 */
public class BM_RateDDetacher {

    public static BM_RateD detachRateDtouched(BM_RateD pEntity) {


        if (pEntity != null) {


            pEntity.detach();

            return pEntity;
        }

        return null;
    }
}
