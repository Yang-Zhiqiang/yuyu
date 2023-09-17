package yuyu.def.biz.detacher;

import yuyu.def.db.entity.BM_RateV2;

/**
 * Ｖレートマスタ２(BM_RateV2) デタッチャークラスです。<br />
 */
public class BM_RateV2Detacher {

    public static BM_RateV2 detachRateV2touched(BM_RateV2 pEntity) {


        if (pEntity != null) {


            pEntity.detach();

            return pEntity;
        }

        return null;
    }
}
