package yuyu.def.biz.detacher;

import yuyu.def.db.entity.BM_RateW;

/**
 * Ｗレートマスタ(BM_RateW) デタッチャークラスです。<br />
 */
public class BM_RateWDetacher {

    public static BM_RateW detachRateWtouched(BM_RateW pEntity) {


        if (pEntity != null) {


            pEntity.detach();

            return pEntity;
        }

        return null;
    }
}
