package yuyu.def.biz.detacher;

import yuyu.def.db.entity.BM_RateV;

/**
 * Ｖレートマスタ(BM_RateV) デタッチャークラスです。<br />
 */
public class BM_RateVDetacher {

    public static BM_RateV detachRateVtouched(BM_RateV pEntity) {


        if (pEntity != null) {


            pEntity.detach();

            return pEntity;
        }

        return null;
    }
}
