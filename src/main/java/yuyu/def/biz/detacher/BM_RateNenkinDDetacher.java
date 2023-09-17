package yuyu.def.biz.detacher;

import yuyu.def.db.entity.BM_RateNenkinD;

/**
 * 年金開始後Ｄレートマスタ(BM_RateNenkinD) デタッチャークラスです。<br />
 */
public class BM_RateNenkinDDetacher {

    public static BM_RateNenkinD detachRateNenkinDtouched(BM_RateNenkinD pEntity) {


        if (pEntity != null) {


            pEntity.detach();

            return pEntity;
        }

        return null;
    }
}
