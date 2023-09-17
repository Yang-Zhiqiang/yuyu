package yuyu.def.biz.detacher;

import yuyu.def.db.entity.BM_RateNenkinPkisoV;

/**
 * 年金開始後Ｐ基礎Ｖレートマスタ(BM_RateNenkinPkisoV) デタッチャークラスです。<br />
 */
public class BM_RateNenkinPkisoVDetacher {

    public static BM_RateNenkinPkisoV detachRateNenkinPkisoVtouched(BM_RateNenkinPkisoV pEntity) {


        if (pEntity != null) {


            pEntity.detach();

            return pEntity;
        }

        return null;
    }

}
