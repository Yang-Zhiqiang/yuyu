package yuyu.def.biz.detacher;

import yuyu.def.db.entity.BM_RateP2;

/**
 * Ｐレートマスタ２(BM_RateP2) デタッチャークラスです。<br />
 */
public class BM_RateP2Detacher {

    public static BM_RateP2 detachRateP2touched(BM_RateP2 pEntity) {


        if (pEntity != null) {


            pEntity.detach();

            return pEntity;
        }

        return null;
    }
}
