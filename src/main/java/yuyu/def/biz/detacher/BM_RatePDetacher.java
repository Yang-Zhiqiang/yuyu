package yuyu.def.biz.detacher;

import yuyu.def.db.entity.BM_RateP;

/**
 * Ｐレートマスタ(BM_RateP) デタッチャークラスです。<br />
 */
public class BM_RatePDetacher {

    public static BM_RateP detachRatePtouched(BM_RateP pEntity) {


        if (pEntity != null) {


            pEntity.detach();

            return pEntity;
        }

        return null;
    }
}
